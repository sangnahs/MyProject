<%-- 
    Document   : validate
    Created on : 1 Aug, 2016, 6:04:55 PM
    Author     : sangn
--%>
<%
String userName=session.getAttribute("username").toString();
//out.print(username);
if(userName.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="java.security.MessageDigest"%>
<%

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
%>