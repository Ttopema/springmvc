/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-05-12 09:51:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mainContent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/erp/common/css/main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("/* Remove the navbar's default margin-bottom and rounded borders */\r\n");
      out.write(".navbar {\r\n");
      out.write("	margin-bottom: 0;\r\n");
      out.write("	border-radius: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<div class=\"row\">\r\n");
      out.write("			<div class=\"col-sm-7\">\r\n");
      out.write("				<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\"\r\n");
      out.write("					style=\"width: 600px; height: 300px\">\r\n");
      out.write("					<!-- Indicators -->\r\n");
      out.write("					<ol class=\"carousel-indicators\">\r\n");
      out.write("						<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("						<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\r\n");
      out.write("						<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>\r\n");
      out.write("					</ol>\r\n");
      out.write("\r\n");
      out.write("					<!-- Wrapper for slides -->\r\n");
      out.write("					<div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("						<div class=\"item active\">\r\n");
      out.write("							<img src=\"/erp/images/multi1.jpg\" alt=\"Image\"\r\n");
      out.write("								style=\"width: 600px; height: 300px\">\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"item\">\r\n");
      out.write("							<img src=\"/erp/images/multi2.jpg\" alt=\"Image\"\r\n");
      out.write("								style=\"width: 800px; height: 300px\">\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("						<div class=\"item\">\r\n");
      out.write("							<img src=\"/erp/images/multi3.jpg\" alt=\"Image\"\r\n");
      out.write("								style=\"width: 600px; height: 300px\">\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<!-- Left and right controls -->\r\n");
      out.write("					<a class=\"left carousel-control\" href=\"#myCarousel\" role=\"button\"\r\n");
      out.write("						data-slide=\"prev\"> <span\r\n");
      out.write("						class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("						<span class=\"sr-only\">Previous</span>\r\n");
      out.write("					</a> <a class=\"right carousel-control\" href=\"#myCarousel\" role=\"button\"\r\n");
      out.write("						data-slide=\"next\"> <span\r\n");
      out.write("						class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("						<span class=\"sr-only\">Next</span>\r\n");
      out.write("					</a>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-sm-5\">\r\n");
      out.write("				<div class=\"panel panel-primary\"\r\n");
      out.write("					style=\"border-color: #edeef1; height: 300px; width: 450px\">\r\n");
      out.write("					<div class=\"panel-footer\">사내소식</div>\r\n");
      out.write("					<div class=\"panel-body\">\r\n");
      out.write("						<ul class=\"nav nav-tabs\">\r\n");
      out.write("							<li class=\"active\"><a href=\"#\">최근게시판</a></li>\r\n");
      out.write("							<li><a href=\"#\">업무공지</a></li>\r\n");
      out.write("							<li><a href=\"#\">경조사</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("						<div id=\"boardMain\" style=\"padding-top: 20px; padding-left: 10px\">\r\n");
      out.write("							<table>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td class=\"boardContent\" style=\"\">mini프로젝트 개최</td>\r\n");
      out.write("									<td class=\"boardDate\" style=\"\">2023.5.30</td>\r\n");
      out.write("								</tr>\r\n");
      out.write("								<tr>\r\n");
      out.write("									<td class=\"boardContent\" style=\"\">kimsaemERP ver2.0출시</td>\r\n");
      out.write("									<td class=\"boardDate\" style=\"\">2023.5.29</td>\r\n");
      out.write("								</tr>\r\n");
      out.write("								<tr class=\"boardRow\">\r\n");
      out.write("									<td class=\"boardContent\">사옥 이전날짜 확정</td>\r\n");
      out.write("									<td class=\"boardDate\">2023.06.11</td>\r\n");
      out.write("								</tr>\r\n");
      out.write("								<tr class=\"boardRow\">\r\n");
      out.write("									<td class=\"boardContent\">보안의 날 참석 인원 확정</td>\r\n");
      out.write("									<td class=\"boardDate\">2023.6.11</td>\r\n");
      out.write("								</tr>\r\n");
      out.write("							\r\n");
      out.write("							</table>\r\n");
      out.write("						</div>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		<hr />\r\n");
      out.write("		<div class=\"row main-row\">\r\n");
      out.write("			<div class=\"col-sm-3\">\r\n");
      out.write("				<div class=\"panel panel-primary\"\r\n");
      out.write("					style=\"border-color: #edeef1; height: 300px\">\r\n");
      out.write("					<div class=\"panel-footer\">News</div>\r\n");
      out.write("					<div class=\"panel-body\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-sm-3\">\r\n");
      out.write("				<div class=\"panel panel-primary\"\r\n");
      out.write("					style=\"border-color: #edeef1; height: 300px\">\r\n");
      out.write("					<div class=\"panel-footer\">회사소식</div>\r\n");
      out.write("					<div class=\"panel-body\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-sm-3\">\r\n");
      out.write("				<div class=\"panel panel-primary\"\r\n");
      out.write("					style=\"border-color: #edeef1; height: 300px\">\r\n");
      out.write("					<div class=\"panel-footer\">회사소식</div>\r\n");
      out.write("					<div class=\"panel-body\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"col-sm-3\">\r\n");
      out.write("				<div class=\"panel panel-primary\"\r\n");
      out.write("					style=\"border-color: #edeef1; height: 300px\">\r\n");
      out.write("					<div class=\"panel-footer\">회사소식</div>\r\n");
      out.write("					<div class=\"panel-body\"></div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
