package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class casetypecode_jsp extends org.apache.jasper.runtime.HttpJspBase
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


    
     ResultSet rs=null;
      
        String casetype1 = request.getParameter("casetype");
        String casetypedesc=request.getParameter("casetypedes");
        
        String casetype2 = casetype1.toLowerCase();
         String casetype = casetype2.replaceAll("\\s+","");
         
          
char c;
int cint,specialCharacterCount=0;
for(int n = 0; n < casetype.length(); n ++)
{
    c = casetype.charAt(n);
    cint = (int)c;
    if(cint <48 || (cint > 57 && cint < 65) || (cint > 90 && cint < 97) || cint > 122)
    {
        specialCharacterCount++;
    }
}
 
char ch;
int chint,specialCharacterCount1=0;
for(int n = 0; n < casetypedesc.length(); n ++)
{
    ch = casetypedesc.charAt(n);
    chint = (int)ch;
    if(chint <48 || (chint > 57 && chint < 65) || (chint > 90 && chint < 97) || chint > 122)
    {
        specialCharacterCount1++;
    }
}
  if(specialCharacterCount==0 && specialCharacterCount1==0)       
  {       
    try{ 
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
        Statement st= conn.createStatement(); 
        
        rs = st.executeQuery("select * from casetypemaster where casetype='"+casetype+"'");
        if(rs.next()){
            
      out.write("\n");
      out.write("            <script>\n");
      out.write("                window.alert(\"case type exist\");\n");
      out.write("                \n");
      out.write("            </script>\n");
      out.write("                ");

        }
        else{
        st.executeUpdate("insert into casetypemaster (casetype,casetypedesc) values('"+casetype+"','"+casetypedesc+"')");

      out.write("\n");
      out.write("        <script>\n");
      out.write("        window.alert(\"case type updated\");\n");
      out.write("        </script>\n");
      out.write(" ");
  
        response.sendRedirect("menu2.jsp");
        }
         
         conn.close();
        
}
    catch(Exception e){
        out.println("Error");
}
        


 }
else{
if(specialCharacterCount!=0){
out.print("special characters entered");
}
if(specialCharacterCount1!=0){
out.print("special character entered in description");
}
      out.write("\n");
      out.write("<button onclick=\"window.location.href='menu2.jsp'\">Case Type</button>\n");



}
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
