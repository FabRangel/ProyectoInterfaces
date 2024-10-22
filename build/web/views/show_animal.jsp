<%-- 
    Document   : show_animal
    Created on : 14 oct 2024, 19:46:04
    Author     : fgmrr
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Animalito"%>
<%@page import="Model.AnimalitoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE LOS ANIMALITOS REGISTRADOS</h1>
        <a href="Controller?accion=add">Agregar</a>
        <table border="1">
            <thead>
            <tr>
                <th>Especie</th>
                <th>Fecha de Nacimiento</th>
                <th>Vacunado</th>
                <th>Nombre</th>
                <th>Peso</th>
            </tr>
            <thead>
            <tbody>
                <%
                    AnimalitoDAO dao = new AnimalitoDAO();
                    List<Animalito> lista = dao.listar();
                    if (lista.isEmpty()){
                        System.out.println("No hay registros en la lista...");
                    }
                    
                    Iterator <Animalito> iterador = lista.iterator();
                    Animalito animal = null;
                %>
                <tr>
                    <td><%=animal.getEspecie() %></td>
                    <td><%=animal.getFecha_nac() %></td>
                    <td><%=animal.isIs_vacunado() %></td>
                    <td><%=animal.getNombre() %></td>
                    <td><%=animal.getPeso() %></td>
                    <td>
                        <a href="Controller?accion=editar&matricula=<%= animal.getAnimal_id() %>">Editar</a>
                        <a href="Controller?accion=eliminar&matricula=<%= animal.getAnimal_id() %>">Borrar</a>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>