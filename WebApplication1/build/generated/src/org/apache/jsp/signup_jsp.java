package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>signup page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                <link rel=\"stylesheet\" href=\"table.css\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <h1 align=\"center\">Sign Up Form</h1>\n");
      out.write("        <form action=\"updateUserForm.jsp\" method=\"post\">\n");
      out.write("        \n");
      out.write("        <table border=\"0\" class=\"box\" cellspacing=\"40\" align=\"center\" cellpadding=\"3\">\n");
      out.write("            \n");
      out.write("            <tbody allign =\"center\">\n");
      out.write("                \n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>Login Id</td>\n");
      out.write("                    <td><input type=\"text\" name=\"userName\" value=\"\" maxvalue=\"30\"/></td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>User Name</td>\n");
      out.write("                    <td><input type=\"text\" name=\"userName\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write(" \n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>Password</td>\n");
      out.write("                    <td><input type=\"password\" name=\"password\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>User Address</td>\n");
      out.write("                    <td><input type=\"text\" name=\"useraddress\" value=\"\" maxsize=\"100\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>age</td>\n");
      out.write("                    <td><input type=\"number\" name=\"age\" value=\"\" min=\"18\" max=\"99\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>mobile Number</td>\n");
      out.write("                    <td><input type=\"number\" name=\"mobilenumber\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr align=\"center\">\n");
      out.write("                    <td>Email id</td>\n");
      out.write("                    <td><input type=\"email\" name=\"email\" value=\"\" /></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr >\n");
      out.write("                    <td colspan=\"2\" allign=\"right\"> <input type=\"submit\" value=\"Submit\" />\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write(" \n");
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
