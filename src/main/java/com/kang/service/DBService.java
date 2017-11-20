/**
 * 
 */
package com.kang.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kang.dao.BaseDAO;
import com.kang.model.HConstants;
import com.kang.model.LoginUser;
import com.kang.model.UserData;
import com.kang.model.UserGroup;
import com.kang.util.Utils;

/**
 * 数据库service
 * 
 * @param <T>
 */
@Service("dBService")
public class DBService {

	private Logger log = LoggerFactory.getLogger(DBService.class);
	// @Resource
	// private BaseDAO<HConstants> baseDaoHConst ;
	// @Resource
	// private BaseDAO<LoginUser> baseDaoLU;
	// @Resource
	// private BaseDAO<UserData> baseDaoUD;
	@Resource
	private BaseDAO<Object> baseDao;

	/**
	 * 用户登录检查
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean getLoginUser(String username, String password) {
		String hql = "from LoginUser lu where lu.username='" + username + "'";
		List<Object> lus = baseDao.find(hql);
		if (lus.size() < 1) {
			log.info("没有此用户，username：{}", username);
			return false;
		}
		if (lus.size() > 1) {
			log.info("登录检查多个重名用户，请检查数据库，用户名为：{}", username);
			return false;
		}
		LoginUser lu = (LoginUser) lus.get(0);
		if (lu.getPassword().equals(password)) {
			log.info("用户：'" + username + "' 登录成功！");
			return true;
		}
		return false;
	}

	/**
	 * 测试表中是否有数据
	 * 
	 * @param tableName
	 * @return
	 */
	public boolean getTableData(String tableName) {
		String hql = "from " + tableName + " ";
		List<Object> td = baseDao.find(hql);
		if (td.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获得tableName的所有数据并返回
	 * 
	 * @param tableName
	 * @return
	 */
	public List<Object> getTableAllData(String tableName) {
		String hql = "from " + tableName + " ";
		List<Object> list = null;
		try {
			list = baseDao.find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 分页获取tableName 所有数据
	 * 
	 * @param tableName:类实体名
	 * @param rows
	 * @param page
	 * @return
	 */
	public Map<String, Object> getTableData(String tableName, int rows, int page) {
		String hql = "from " + tableName;
		String hqlCount = "select count(1) from " + tableName;
		List<Object> list = baseDao.find(hql, new Object[] {}, page, rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", baseDao.count(hqlCount));
		jsonMap.put("rows", list);
		return jsonMap;
	}

	/**
	 * 保存数据
	 * 
	 * @param tableName
	 * @param list
	 * @return
	 */
	public boolean saveTableData(List<Object> list) {

		try {
			baseDao.saveBatch(list);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean deleteById(String tableName, String id) {
		String hql = "delete " + tableName + "  tb where tb.id='" + id + "'";
		try {
			Integer ret = baseDao.executeHql(hql);
			log.info("删除表{},删除了{}条记录！", new Object[] { tableName, ret });
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * 根据数据表的名称删除数据表
	 */
	public boolean deleteTable(String tableName) {
		String hql = "delete " + tableName;
		try {
			Integer ret = baseDao.executeHql(hql);
			log.info("删除表{},删除了{}条记录！", new Object[] { tableName, ret });
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新或者插入表 不用每个表都建立一个方法，这里根据表名自动装配
	 * 
	 * @param tableName
	 * @param json
	 * @return
	 */
	public boolean updateOrSave(String tableName, String json) {
		try {
			// 根据表名获得全类名并创建相应的实体类，并赋值
			Object o = Utils.getEntity(Utils.getEntityPackages(tableName), json);
			baseDao.saveOrUpdate(o);
			log.info("保存表{}！", new Object[] { tableName });
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 获得Hadoop集群配置
	 * 
	 * @param key
	 * @return
	 */
	public String getHConstValue(String key) {
		HConstants hc = null;
		try {
			hc = (HConstants) baseDao.find("from HConstants hc where hc.custKey='" + key + "'").get(0);
			if (hc == null) {
				log.info("Hadoop基础配置表找不到配置的key：{}", key);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("获取云平台配置信息出错，key：" + key);
		}
		return hc.getCustValue();
	}

	/**
	 * 初始化登录表
	 * 
	 * @param tableName
	 * @return
	 */
	public boolean insertLoginUser() {
		try {
			baseDao.executeHql("delete LoginUser");
			baseDao.save(new LoginUser("admin", "admin"));
			baseDao.save(new LoginUser("test", "test"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 初始化HConstants
	 * 
	 * @return
	 */
	public boolean insertHConstants() {// 初始化hadoop集群表（需要将其初始化为自己的hadoop配置信息）
		try {
			baseDao.executeHql("delete HConstants");
			baseDao.save(new HConstants("mapreduce.app-submission.cross-platform", "true", "是否跨平台提交任务"));
			baseDao.save(new HConstants("fs.defaultFS", "hdfs://sparkproject1:9000", "namenode主机及端口"));
			baseDao.save(new HConstants("mapreduce.framework.name", "yarn", "mapreduce 使用配置"));
			baseDao.save(new HConstants("yarn.resourcemanager.address", "sparkproject1:8032", "ResourceManager主机及端口"));
			baseDao.save(
					new HConstants("yarn.resourcemanager.scheduler.address", "sparkproject1:8030", "Scheduler主机及端口"));
			baseDao.save(new HConstants("mapreduce.jobhistory.address", "sparkproject1:10020", "JobHistory主机及端口"));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 初始化UserData 此处使用批量插入 直接插入，后期可以考虑使用jdbc的批量插入
	 * 
	 * @return
	 */
	public boolean insertUserData() {
		try {
			baseDao.executeHql("delete UserData");
			List<String[]> strings = Utils.parseXml2StrArr(null);// 默认读取初始化表
			List<Object> uds = new ArrayList<Object>();
			for (String[] s : strings) {
				uds.add(new UserData(s));
			}
			int ret = baseDao.saveBatch(uds);
			log.info("用户表批量插入了{}条记录!", ret);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 批量插入数据
	 * 
	 * @param xmlPath
	 * @return
	 */
	public Map<String, Object> insertUserData(String xmlPath) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			baseDao.executeHql("delete UserData");
			List<String[]> strings = Utils.parseDatFolder2StrArr(xmlPath);
			List<Object> uds = new ArrayList<Object>();
			for (String[] s : strings) {
				uds.add(new UserData(s));
			}
			int ret = baseDao.saveBatch(uds);
			log.info("用户表批量插入了{}条记录!", ret);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("msg", e.getMessage());
			return map;
		}
		map.put("flag", "true");
		return map;
	}

	public boolean insertUserData_b() {
		try {
			baseDao.executeHql("delete UserData");
			List<String[]> strings = Utils.parseXml2StrArr(null);
			// List<Object> uds = new ArrayList<Object>();
			int ret = 0;
			// for(String[] s:strings){
			// baseDao.save(new UserData(s));
			// ret++;
			// if(ret%1000==0){
			// log.info("用户表批量插入了{}条记录...",ret);
			// }
			// }
			baseDao.save(new UserData(strings.get(0)));
			// int ret =baseDao.saveBatch(uds);
			log.info("用户表批量插入了{}条记录!", ret);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param tableName
	 * @param ids
	 * @return
	 */
	public List<UserData> getTableData(String tableName, List<Integer> ids) {
		List<UserData> uds = new ArrayList<UserData>();
		String hql = "from " + tableName + " ud where ud.id=?";
		for (Integer id : ids) {
			uds.add((UserData) baseDao.find(hql, new Object[] { id }).get(0));
		}
		return uds;
	}

	/**
	 * 获取分类数据占比
	 * 
	 * @param i
	 * @return
	 */
	public List<String> getPercent(int k) {
		double[] percents = new double[k];
		double sum = 0;
		String hql = "select count(1) from UserGroup ug where ug.groupType=?";
		for (int i = 0; i < k; i++) {
			percents[i] = baseDao.count(hql, new Object[] { i + 1 });//查找属于聚类中心i的数据个数
			sum += percents[i];//统计数据总数
		}
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < k; i++) {
			list.add(Utils.obejct2Percent(percents[i] / sum, 2));// 计算每个聚类簇中数目的百分比，保留两位小数
		}
		return list;
	}

	/**
	 * 获取推荐信息
	 * 1. 根据id查询UserGroup看是否有记录； 
	 * 2. 如有记录，则用户有推荐的朋友；跳转到4；
	 * 3. 如果没有，则返回说当前用户没有分组； 
	 * 4. 根据查询的groupType再次查询所有该组的id； 
	 * 5. 根据4中的id去UserData中查找数据并显示；
	 * 
	 * @param id
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getRecommendData(String id, int rows, int page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from UserGroup ug where ug.userId=?";
		Object ug = null;
		try {
			ug = baseDao.get(hql, new Object[] { Integer.parseInt(id) });
			if (ug == null) {//
				map.put("flag", "false");
				map.put("html", "当前用户没有分组,不能推荐朋友！");
				map.put("msg", "当天用户没有分组!");
				return map;
			}
			UserGroup userG = (UserGroup) ug;
			int groupType = userG.getGroupType();
			hql = "select count(1) from UserGroup ug where ug.groupType=?";
			long total = (long) baseDao.count(hql, new Object[] { groupType });
			hql = "from UserGroup ug where ug.groupType=?";
			List<Object> userGroups = baseDao.find(hql, new Object[] { groupType }, page, rows);

			List<UserData> userDatas = new ArrayList<UserData>();
			UserData ud = null;
			hql = "from UserData ud where ud.id=?";
			for (Object u : userGroups) {
				userG = (UserGroup) u;
				ud = (UserData) baseDao.get(hql, new Object[] { userG.getUserId() });
				userDatas.add(ud);
			}
			map.put("flag", "true");
			map.put("html", "当前用户的分组是：" + groupType + ",下面是该用户的推荐朋友：");
			map.put("total", total);
			map.put("rows", userDatas);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "false");
			map.put("html", "后台运行出错！");
			map.put("msg", "后台运行出错!");
			throw e;
		}

		return map;
	}

	// public BaseDAO<HConstants> getBaseDaoHConst() {
	// return baseDaoHConst;
	// }
	// public void setBaseDaoHConst(BaseDAO<HConstants> baseDaoHConst) {
	// this.baseDaoHConst = baseDaoHConst;
	// }
	// public BaseDAO<LoginUser> getBaseDaoLU() {
	// return baseDaoLU;
	// }
	// public void setBaseDaoLU(BaseDAO<LoginUser> baseDaoLU) {
	// this.baseDaoLU = baseDaoLU;
	// }
	// public BaseDAO<UserData> getBaseDaoUD() {
	// return baseDaoUD;
	// }
	// public void setBaseDaoUD(BaseDAO<UserData> baseDaoUD) {
	// this.baseDaoUD = baseDaoUD;
	// }

}
