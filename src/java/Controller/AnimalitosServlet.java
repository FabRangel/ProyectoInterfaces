/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Adopcion;
import Model.AdopcionesDAO;
import Model.Animalito;
import Model.AnimalitoDAO;
import Model.Persona;
import Model.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.ZoneId;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fgmrr
 */
public class AnimalitosServlet extends HttpServlet {

    String listar = "vistas/show_animal.jsp";
    String add = "vistas/add_animal.jsp";
    String edit = "vistas/edit_animal.jsp";
    String adoptar = "vistas/adopt_animal.jsp";
    String listarAdopt = "vistas/show_adopts.jsp";
    Animalito animal = new Animalito();
    AnimalitoDAO animalDAO = new AnimalitoDAO();
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();
    AdopcionesDAO adopcionesDAO = new AdopcionesDAO();
    Adopcion adopcion = new Adopcion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnimalitosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnimalitosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println("Acción recibida: " + action);
        if (action.equalsIgnoreCase("listar")) {

            acceso = listar;
        }
        if (action.equalsIgnoreCase("listar_adopciones")) {

            acceso = listarAdopt;
        }
        if (action.equalsIgnoreCase("add")) {
            //System.out.println("hello2");
            acceso = add;
        }
        if (action.equalsIgnoreCase("agregar")) {
            System.out.println("agregar");
            String especie = request.getParameter("txt_especie");
            String fecha = request.getParameter("txt_fecha_nac");
            String nombre = request.getParameter("txt_nombre");
            String peso = request.getParameter("txt_peso");
            int isVacunado = request.getParameter("txt_is_vacunado") != null ? 1 : 0;

            Date fechaFinal = Date.valueOf(fecha);
            animal.setEspecie(especie);
            animal.setFecha_nac(fechaFinal);
            animal.setIs_vacunado(isVacunado);
            animal.setPeso(Float.valueOf(peso));
            animal.setNombre(nombre);
            animalDAO.agregarAnimal(animal);

            //response.sendRedirect(request.getContextPath()+"/Controller?accion=add");
            acceso = listar;
        }
        if (action.equalsIgnoreCase("editar")) {
            System.out.println("Editar");
            request.setAttribute("animal_id", request.getParameter("animal_id"));
            acceso = edit;
        }
        if (action.equalsIgnoreCase("adoptar")) {
            System.out.println("adoptando");
            request.setAttribute("animal_id", request.getParameter("animal_id"));
            acceso = adoptar;
        }
        if (action.equalsIgnoreCase("actualizar")) {
            System.out.println("Actualizar");
            String especie = request.getParameter("txt_especie");
            String fecha = request.getParameter("txt_fecha_nac");
            String nombre = request.getParameter("txt_nombre");
            String peso = request.getParameter("txt_peso");
            String animal_id = request.getParameter("txt_animal_id");
            int isVacunado = request.getParameter("txt_is_vacunado") != null ? 1 : 0;

            Date fechaFinal = Date.valueOf(fecha);

            animal.setEspecie(especie);
            animal.setFecha_nac(fechaFinal);
            animal.setIs_vacunado(isVacunado);
            animal.setPeso(Float.valueOf(peso));
            animal.setNombre(nombre);
            animal.setAnimal_id(Integer.parseInt(animal_id));

            animalDAO.editarAnimal(animal);

            response.sendRedirect(request.getContextPath() + "/AnimalitosServlet?accion=listar");
            return;
        }
        if (action.equalsIgnoreCase("eliminar")) {
            System.out.println("Eliminar");
            String id = request.getParameter("animal_id");
            animal.setAnimal_id(Integer.getInteger(id));
            animalDAO.borrarAnimal(id);
            response.sendRedirect(request.getContextPath() + "/AnimalitosServlet?accion=listar");
            return;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("adopt")) {
            String nombre = request.getParameter("txt_nombre");
            String apellido = request.getParameter("txt_apellido");
            String telefono = request.getParameter("txt_telefono");

            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setTelefono(telefono);

            int personaId = personaDAO.agregarPersona(persona);

            String animal_id = request.getParameter("animal_id");
            String persona_id = String.valueOf(personaId);
            LocalDateTime now = LocalDateTime.now();
            Date fecha_adopcion = Date.valueOf(now.toLocalDate()); 
            
            adopcion.setAnimal_id(Integer.parseInt(animal_id));
            adopcion.setPersona_id(personaId);
            adopcion.setFecha_adopcion(fecha_adopcion);
            
            adopcionesDAO.agregarAdopcion(adopcion);
            response.sendRedirect(request.getContextPath() + "/AnimalitosServlet?accion=listar_adopciones");
            return;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
