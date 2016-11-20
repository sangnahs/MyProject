<%-- 
    Document   : logout
    Created on : 24 Aug, 2016, 7:25:26 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("username", "");
    response.sendRedirect("index.jsp");
    %>