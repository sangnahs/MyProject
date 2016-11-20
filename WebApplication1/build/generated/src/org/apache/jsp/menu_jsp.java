package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String username=session.getAttribute("username").toString();
//out.print(username);
if(username.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    
      out.write("\n");
      out.write("    <html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Bootstrap Case</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("  <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("   <script>\n");
      out.write("   $(document).ready(function() {\n");
      out.write("    $(\".link1\").click(function(event){\n");
      out.write("       event.preventDefault();\n");
      out.write("       var url =$(this).attr(\"href\");\n");
      out.write("       $('#right1').load(url);\n");
      out.write("    });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("<nav>\n");
      out.write("    <ul class=\"nav\">\n");
      out.write("\t    \n");
      out.write("\t\t<ul><a href=\"#\" id=\"btn-1\" data-toggle=\"collapse\" data-target=\"#submenu1\" aria-expanded=\"false\">Master</a>\n");
      out.write("\t\t\t<ul class=\"nav collapse\" id=\"submenu1\" role=\"menu\" aria-labelledby=\"btn-1\">\n");
      out.write("                                        <li><a href=\"casetypeform.jsp\" class=\"link1\">Case Type</a></li></li>\n");
      out.write("                        </ul>\n");
      out.write("                </ul>\n");
      out.write("                \n");
      out.write("                        <ul style=\"list-style: none\">\n");
      out.write("\t\t\t\t<li><a href=\"caseDetails.jsp\" target=\"right1\" class=\"link1\" >Case Entry</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                \n");
      out.write("                <ul><a href=\"#\" id=\"btn-2\" data-toggle=\"collapse\" data-target=\"#submenu2\" aria-expanded=\"false\">Reports</a>\n");
      out.write("                    <ul class=\"nav collapse\" id=\"submenu2\" role=\"menu\" aria-labelledby=\"btn-2\">\n");
      out.write("\t\t\t\t<li><a href=\"casedetaildisplay.jsp\" target=\"right1\" class=\"link1\">Case-Details-Report</a></li>\n");
      out.write("                                <li><a href=\"casetypedisplay.jsp\" target=\"right1\" class=\"link1\">Case-Type-Report</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</ul>\n");
      out.write("                     ");

    try{
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement(); 
       rs= st.executeQuery("select username from admin where usename='"+username+"'");
       while(rs.next()){
           
      out.write("\n");
      out.write("           <ul style=\"list-style: none\">\n");
      out.write("\t\t\t\t<li><a href=\"userform.jsp\" target=\"right1\" class=\"link1\" >Update User Role</a></li>\n");
      out.write("                        </ul>\n");
      out.write("\t\t\n");
      out.write("\n");
      out.write("           ");

                   }     
        conn1.close();
       
    }
    catch(Exception e)
    {
               out.println("Something went wrong !! Please try again");       

    }  

      out.write("  \n");
      out.write("\n");
      out.write("        \n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("    ");

        }    
            
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
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
