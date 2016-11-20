<%-- 
    Document   : updateCaseDetails
    Created on : 5 Aug, 2016, 3:55:21 PM
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
<%
     
       String casetype = request.getParameter("casetype");
      // String casenumber = request.getParameter("casenumber");
       String caseyear = request.getParameter("caseyear");
       String petitionname = request.getParameter("petitionname");
       String petitionaddress = request.getParameter("petitionaddress");
       String age = request.getParameter("age");
       String gender = request.getParameter("gender");
       String casedetails = request.getParameter("casedetails");
       
       
   int age1 = Integer.parseInt(age);
   
   //case year validation
   char ch;   
int chint,notintegercount=0;
for(int n = 0; n < caseyear.length(); n ++)
{
    ch = caseyear.charAt(n);
    chint = (int)ch;
    if(chint <47&& chint > 58)
    
        notintegercount++;
    }

//petitioner name validation
   char ch1;   
int chint1,notintegercount1=0;
for(int n = 0; n < petitionname.length(); n ++)
{
    ch1 = petitionname.charAt(n);
    chint1 = (int)ch1;
    if(chint1 <48 || (chint1 > 57 && chint1 < 65) || (chint1 > 90 && chint1 < 97) || chint1 > 122)
    
        notintegercount1++;
    }

   //address validation
 char addr;
 
   boolean useraddr=false;
    
int addrint,addrCharacterCount=0;
for(int n = 0; n < petitionaddress.length(); n ++)
{
    addr = petitionaddress.charAt(n);
    addrint=(int)addr;
    if(addrint!=38||addrint!=44||(addrint<48&&addrint>57)||(addrint<65&&addrint>90)||(addrint<95&&addrint>123)){
        addrCharacterCount++;
    }
}    
 //case details 
char ch2;   
int chint2,notintegercount2=0;
for(int n = 0; n < casedetails.length(); n ++)
{
    ch2 = casedetails.charAt(n);
    chint2 = (int)ch2;
    if(chint2 <48 || (chint2 > 57 && chint2 < 65) || (chint2 > 90 && chint2 < 97) || chint2 > 122)
    
        notintegercount2++;
    }
       
       if(age1>18&&caseyear.length()==4&&notintegercount==0&&notintegercount1==0&&addrCharacterCount==0&&notintegercount2==0){
            try{
         Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
      //  out.println("database access");
        Statement st= conn.createStatement(); 
       
        st.executeUpdate("insert into casedet (casetype,caseyear,petname,petaddr,age,gender,casedetails) values ('"+casetype+"','"+caseyear+"','"+petitionname+"','"+petitionaddress+"','"+age+"','"+gender+"','"+casedetails+"')");
     // st.executeUpdate("insert into casedet values ('+casetype+','+casenumber+','"+caseyear+"','"+petitionname+"','"+petitionaddress+"','"+age+"','"+gender+"','"+casedetails+"'");
    conn.close();
   response.sendRedirect("menu2.jsp");
    }
 catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }    
       }
else{%>
<table>
<%
           if(age1<18){
               %>
               <tr>
    <%
                out.println("enter age above 18");
               %>
               </tr>
    <%  
           }
           if(notintegercount>0)
           {
 %>
 <tr><td>
    <%
               out.println("invalid year");
               %>
     </td>  </tr>
    <%  
           }
           if(notintegercount1>0){
%>
 <tr><td>
    <%
               out.println(" special characters entred in petitioner name ");
%>
              </td> </tr>
    <%
           }
           if(addrCharacterCount!=0){
%>
               <tr><td>
    <%
               out.println("petitioner address invalid");
%>
               </td></tr>
    <%
           }
           if(notintegercount2>0){
%>
               <tr><td>
    <%
               out.println(" case details invalid ");
%>
                   </td> </tr>
    <%
           }

%>
<button onclick="window.location.href='menu2.jsp'">menu</button>
</table>
<%
    
}      
  
}
%>