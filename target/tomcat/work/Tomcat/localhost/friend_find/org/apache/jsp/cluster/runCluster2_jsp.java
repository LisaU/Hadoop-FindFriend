/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-12 08:48:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.cluster;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class runCluster2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div  style=\"padding-left: 30px;font-size: 20px;padding-top:10px;\">Fast Cluster 算法调用--执行分类</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div style=\"padding-left: 30px;font-size: 15px;padding-top:10px;\"><br>\r\n");
      out.write("\t\t如果有MR监控页面，请先关闭，再提交MR任务<br>\r\n");
      out.write("\t</div>\r\n");
      out.write("    <div style=\"padding-left: 30px;font-size: 20px;padding-top:10px;\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">输入路径:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid= \"runcluster2_input\" name=\"input\" data-options=\"required:true\"  style=\"width:300px\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"/user/root/_filter/preparevectors\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">输出路径:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid= \"runcluster2_output\" name=\"output\" data-options=\"required:true\"  style=\"width:300px\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"/user/root/_center\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">距离阈值:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\" value=\"29\"\r\n");
      out.write("\t\t\t\t\t\tid=\"runcluster2_delta\" name=\"delta\" data-options=\"required:true\"  />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">聚类中心数:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"runcluster2_k\" value=\"4\" data-options=\"required:true\"  />\r\n");
      out.write("\t\t\t\t\t</td>\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><a id=\"runcluster2_submitid\" href=\"\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"easyui-linkbutton\">提交</a></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/runCluster.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
