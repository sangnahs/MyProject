<%-- 
    Document   : updaterole
    Created on : 2 Aug, 2016, 3:58:04 PM
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
<%
    try{
        String username = request.getParameter("username");
        String userrole = request.getParameter("userrole");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement();
        
        
        st.executeUpdate("update userdetails set roleId='"+userrole+"'where userName='"+username+"'");
        conn1.close();
        response.sendRedirect("menu2.jsp");
    }
    catch(Exception e)
    {
               out.println("Something went wrong !! Please try again");       

    }
}
%>