<%-- 
    Document   : indexAdmin
    Created on : 3/11/2017, 02:45:27 PM
    Author     : garmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    String nombre;
%>
<%
    
    if(request.getSession() != null){
        HttpSession sesion = request.getSession();
        nombre = (String)sesion.getAttribute("nombre");
    }else{
        response.sendRedirect("jsp/iniciarSesion.jsp");  
    }
    
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Entro como ADmin <%=nombre%></h1>
    </body>
</html>
