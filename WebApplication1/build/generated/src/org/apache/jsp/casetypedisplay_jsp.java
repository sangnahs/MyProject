package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class casetypedisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <link rel=\"stylesheet\" href=\"table.css\" type=\"text/css\"/>\n");
      out.write("<form method=\"post\">\n");
      out.write("\n");
      out.write("<table border=\"1\" align=\"center\" class=\"box\">\n");
      out.write("<tr>\n");
      out.write("    <td><b>casetype</b></td>\n");
      out.write("    <td><b>casetypedesc</b></td>\n");
      out.write("\n");
      out.write("</tr>\n");

String casetype = request.getParameter("casetype");
 try{
         Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
      //  out.println("database access");
        Statement st= conn.createStatement(); 
        ResultSet rs = st.executeQuery("select casetype,casetypedesc from casetypemaster");
         while(rs.next()){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString("casetype") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print(rs.getString("casetypedesc") );
      out.write("</td>\n");
      out.write("               \n");
      out.write("            </tr>\n");
      out.write("                ");

        }

      out.write("\n");
      out.write("\n");
      out.write(" </table>\n");
      out.write("    ");

    rs.close();
    st.close();
    conn.close();
    }
catch(Exception e)
{
    out.println("error");
    }





      out.write("\n");
      out.write("</form>\n");
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
