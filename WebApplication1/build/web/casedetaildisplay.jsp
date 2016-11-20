<%-- 
    Document   : casetypedisplay
    Created on : 6 Aug, 2016, 9:37:48 PM
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
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>casetype details</title>
</head>
<body>


         <link rel="stylesheet" href="table.css" type="text/css"/>
<form method="post">

<table border="1" align="center" class="box">
<tr>
<td>casetype</td>
<td>caseno</td>
<td>caseyear</td>
<td>petname</td>
<td>petaddr</td>
<td>age</td>
<td>gender</td>
<td>casedetails</td>
</tr>
<%
String casetype = request.getParameter("casetype");
 try{
         Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
      //  out.println("database access");
        Statement st= conn.createStatement(); 
        ResultSet rs = st.executeQuery("select casetype,caseno,caseyear,petname,petaddr,age,gender,casedetails from casedet");
         while(rs.next()){
            %>
            <tr>
                <td><%=rs.getString("casetype") %></td>
                <td><%=rs.getString("caseno") %></td>
                <td><%=rs.getString("caseyear") %></td>
                <td><%=rs.getString("petname") %></td>
                <td><%=rs.getString("petaddr") %></td>
                <td><%=rs.getString("age") %></td>
                <td><%=rs.getString("gender") %></td>
                <td><%=rs.getString("casedetails") %></td>
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
</body>
</form>
</html>
<%
}    
%>
    
    