<%-- 
    Document   : caseDetails
    Created on : 1 Aug, 2016, 5:20:10 PM
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>case details</title>
    </head>
    <body>
         <link rel="stylesheet" href="table.css" type="text/css"/>
        <h3>                   </h3>
         
        <form method="post" action="updateCaseDetails.jsp">
        <table border="0" class="box1" cellspacing="40" align="center" cellpadding="30">
            
            <tbody>
                <tr>
                    <td>case type</td>
                    <td><select name="casetype">
   <%
    try{
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement(); 
       rs= st.executeQuery("select casetype from casetypemaster");
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
                    
                    <td>case year</td>
                    <td><select name="caseyear">
                        <% for(int i=2016;i>1900;i--){%>
                        
                            <option><%=i%></option>
                            <%}%>
                           
                        </select></td>
                </tr>
                <tr>
                    <td>petitioner name <font color="red">*</font></td>
                    <td><input type="text" name="petitionname" value="" maxlength="30" required/></td>
                    <td>Petitioner Address </td>
                    <td><input type="text" name="petitionaddress" maxlength="100" value="" /></td>
                    <td>Age<font color="red">*</font></td>
                    <td><input type="number" min="18" name="age" maxlength="3" value="" required/></td>
                   
            <script>
                if(document.sign.age.value<18){
                     window.alert("Enter age greater than 18");

                }
            </script>
                    
                    
                    
                    
                   
                    
                </tr>
                <tr>
                    <td >Gender</td>
                    <td colspan="5"><input type="radio" name="gender" value="male" >male<br>
                        <input type="radio" name="gender" value="female" >female<br></td>
                    
                </tr>
                <tr>
                    
                    <td>Case Details</td>
                    <td colspan="5"><textarea name="casedetails" rows="4" cols="100" maxlength="65535">
                        </textarea></td>
                    
                </tr>
                <tr>
                    <td colspan="6"><input type="submit" value="submit" /></td>
                    
                </tr>
                
           
            </tbody>
        </table>
        </form>
              
    </body>
</html>
<%
    }
%>