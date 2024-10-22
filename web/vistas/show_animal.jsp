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
        <a href="AnimalitosServlet?accion=add">Agregar</a>
        <table border="1">
            <thead>
            <tr>
                <th>Id</th>
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
                     while(iterador.hasNext()) {
                        animal = iterador.next();
                %>
                <tr>
                    <td><%=animal.getAnimal_id() %></td>
                    <td><%=animal.getEspecie() %></td>
                    <td><%=animal.getFecha_nac() %></td>
                    <td><%= animal.isIs_vacunado() == 1 ? "Vacunado" : "No vacunado" %></td>
                    <td><%=animal.getNombre() %></td>
                    <td><%=animal.getPeso() %></td>
                    <td>
                        <a href="AnimalitosServlet?accion=editar&animal_id=<%= animal.getAnimal_id() %>">Editar</a>
                        <a href="AnimalitosServlet?accion=eliminar&animal_id=<%= animal.getAnimal_id() %>">Borrar</a>
                        <a href="AnimalitosServlet?accion=adoptar&animal_id=<%= animal.getAnimal_id() %>">Adoptar</a>
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