/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-12 06:55:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.cluster;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class monitor_005fone_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div  data-options=\"region:'north',border:false\" style=\"height:60px;padding:50px 50px 10px 50px;\">\r\n");
      out.write(" \t <h1> Hadoop集群任务实时监控</h1><br><hr><br>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div style=\"padding-left: 30px;font-size: 20px;padding-top:10px;\">\r\n");
      out.write("\t <table>\r\n");
      out.write("\t\t\t <tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"name\">所有任务个数:</label></td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"jobnums\" data-options=\"required:true\" value=\"#\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"name\">当前任务:</label></td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"currjob\" data-options=\"required:true\" value=\"#\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("   \t\t<tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"name\">JobID:</label></td>\r\n");
      out.write("\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"jobid\" data-options=\"required:true\" style=\"width:300px\" value=\"#\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">JobName:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"jobname\" data-options=\"required:true\" style=\"width:600px\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"#\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">Map进度:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"mapprogress\" data-options=\"required:true\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"0.0%\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">Reduce进度:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"redprogress\" data-options=\"required:true\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"0.0%\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><label for=\"name\">任务执行状态:</label></td>\r\n");
      out.write("\t\t\t\t\t<td><input class=\"easyui-validatebox\" type=\"text\"\r\n");
      out.write("\t\t\t\t\t\tid=\"state\" data-options=\"required:true\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"#\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t// 自动定时刷新 1s\r\n");
      out.write("\t \tvar monitor_cf_interval= setInterval(\"monitor_one_refresh()\",3000);\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/preprocess.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("\r\n");
      out.write(" ");
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
