package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("  \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Web Application</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                <link rel=\"stylesheet\" href=\"table.css\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <h1 align=\"center\">Welcome!!</h1>\n");
      out.write("        <h2 align=\"center\">Login Form</h2>\n");
      out.write("        <form  method=\"post\" action=\"\">\n");
      out.write("            <table border=\"0\" class=\"box\">\n");
      out.write("               \n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><b>UserName <font color=\"red\">*</font></b></td>\n");
      out.write("                        <td><input type=\"text\" name=\"username\" value=\"\" required /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><b>Password <font color=\"red\">*</font></td>\n");
      out.write("                        <td><input type=\"password\" name=\"password\" value=\"\" required/><p> <font color=\"red\">*</font> indicates required fields</p></td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        \n");
      out.write("                        <td colspan=\"2\"><input type=\"submit\" value=\"submit\" /></td>\n");
      out.write("                        \n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </form>\n");

 
                
 try{
session.setAttribute("username","");

int c=0;

String username = request.getParameter("username");
String password = request.getParameter("password");
Calendar calendar = Calendar.getInstance();
                      DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                     String currentDate1  =dateFormat1.format(calendar.getTime());
                                     String Year1= currentDate1.substring(0,4);
                                     String month1 = currentDate1.substring(5,7);
                                     String date1 = currentDate1.substring(8,10);
                                     int hour1 = Integer.parseInt(currentDate1.substring(11,13));
                                     int min1 =  Integer.parseInt(currentDate1.substring(14,16));
                                     int sec1 = Integer.parseInt(currentDate1.substring(17,19));
                                     long AccessTime =(hour1*60*60)+(min1*60)+sec1;
                
                         
  
int y2 = Integer.parseInt(Year1);
int m2 = Integer.parseInt(month1);
int d2 = Integer.parseInt(date1);
                         
                
                
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

ResultSet rs5 = st.executeQuery("select * from userdetails where userName='"+username+"'");
int s,y,m,d;
if(rs5.next()){
 ResultSet rs6=st.executeQuery("select lastaccesstime,lastyear,lastmonth,lastdate from blockeduser where username='"+username+"'");
                if(rs6.next()){
                   s = rs6.getInt(1);
                   y= rs6.getInt(2);
                   m=rs6.getInt(3);
                   d=rs6.getByte(4);
                  if((AccessTime-s>86400)||(y2>y)||(m2>m)||(d2>d)){
                   st.executeUpdate("delete from blockeduser where username='"+username+"'");
                  }
                  else{
                     
                     
                      
                         response.sendRedirect("blocked.jsp");
                  }
                }
            ResultSet rs=st.executeQuery("select * from userdetails where userName='"+username+"' and password='"+hashedpasswd.toString()+"'"); 
            if(rs.next()) 
                    {   session = request.getSession();
                        st.executeUpdate("update loginattempts set no_of_login=0 where username='"+username+"'");
                        session.setAttribute("username", username);
                        session.setAttribute("isUserLoggedIn",true);
                        response.sendRedirect("menu2.jsp");
                    }          
             
            else{        
                       session.setAttribute("isUserLoggedIn",false);
                       ResultSet rs2 = st.executeQuery("select * from loginattempts where username='"+username+"'");
                       if(rs2.next()){
                            
      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                     window.alert(\"invalid username and password\");\n");
      out.write("                            </script>\n");
      out.write("                            ");

                                    ResultSet rs1= st.executeQuery("select no_of_login from loginattempts where username='"+username+"'");
                                    if(rs1.next()){
                                    c= rs1.getInt(1);
                                    c=c+1;
                                    st.executeUpdate("update loginattempts set no_of_login="+c+" where username='"+username+"'");
                                    if(c==1){
                         
      out.write("\n");
      out.write("                                     <script>\n");
      out.write("                                        window.alert(\"no of attempts is 2\");\n");
      out.write("                                     </script>\n");
      out.write("                          ");

                                     }
                                     if(c==2){
                            
      out.write("\n");
      out.write("                                      <script>\n");
      out.write("                                          window.alert(\"no of attempts is 1\");\n");
      out.write("                                      </script>\n");
      out.write("                        ");

                                     }
                                    if(c>2){
                         // out.print("blocked");
                                    
                                     

                                     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                     String currentDate  =dateFormat.format(calendar.getTime());
                                     String Year= currentDate.substring(0,4);
                                     String month = currentDate.substring(5,7);
                                     String date = currentDate.substring(8,10);
                                     int hour = Integer.parseInt(currentDate.substring(11,13));
                                     int min =  Integer.parseInt(currentDate.substring(14,16));
                                     int sec = Integer.parseInt(currentDate.substring(17,19));
                                     long LastAccessTime =(hour*60*60)+(min*60)+sec;
                                     
                                    int y3 = Integer.parseInt(Year);
                                    int m3 = Integer.parseInt(month);
                                    int d3 = Integer.parseInt(date);

                                   

                                     session.setAttribute("lastyear",y3);
                                     session.setAttribute("lastmonth",m3);
                                     session.setAttribute("lastdate",d3);
                                     session.setAttribute("LastAccessTime",LastAccessTime );
                                     session.setAttribute("LastUserName",username );
                                     st.executeUpdate("insert into blockeduser values('"+username+"','"+LastAccessTime+"','"+y3+"','"+m3+"','"+d3+"')");
                                     st.executeUpdate("update loginattempts set no_of_login=0 where username='"+username+"'");
                                     
                                     //  response.sendRedirect("blocked.jsp");
                                    }   
                                    }
                                    }
                    }

}else{

      out.write("\n");
      out.write("                            <script>\n");
      out.write("                            window.alert(\"user name does not exist\");\n");
      out.write("                            </script>\n");
      out.write("                        ");

}
   
}
catch(Exception e){       
      // out.print("Something went wrong !! Please try again");       

}


      out.write("\n");
      out.write("\n");
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
