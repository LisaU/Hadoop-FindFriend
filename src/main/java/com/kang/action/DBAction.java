package com.kang.action;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.kang.service.DBService;
import com.kang.util.Utils;
import com.opensymphony.xwork2.ActionSupport;

@Component("dBAction")
public class DBAction extends ActionSupport {
	/**
	 * 处理基础数据的action
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = LoggerFactory.getLogger(DBAction.class);
	@Resource
	private DBService dBService;
	private int rows;
	private int page;
	private String tableName;
	
	private String id;
	
	private String json;
	
	/**
	 * 根据tableName分页获取表数据
	 */
	public void getTableData(){
		Map<String,Object> list = dBService.getTableData(tableName,rows, page);
		String json =JSON.toJSONString(list);
		log.info(json);
		Utils.write2PrintWriter(json);
	}
	
	/**
	 * 获取推荐信息
	 */
	public void getRecommendData(){
		Map<String,Object> map = null;
		
		try{
			map=dBService.getRecommendData(id,rows,page);
		}catch(Exception e){
			e.printStackTrace();
		}
		String json =JSON.toJSONString(map);
		log.info(json);
		Utils.write2PrintWriter(json);
		return ;
	}
	
	/**
	 * 按照id删除表中数据
	 */
	public void deleteById(){
		boolean delSuccess =dBService.deleteById(tableName, id);
		String msg="fail";
		if(delSuccess){
			msg="success";
		}
		log.info("删除表"+tableName+(delSuccess?"成功":"失败"+"!"));
		Utils.write2PrintWriter(msg);
	}
	
	/**
	 * 更新或者保存数据
	 */
	public void updateOrSave(){
		boolean delSuccess =dBService.updateOrSave(tableName, json);
		String msg="fail";
		if(delSuccess){
			msg="success";
		}
		log.info("保存表"+tableName+(delSuccess?"成功":"失败"+"!"));
		Utils.write2PrintWriter(msg);
	}
	/**
	 * 初始化表 
	 */
	public void initialTable(){
		boolean initRet = false;
		if("LoginUser".equals(tableName)){//初始登录表
			initRet=dBService.insertLoginUser();
		}else if("HConstants".equals(tableName)){//初始化集群配置表
			initRet=dBService.insertHConstants();
		}else{
			initRet = dBService.insertUserData();//初始用户表(未使用)
		}
		
		Utils.write2PrintWriter(initRet);
	}

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}


	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}


	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}


	
}
