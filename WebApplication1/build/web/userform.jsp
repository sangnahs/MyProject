<%-- 
    Document   : userform
    Created on : 2 Aug, 2016, 3:37:33 PM
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
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>userform</title>
    </head>
    <body>
         <link rel="stylesheet" href="table.css" type="text/css"/>

        <form action="updaterole.jsp" method="post">
        
        <table class="box" border="0">
            
            <tbody>
                <tr>
                     <td>username</td>
                    <td><select name="username">
   <%
    try{
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement(); 
       rs= st.executeQuery("select username from userdetails");
       while(rs.next()){
           %>
           <option><%=rs.getString(1)%></option>
           <%
                   }     
        conn1.close();
       
    }
    catch(Exception e)
    {
               out.println("Something went wrong !! Please try again");       

    }  
%>  
                          
                    </select></td>
                </tr>
                <tr>
                    <td>user role</td>
                    <td><select name="userrole">
                            <option>1</option>
                            <option>2</option>
                        </select></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="submit" /></td>
                    
                </tr>
            </tbody>
        </table>
        </form>
    </body>
</html>
<%
    }
%>