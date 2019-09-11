package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class About_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Just Photography</title>\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles/main.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1 id=\"heading\">Just Photography</h1>\n");
      out.write("        <nav id=\"nav_menu\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"Index.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"Classes\">Classes</a></li>\n");
      out.write("                <li><a href=\"Events\">Events</a></li>\n");
      out.write("                <li><a href=\"Gallery.html\">Gallery</a></li>\n");
      out.write("                <li><a href=\"Competitions\">Competitions</a></li>\n");
      out.write("                <li><a href=\"About.html\">About</a></li>\n");
      out.write("                <li><a href=\"login.html\">Log In</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("        <main id=\"about\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <div class=\"about_right_img\">\n");
      out.write("                            <img src=\"images/classes.jpeg\" height=200 width=200 alt=\"classes\" />\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        \n");
      out.write("                            <div class=\"about_text\">\n");
      out.write("                                <h2>About Us!</h2>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod \n");
      out.write("                                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n");
      out.write("                                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n");
      out.write("                                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu \n");
      out.write("                                    fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa\n");
      out.write("                                    qui officia deserunt mollit anim id est laborum.</p>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod \n");
      out.write("                                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n");
      out.write("                                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n");
      out.write("                                    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu \n");
      out.write("                                    fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa\n");
      out.write("                                    qui officia deserunt mollit anim id est laborum.</p>\n");
      out.write("                                <p>If you have any questions we'd be happy to get back to you click the link below to find out our contact details</p>\n");
      out.write("                                <a href =\"Contact Us.html \">Contact Us! >>>></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <div class=\"about_left_img\">\n");
      out.write("                            <img src=\"images/gallery.jpeg\" height=200 width=200 alt=\"gallery\"/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </main>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
