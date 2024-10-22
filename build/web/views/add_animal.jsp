<%-- 
    Document   : add_animal
    Created on : 14 oct 2024, 19:45:22
    Author     : fgmrr
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Registrar Animal</h1>
            <form action="Controller">
                Especie: <br>
                <input type="text" name="txt_especie" maxlength="100" required><br>

                Fecha de nacimiento <br>
                <input type="date" name="txt_fecha_nac" maxlength="100" required><br>

                Vacunado: <br>
                <input type="text" name="txt_is_vacunado" required><br>

                Nombre: <br>
                <input type="text" name="txt_nombre" required><br>

                Peso: <br>
                <input type="number" name="txt_peso" id="peso" required><br>

                <button type="submit" name="accion" value="agregar">Agregar</button>
            </form>
        </div>
    </body>
   
</html>
