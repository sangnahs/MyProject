<%-- 
    Document   : signup
    Created on : 5 Aug, 2016, 7:38:17 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>signup page</title>
    </head>
    <body>
                <link rel="stylesheet" href="table.css" type="text/css"/>

        <h1 align="center">Sign Up Form</h1>
        <form action="updateUserForm.jsp" method="post">
        
        <table border="0" class="box" cellspacing="40" align="center" cellpadding="3">
            
            <tbody allign ="center">
                
                <tr align="center">
                    <td>Login Id</td>
                    <td><input type="text" name="loginid" value="" maxlength="30"/></td>
                </tr>
                
                <tr align="center">
                    <td>User Name</td>
                    <td><input type="text" name="userName" value="" /></td>
                </tr>
 
                <tr align="center">
                    <td>Password</td>
                    <td><input type="password" name="password" value="" /></td>
                </tr>
                <tr align="center">
                    <td>User Address</td>
                    <td><input type="text" name="useraddress" value="" maxlength="100" /></td>
                </tr>
                <tr align="center">
                    <td>age</td>
                    <td><input type="number" name="age" value="" min="18" max="99" /></td>
                </tr>
                <tr align="center">
                    <td>mobile Number</td>
                    <td><input type="text" name="mobilenumber" value=""  maxlength="10"/></td>
                </tr>
                <tr align="center">
                    <td>Email id</td>
                    <td><input type="email" name="email" value="" /></td>
                </tr>
                <tr >
                    <td colspan="2" allign="right"> <input type="submit" value="Submit" />
                </tr>
            </tbody>
        </table>
        </form>
    </body>

 
</html>