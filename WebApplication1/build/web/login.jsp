<%-- 
    Document   : index
    Created on : 1 Aug, 2016, 3:04:54 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="java.security.MessageDigest"%>
<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="java.util.Calendar" %>
  <%@page  import="java.text.DateFormat"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Application</title>
    </head>
    <body>
                <link rel="stylesheet" href="table.css" type="text/css"/>

        <h1 align="center">Welcome!!</h1>
        <h2 align="center">Login Form</h2>
        <form  method="post" action="">
            <table border="0" class="box">
               
                <tbody>
                    <tr>
                        <td><b>UserName <font color="red">*</font></b></td>
                        <td><input type="text" name="username" value="" required /></td>
                    </tr>
                    <tr>
                        <td><b>Password <font color="red">*</font></td>
                        <td><input type="password" name="password" value="" required/><p> <font color="red">*</font> indicates required fields</p></td>
                        
                    </tr>
                    <tr>
                        
                        <td colspan="2"><input type="submit" value="submit" /></td>
                        
                    </tr>
                </tbody>
            </table>

        </form>
<%
 
                
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
                            %>
                            <script>
                                     window.alert("invalid username and password");
                            </script>
                            <%
                                    ResultSet rs1= st.executeQuery("select no_of_login from loginattempts where username='"+username+"'");
                                    if(rs1.next()){
                                    c= rs1.getInt(1);
                                    c=c+1;
                                    st.executeUpdate("update loginattempts set no_of_login="+c+" where username='"+username+"'");
                                    if(c==1){
                         %>
                                     <script>
                                        window.alert("no of attempts is 2");
                                     </script>
                          <%
                                     }
                                     if(c==2){
                            %>
                                      <script>
                                          window.alert("no of attempts is 1");
                                      </script>
                        <%
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
%>
                            <script>
                            window.alert("user name does not exist");
                            </script>
                        <%
}
   
}
catch(Exception e){       
      // out.print("Something went wrong !! Please try again");       

}

%>

    </body>
</html>
