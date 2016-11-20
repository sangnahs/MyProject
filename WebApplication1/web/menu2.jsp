<%-- 
    Document   : menu2
    Created on : 25 Aug, 2016, 9:26:54 PM
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
     <link rel="stylesheet" href="table.css" type="text/css"/>
      
     <div id="top">
         <jsp:include page="heading.jsp"/>
     </div>
     <div id="bottom">
         <jsp:include page="menu1.jsp"/>
     </div>
  
    
    
       
    </body>
         
</html>
<%
    }
%>