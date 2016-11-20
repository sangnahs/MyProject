<%-- 
    Document   : menu
    Created on : 5 Aug, 2016, 8:15:49 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<!DOCTYPE html>
<%
String username=session.getAttribute("username").toString();
//out.print(username);
if(username.length()==0){
    response.sendRedirect("index.jsp");
}
else{
    %>
    <html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script>
   $(document).ready(function() {
    $(".link1").click(function(event){
       event.preventDefault();
       var url =$(this).attr("href");
       $('#right1').load(url);
    });
});
</script>
</head>
<body>
    
   
<nav>
    <ul class="nav">
	    
		<ul><a href="#" id="btn-1" data-toggle="collapse" data-target="#submenu1" aria-expanded="false">Master</a>
			<ul class="nav collapse" id="submenu1" role="menu" aria-labelledby="btn-1">
                                        <li><a href="casetypeform.jsp" class="link1">Case Type</a></li>
                        </ul>
                </ul>
                
                        <ul style="list-style: none">
				<li><a href="caseDetails.jsp" target="right1" class="link1" >Case Entry</a></li>
                        </ul>
                
                <ul><a href="#" id="btn-2" data-toggle="collapse" data-target="#submenu2" aria-expanded="false">Reports</a>
                    <ul class="nav collapse" id="submenu2" role="menu" aria-labelledby="btn-2">
				<li><a href="casedetaildisplay.jsp" target="right1" class="link1">Case-Details-Report</a></li>
                                <li><a href="casetypedisplay.jsp" target="right1" class="link1">Case-Type-Report</a></li>
			</ul>
		</ul>
                     <%
    try{
        ResultSet rs = null;
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn1 = null;
        conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root");  
        Statement st= conn1.createStatement(); 
       rs= st.executeQuery("select * from admin where username='"+username+"'");
       while(rs.next()){
           %>
           <ul style="list-style: none">
				<li><a href="userform.jsp" target="right1" class="link1" >Update User Role</a></li>
                        </ul>
		

           <%
                   }     
        conn1.close();
       
    }
    catch(Exception e)
    {
               out.println("Something went wrong !! Please try again");       

    }  
%>  

        
</nav>

</body>
</html>

    <%
        }    
            %>
    
    
</html>
