<%-- 
    Document   : updateUserForm
    Created on : 5 Aug, 2016, 7:56:00 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="java.security.MessageDigest"%>
<%@page import ="java.util.regex.Matcher" %>
<%@page import ="java.util.regex.Pattern" %>
<%
    String loginid = request.getParameter("loginid");
    String username = request.getParameter("userName");
    String password = request.getParameter("password");
    String useraddress = request.getParameter("useraddress");
    String age = request.getParameter("age");
    String mobnumber = request.getParameter("mobilenumber");
    String email = request.getParameter("email");
     int age1 = Integer.parseInt(age);
    //password
     MessageDigest alg = MessageDigest.getInstance("MD5");
        alg.reset();
        alg.update(password.getBytes());
        byte[] digest = alg.digest();
        StringBuffer hashedpasswd = new StringBuffer();                                                                                                                                                         
        String hx;
        for (int i=0;i<digest.length;i++){
	hx =  Integer.toHexString(0xFF & digest[i]);
	//0x03 is equal to 0x3, but we need 0x03 for our md5sum
	if(hx.length() == 1){hx = "0" + hx;}
	hashedpasswd.append(hx);
        }
       
    //email
             Pattern pattern;
             Matcher matcher;
             String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
             pattern = Pattern.compile(EMAIL_PATTERN);
             matcher = pattern.matcher(email);
   //mob  validation          
        int mobinteger,notintegerCount=0,mint;
for(int n = 0; n < mobnumber.length(); n ++)
{
    mobinteger = mobnumber.charAt(n);
    mint = (int)mobinteger;
    if(mint <48 || mint > 57 )
    {
        notintegerCount++;
    }
}
             
             
             
       
        //username validation
        char c;
   
    
int cint,specialCharacterCount=0;
for(int n = 0; n < username.length(); n ++)
{
    c = username.charAt(n);
    cint = (int)c;
    if(cint <48 || (cint > 57 && cint < 65) || (cint > 90 && cint < 97) || cint > 122)
    {
        specialCharacterCount++;
    }
}

//address validation
 char addr;
 
   boolean useraddr=false;
    
int addrint,addrCharacterCount=0;
for(int n = 0; n < useraddress.length(); n ++)
{
    addr = useraddress.charAt(n);
    addrint=(int)addr;
    if(addrint!=38||addrint!=44||(addrint<48&&addrint>57)||(addrint<65&&addrint>90)||(addrint<95&&addrint>123)){
        addrCharacterCount++;
    }
}




  if(specialCharacterCount==0&&matcher.matches()==true&&mobnumber.length()==10&&notintegerCount==0&&useraddress.length()<101&&age1>17&&age1<100&&addrCharacterCount==0){      
    try{
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        java.sql.Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","root"); 
        Statement st= conn.createStatement(); 
        ResultSet rs = st.executeQuery("select * from userdetails where username='"+username+"'");
        if(rs.next()){
            
            out.print("username exist");
            %>
          <form action="login.jsp">
              <input type="submit" value="login" />
      </form>
    <%
            
        }
        else{
        st.executeUpdate("insert into userdetails (username,password,roleId,addr,age,mob,email,loginid) values('"+username+"','"+hashedpasswd.toString()+"','1','"+useraddress+"','"+age1+"','"+mobnumber+"','"+email+"','"+loginid+"')");
        st.executeUpdate("insert into loginattempts  values('"+username+"','"+0+"')");
        conn.close();
        response.sendRedirect("login.jsp");
            } 
    
   
        }
    catch(Exception e){
        out.println("Error");
    }
}
else{
%>

<%          if(specialCharacterCount!=0){
    out.println("do not enter Special Character");
}if(matcher.matches()==false){
    out.println("email id invalid");
}
if(age1<18&&age1>100){
    out.println("enter age greater than 18 and less than 100");
}
if(mobnumber.length()!=10){
    out.println("enter 10 digit number");
}
if(notintegerCount!=0){
    out.println("mobile number invalid");
}
if(addrCharacterCount!=0){
    out.println("Address invalid");
}
%>
            <button onclick="window.location.href='signup.jsp'">SignUP</button>
<%
}

    %>