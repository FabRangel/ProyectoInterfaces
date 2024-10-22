<%-- 
    Document   : adopt_animal
    Created on : 15 oct 2024, 00:01:46
    Author     : fgmrr
--%>
<%@page import="Model.Animalito"%>
<%@page import="Model.AnimalitoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Adopción</title>
</head>
<body>
    <h1>Formulario de Adopción de Animal</h1>
    
    <form action="AnimalitosServlet?accion=adopt" method="post">
         <input type="hidden" name="animal_id" value="<%= request.getAttribute("animal_id") %>">
        <label for="nombre">Nombre:</label><br>
        <input type="text" id="txt_nombre" name="txt_nombre" placeholder="Ingrese su nombre" required><br><br>

        <label for="apellido">Apellido:</label><br>
        <input type="text" id="txt_apellido" name="txt_apellido" placeholder="Ingrese su apellido" required><br><br>

        <label for="telefono">Teléfono:</label><br>
        <input type="tel" id="txt_telefono" name="txt_telefono" placeholder="Ingrese su teléfono" pattern="[0-9]{10}" required><br><br>

        <button type="submit">Enviar Solicitud de Adopción</button>
    </form>
    
</body>
</html>