package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class caseDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

String username=session.getAttribute("username").toString();
//out.print(username);
if(username.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>case details</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <link rel=\"stylesheet\" href=\"table.css\" type=\"text/css\"/>\n");
      out.write("        <h3>                   </h3>\n");
      out.write("         \n");
      out.write("        <form method=\"post\" action=\"updateCaseDetails.jsp\">\n");
      out.write("        <table border=\"0\" class=\"\" cellspacing=\"40\" align=\"center\" cellpadding=\"30\">\n");
      out.write("            \n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>case type</td>\n");
      out.write("                    <td><select name=\"casetype\">\n");
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
      out.write("                    </select></td>\n");
      out.write("                    \n");
      out.write("                    <td>case year</td>\n");
      out.write("                    <td><select name=\"caseyear\">\n");
      out.write("                        ");
 for(int i=2016;i>1900;i--){
      out.write("\n");
      out.write("                        \n");
      out.write("                            <option>");
      out.print(i);
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                           \n");
      out.write("                        </select></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>petitioner name <font color=\"red\">*</font></td>\n");
      out.write("                    <td><input type=\"text\" name=\"petitionname\" value=\"\" maxlength=\"30\" required/></td>\n");
      out.write("                    <td>Petitioner Address </td>\n");
      out.write("                    <td><input type=\"text\" name=\"petitionaddress\" maxlength=\"100\" value=\"\" /></td>\n");
      out.write("                    <td>Age<font color=\"red\">*</font></td>\n");
      out.write("                    <td><input type=\"number\" min=\"18\" name=\"age\" maxlength=\"3\" value=\"\" required/></td>\n");
      out.write("                   \n");
      out.write("            <script>\n");
      out.write("                if(document.sign.age.value<18){\n");
      out.write("                     window.alert(\"Enter age greater than 18\");\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td >Gender</td>\n");
      out.write("                    <td colspan=\"5\"><input type=\"radio\" name=\"gender\" value=\"male\" >male<br>\n");
      out.write("                        <input type=\"radio\" name=\"gender\" value=\"female\" >female<br></td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                    <td>Case Details</td>\n");
      out.write("                    <td colspan=\"5\"><textarea name=\"casedetails\" rows=\"4\" cols=\"100\" maxlength=\"65535\">\n");
      out.write("                        </textarea></td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"6\"><input type=\"submit\" value=\"submit\" /></td>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("           \n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        </form>\n");
      out.write("              \n");
      out.write("    </body>\n");
      out.write("</html>\n");

    }

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
