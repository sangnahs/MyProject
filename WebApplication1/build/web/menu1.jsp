<%-- 
    Document   : menu1
    Created on : 25 Aug, 2016, 10:43:26 PM
    Author     : sangn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>menu Page</title>

       

    </head>
     <body>
                 
      <link rel="stylesheet" href="table.css" type="text/css"/>
      
                    <div class="left" id="left1" style="float: left;background: azure; color: #035A85; width: 20% ;" >
                      <jsp:include page="menu.jsp" />

      </div>
                      <div id="right1" style="float: left; background: #eee;color: #4f4f4f; width: 80%;margin-left: 10px;">
                                                <jsp:include page="right.jsp" />

                              

                        </span>
                      </div>

    
  
        
    </body>
         
    
</html>
