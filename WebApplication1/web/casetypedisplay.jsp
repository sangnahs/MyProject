<%-- 
    Document   : casetypedisplay
    Created on : 30 Aug, 2016, 9:42:35 PM
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
<form method="post">

<table border="1" align="center" class="box">
<tr>
    <td><b>casetype</b></td>
    <td><b>casetypedesc</b></td>

</tr>
<%
String casetype = request.getParameter("casetype");
 try{
         Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
      //  out.println("database access");
        Statement st= conn.createStatement(); 
        ResultSet rs = st.executeQuery("select casetype,casetypedesc from casetypemaster");
         while(rs.next()){
            %>
            <tr>
                <td><%=rs.getString("casetype") %></td>
                <td><%=rs.getString("casetypedesc") %></td>
               
            </tr>
                <%
        }
%>

 </table>
    <%
    rs.close();
    st.close();
    conn.close();
    }
catch(Exception e)
{
    out.println("error");
    }




%>
</form>
    </body>
</html>
