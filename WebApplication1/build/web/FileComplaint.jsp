<%-- 
    Document   : FileComplaint
    Created on : 19 Nov, 2016, 6:18:54 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <link rel="stylesheet" href="table.css" type="text/css"/>
        <form>
            <table>
                
                <tbody>
                    <tr>
                        <td><input type="radio" name="casecategory" value="civil" />Civil </td>
                        <td></td>
                        <td><input type="radio" name="casecategory" value="criminal" />Criminal</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="" /></td>
                        <td>Age</td>
                        <td><input type="number" name="age" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Address</td>
                        <td colspan="3"><input  type="text" name="address" value="" maxlength="100"/></td>
                        
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="radio" name="gender" value="male" />Male</td>
                        <td><input type="radio" name="gender" value="female" />Female</td>
                        <td><input type="radio" name="gender" value="others" />Others</td>
                    </tr>
                    <tr>
                        <td>Act</td>
                        <td><select name="act">
                                <option>IPC</option>
                                <option>ICC</option>
                            </select></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Section</td>
                        <td><input type="text" name="section" value="" /></td>
                       
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>

            <input type="text" name="name" value="" />
            
        </form>
    </body>
</html>
