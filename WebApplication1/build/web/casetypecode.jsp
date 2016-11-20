<%-- 
    Document   : casetypecode
    Created on : 9 Aug, 2016, 6:52:37 PM
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
<%@page import ="java.sql.*"%>
<%@page import ="javax.sql.*" %>
<%

    
     ResultSet rs=null;
      
        String casetype1 = request.getParameter("casetype");
        String casetypedesc=request.getParameter("casetypedes");
        
        String casetype2 = casetype1.toLowerCase();
         String casetype = casetype2.replaceAll("\\s+","");
         
          
char c;
int cint,specialCharacterCount=0;
for(int n = 0; n < casetype.length(); n ++)
{
    c = casetype.charAt(n);
    cint = (int)c;
    if(cint <48 || (cint > 57 && cint < 65) || (cint > 90 && cint < 97) || cint > 122)
    {
        specialCharacterCount++;
    }
}
 
char ch;
int chint,specialCharacterCount1=0;
for(int n = 0; n < casetypedesc.length(); n ++)
{
    ch = casetypedesc.charAt(n);
    chint = (int)ch;
    if(chint <48 || (chint > 57 && chint < 65) || (chint > 90 && chint < 97) || chint > 122)
    {
        specialCharacterCount1++;
    }
}
  if(specialCharacterCount==0 && specialCharacterCount1==0)       
  {       
    try{ 
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
        Statement st= conn.createStatement(); 
        
        rs = st.executeQuery("select * from casetypemaster where casetype='"+casetype+"'");
        if(rs.next()){
            %>
            <script>
                window.alert("case type exist");
                
            </script>
                <%
        }
        else{
        st.executeUpdate("insert into casetypemaster (casetype,casetypedesc) values('"+casetype+"','"+casetypedesc+"')");
%>
        <script>
        window.alert("case type updated");
        </script>
 <%  
        response.sendRedirect("menu2.jsp");
        }
         
         conn.close();
        
}
    catch(Exception e){
        out.println("Error");
}
        


 }
else{
if(specialCharacterCount!=0){
out.print("special characters entered");
}
if(specialCharacterCount1!=0){
out.print("special character entered in description");
}%>
<button onclick="window.location.href='menu2.jsp'">Case Type</button>
<%


}
}
%>