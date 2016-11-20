<%-- 
    Document   : insertcasedetails
    Created on : 9 Aug, 2016, 8:13:51 PM
    Author     : sangn
--%>
<%
String username=session.getAttribute("username").toString();
//out.print(username);
if(username.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.sql.*"%>
<%@page import ="javax.sql.*" %>
<%
try{
        
        
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
        Statement st= conn.createStatement(); 
        st.executeUpdate("");
        
        
        
 
         conn.close();
         }
    catch(Exception e){
        out.println("Error");
    }
}
    %>
    