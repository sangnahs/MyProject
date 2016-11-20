<%-- 
    Document   : casetypeform
    Created on : 29 Aug, 2016, 4:44:20 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <link rel="stylesheet" href="table.css" type="text/css"/>

                <form action="casetypecode.jsp" method="post">
        <table class="box">
            <tr>
                <td> enter case type</td>
                <td> <input type="text" name="casetype" maxlength="30" required/></td>
        </tr>
        <tr>
                <td> enter case type description</td>
                <td> <input type="text" name="casetypedes" maxlength="50" required/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="submit" /></td>
        </tr>
        </table>
        </form>
    </body>

</html>