<%-- 
    Document   : show_adopts
    Created on : 15 oct 2024, 00:25:06
    Author     : fgmrr
--%>

<%@page import="Model.Persona"%>
<%@page import="Model.PersonaDAO"%>
<%@page import="Model.Animalito"%>
<%@page import="Model.AnimalitoDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Adopcion"%>
<%@page import="java.util.List"%>
<%@page import="Model.AdopcionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LISTA DE LOS ANIMALITOS ADOPTADOS</h1>
        <a href="AnimalitosServlet?accion=add">Agregar</a>
        <table border="1">
            <thead>
            <tr>
                <th>Nombre animalito</th>
                <th>Nombre dueño</th>
                <th>Fecha de adopción</th>
            </tr>
            <thead>
            <tbody>
                <%
                    AdopcionesDAO dao = new AdopcionesDAO();
                    List<Adopcion> lista = dao.listar();
                    if (lista.isEmpty()){
                        System.out.println("No hay registros en la lista...");
                    }
                    
                    Iterator <Adopcion> iterador = lista.iterator();
                    Adopcion adopcion = null;
                     while(iterador.hasNext()) {
                        adopcion = iterador.next();
                        AnimalitoDAO Adao= new AnimalitoDAO();
                        Animalito animal = new Animalito();
                        animal = Adao.mostrarAnimal(String.valueOf(adopcion.getAnimal_id()));
                        PersonaDAO Pdao = new PersonaDAO();
                        Persona persona = new Persona();
                        persona = Pdao.mostrarPersona(String.valueOf(adopcion.getPersona_id()));
                %>
                <tr>
                    <td><%=animal.getNombre() %></td>
                    <td><%=persona.getNombre() + " " + persona.getApellido() %></td>
                    <td><%=adopcion.getFecha_adopcion() %></td>
                </tr>
                <% } %>
                <tr>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
