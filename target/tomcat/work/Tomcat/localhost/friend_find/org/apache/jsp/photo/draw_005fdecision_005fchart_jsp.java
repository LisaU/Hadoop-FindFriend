/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-07 02:50:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.photo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class draw_005fdecision_005fchart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div style=\"margin:10px 0 40px 0;\"></div>\r\n");
      out.write("\t<div style=\"padding:20px 20px;\">\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"padding-left: 30px;font-size: 15px;padding-top:10px;\"><br>\r\n");
      out.write("\t\t此页面用于寻找聚类中心，看图找到聚类中心的范围（x轴大于多少，y轴大于多少，在寻找聚类中心页面使用）<br>\r\n");
      out.write("\t\t注意：决策图展示的不包含局部密度最大的点，所以在执行分类时需要把决策图中的聚类中心个数加1<br>\r\n");
      out.write("\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<a id=\"drawId\" href=\"\" class=\"easyui-linkbutton\" \r\n");
      out.write("\t\tdata-options=\"iconCls:'icon-color_wheel',size:'large',iconAlign:'top'\">画图</a>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<a id=\"showId\" href=\"\" class=\"easyui-linkbutton\" \r\n");
      out.write("\t\tdata-options=\"iconCls:'icon-chart_line',size:'large',iconAlign:'top'\">展示决策图</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"windowId\" class=\"easyui-window\" title=\"Decision Chart\" data-options=\"minimizable:false,closed:true\" \r\n");
      out.write("\tstyle=\"width:550px;height:550px;padding:10px;\">\r\n");
      out.write("\t\t<img id=\"picId\" src=\"\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/draw_decision_chart.js\"></script>\r\n");
      out.write("  </body>\r\n");
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