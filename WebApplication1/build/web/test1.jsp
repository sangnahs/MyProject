<%-- 
    Document   : test1
    Created on : 21 Aug, 2016, 5:16:06 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
 <%@page import="java.util.Calendar" %>
 <%@page  import="java.text.DateFormat"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Calendar cal = Calendar.getInstance();
String currentDate  =dateFormat.format(cal.getTime());
String Year= currentDate.substring(0,4);
String month = currentDate.substring(5,7);
String date = currentDate.substring(8,10);
out.println(date);
out.println(month);

out.println(Year);
       %>
    </body>
</html>
