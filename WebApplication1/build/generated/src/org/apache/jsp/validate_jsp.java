package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import java.security.MessageDigest;

public final class validate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

String userName=session.getAttribute("username").toString();
//out.print(username);
if(userName.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


int c =0;
   try{
            
           
            String username = request.getParameter("username");
            String password = request.getParameter("password");
       
             MessageDigest alg = MessageDigest.getInstance("MD5");
            alg.reset();
            alg.update(password.getBytes());
            byte[] digest = alg.digest();
            StringBuffer hashedpasswd = new StringBuffer();
            String hx;
            for (int i=0;i<digest.length;i++){
            hx =  Integer.toHexString(0xFF & digest[i]);
           //0x03 is equal to 0x3, but we need 0x03 for our md5sum
            if(hx.length() == 1){hx = "0" + hx;}
            hashedpasswd.append(hx);
            }
     
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            java.sql.Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
            Statement st= conn.createStatement(); 
            ResultSet rs=st.executeQuery("select * from userdetails where userName='"+username+"' and password='"+hashedpasswd.toString()+"'"); 
            if(rs.next()) 
            { 
            //out.println("welcome"+username); 
            session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("menu.jsp");
             }
             
            else{
                        c++;
                        out.print("invalid");
                        if(c<4){
                            response.sendRedirect("validate.jsp");
                        }
                }       
       
   }

catch(Exception e){       
      // out.print("Something went wrong !! Please try again");       
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
