<%-- 
    Document   : register
    Created on : 3/11/2017, 02:45:41 AM
    Author     : garmy
--%>

<%@page import="java.util.EventObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<title>ART3TUBE</title>
	<meta charset="UTF-8">
	<!-- Librerias -->
        <!-- jQuery -->
        <script src="js/jquery.js" type="text/javascript"></script>   
     
	<link rel="stylesheet" type="text/css" href="../css/designr.css">
       
</head>
<body>
    
    <%
       
        HttpSession sesion = request.getSession();
        int nivel = 0;
        if (request.getAttribute("nivel") != null) {
            nivel = (Integer) request.getAttribute("nivel");
            if (nivel == 1) {
                sesion.setAttribute("nombre", request.getAttribute("nombre"));
                sesion.setAttribute("nivel", nivel);
                response.sendRedirect("jsp/indexAdmin.jsp");
            } else {
                sesion.setAttribute("nombre", request.getAttribute("nombre"));
                sesion.setAttribute("nivel", nivel);
                response.sendRedirect("jsp/indexlogged.jsp");
            }
        }
        
        
    
    %>

<!-- Saltos-->
</br>	
</br>

	<!-- Contenedor principal -->
 <div class = "container"> 

	<!-- Saltos-->
	</br>

	<h1>¡Regístrate gratis!</h1>

	<!-- Saltos-->
	</br>	

<form action="/arTube/generarusuario.do" method="post">
	<div class="process">
            
			<span>Nombre de usuario</span>
			</br>	
			<input type="textbox" class="infobox" name="nickname" placeholder="Ej. EdwinIIx">
			</br>
			</br>	

			<span>Sexo</span>
			</br>	
			<input type="radio" name="gender" value="male"><span class="gender" >Masculino</span> &nbsp&nbsp
  			<input type="radio" name="gender" value="female"><span class="gender" >Femenino</span>
  			</br>	
			</br>	

			<span>Correo electrónico</span>
			</br>	
			<input type="textbox" class="infobox" name="email" placeholder="Ej. art3tube@xxx">
			</br>
			</br>

			<span>Contraseña</span>
			</br>	
			<input type="password" class="infobox" name="pass" placeholder="Minimo 8 caracteres">
			<input type="button" class = "eyepass" name="eye" readonly>
			</br>
			</br>

			<span>Confirmar contraseña</span>
			</br>	
			<input type="password" class="infobox" name="pass2" placeholder="Minimo 8 caracteres">
			</br>
			</br>
			</br>

			<!-- Saltos-->
                        <input type="submit" class="ido" name="confirmed" value="ACEPTAR">

			</br>
			</br>
		</div>
	</form>
</div>
		<img class="logo" src="logo2.png" alt="Smiley face" height="42" width="42">	

<!-- Saltos-->
	</br>

</body>
</html>
