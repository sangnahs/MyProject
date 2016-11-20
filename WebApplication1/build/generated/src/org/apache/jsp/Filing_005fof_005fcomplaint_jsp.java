package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class Filing_005fof_005fcomplaint_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("           <link rel=\"stylesheet\" href=\"table.css\" type=\"text/css\"/>\n");
      out.write("        <form action=\"\">\n");
      out.write(" \n");
      out.write("   <form method=\"post\" action=\"updateCaseDetails.jsp\">\n");
      out.write("        <table border=\"0\" class=\"box1\" cellspacing=\"40\" align=\"center\" cellpadding=\"30\">\n");
      out.write("            \n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td> <input type=\"radio\" name=\"casetype\" value=\"civil\"> Civil \n");
      out.write("  <input type=\"radio\" name=\"casetype\" value=\"criminal\"> Criminal<br>\n");
      out.write("                    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("                    \n");
      out.write("                    <td> Case Type<select name=\"casetype\">\n");
      out.write("   ");

    try{
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement(); 
       rs= st.executeQuery("select casetype from casetypemaster");
       while(rs.next()){
           
      out.write("\n");
      out.write("           <option>");
      out.print(rs.getString(1));
      out.write("</option>\n");
      out.write("           ");

                   }     
        conn1.close();
       
    }
    catch(Exception e)
    {
               out.println("Something went wrong !! Please try again");       

    }  

      out.write("  \n");
      out.write("                          \n");
      out.write("                        </select></td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("                        <td>\n");
      out.write("                            Name    <input type=\"text\" name=\"name\" value=\"\">\n");
      out.write("                        </td></tr>\n");
      out.write("  <tr>\n");
      out.write("      <td>\n");
      out.write("          Age <input type=\"number\" name=\"age\" min=\"18\" max=\"100\">\n");
      out.write("      </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("      <td> Gender <input type=\"radio\" name=\"casetype\" value=\"civil\"> Male\n");
      out.write("            <input type=\"radio\" name=\"casetype\" value=\"criminal\"> Female <br>\n");
      out.write("                    </td>\n");
      out.write("  </tr>\n");
      out.write("  <tr>\n");
      out.write("      <td>\n");
      out.write("          Address <textarea maxlength=\"300\" rows=\"\" cols=\"\">\n");
      out.write("              \n");
      out.write("          </textarea>\n");
      out.write("      </td>\n");
      out.write("  </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
