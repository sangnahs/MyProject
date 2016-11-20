<%-- 
    Document   : update
    Created on : 4 Aug, 2016, 10:09:23 PM
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/userinfo"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
insert into casedetail values(
</sql:query>
    </body>
</html>
<%
    }
%>