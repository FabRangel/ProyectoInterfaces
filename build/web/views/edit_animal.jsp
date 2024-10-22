<%-- 
    Document   : edit_animal
    Created on : 14 oct 2024, 19:45:33
    Author     : fgmrr
--%>

<%@page import="Model.Animalito"%>
<%@page import="Model.AnimalitoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            AnimalitoDAO dao = new AnimalitoDAO();
            String id = (String)request.getAttribute("animal_id");
            Animalito animal = (Animalito)dao.mostrarAnimal(id);
        %>
        <h1>Modificar Animalito</h1>
        <form action="Controller">
                Especie: <br>
                <input type="text" name="txt_especie" value="<%= animal.getEspecie() %>"  maxlength="100" required><br>
                Fecha de nacimiento: <br>
                <input type="date" name="txt_fecha_nac" value="<%= animal.getFecha_nac() %>"  maxlength="100" required><br>
                Vacunado <br>
                <input type="text" name="txt_is_vacunado" value="<%= animal.isIs_vacunado()%>" required><br>
                Nombre: <br>
                <input type="text" name="txt_nombre" value="<%= animal.getNombre() %>" required><br>
                Peso: <br>
                <input type="number" name="txt_peso" value="<%= animal.getPeso() %>" required><br>
                Id: <br>
                <input type="number" name="txt_animal_id" value="<%= animal.getAnimal_id() %>" readonly><br>
                
                <button type="submit" name="accion" value="actualizar">Actualizar</button>
            </form>
    </body>
</html>

