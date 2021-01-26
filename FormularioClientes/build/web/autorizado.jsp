<%-- 
    Document   : autorizado
    Created on : Sep 4, 2020, 1:38:13 PM
    Author     : karol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello </h1>
         <%String name=(String)request.getAttribute("nombres");%>
         <%String lastname=(String)request.getAttribute("apellidos");%>
          <h1><%=name%> <%=lastname%></h1>
    </body>
</html>
