<%-- 
    Document   : iniciarSesion
    Created on : 4/11/2017, 11:43:07 AM
    Author     : garmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
	<title>ART3TUBE</title>
	<meta charset="UTF-8">
	<!-- Librerias -->

	<link rel="stylesheet" type="text/css" href="../css/designr.css">

</head>
<body>
    <%!
        String texto = "";
    %>
    <%

        if(request.getAttribute("rellenado") != null){
            if((String)request.getAttribute("rellenado") == "falso"){
                texto = (String)request.getAttribute("comentario");
                response.sendRedirect("jsp/iniciarSesion.jsp");
            }else{
                if("falso" == (String)request.getAttribute("encontrado")){
                    texto = (String)request.getAttribute("comentario");
                    response.sendRedirect("jsp/iniciarSesion.jsp");
                }else{
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
                }               
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

	<h2>¡Inicia sesión!</h2>
        <h3><%=texto%></h3>
	<!-- Saltos-->
	</br>	
        <form action="/arTube/clogin.do" method="post">
            <div class="process">
                <span> Correo electrónico </span>
                </br>	
                <input type="textbox" class="infobox" name="email" placeholder="Ej. art3tube@xxx">
                </br>
                </br>

                <span> Contraseña </span>
                </br>	
                <input type="password" class="infobox" name="pass" placeholder="Minimo 8 caracteres">
                <input type="button" class = "eyepass" name="eye" readonly>	

                <span class="promo">¿No tienes cuenta? Registrate aqui</span>

                <!-- Saltos-->
                </br>
                </br>

                <input type="submit" class="ido" name="confirmado" value="ACEPTAR" readonly>
            </div>
            
        </form>
	

<!-- Saltos-->
	</br>
	</br>
	</br>

</div>

<!-- Saltos-->
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>		
	</br>
	</br>	

		<input class="logo" type="button" name="logo" readonly>
	
<!-- Saltos-->
	</br>
	</br>

</body>
</html>
