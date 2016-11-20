<%-- 
    Document   : index
    Created on : 5 Aug, 2016, 7:26:54 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
session.setAttribute("username","");
%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
    </head>
        
    <body>
        <h1 align="center">welcome</h1>
        <link rel="stylesheet" href="table.css" type="text/css"/>

        
        <table class="box" border="0" cellspacing="40" align="center" cellpadding="3">
            
            <tbody>
                <tr>
                    <td><button onclick="window.location.href='login.jsp'">LogIn</button>
                        </td>
                </tr>
                <tr>
                    <td><button onclick="window.location.href='signup.jsp'">SignUP</button></td>
                </tr>
            </tbody>
        </table>

        
        
    </body>
</html>
