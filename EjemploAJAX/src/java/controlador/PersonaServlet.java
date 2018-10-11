/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Bean.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANDRES
 */
public class PersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  ArrayList <Persona> personas = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edad = request.getParameter("edad");
         System.out.println(""+nombre+" " + apellido+" " +edad);
         if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
             
             Persona persona = new Persona(nombre, apellido, edad);
             personas.add(persona);}
              
             out.println("<table style = cellspacing\"7\" bgcolor=\"#0099cc\">");
             out.println("<tr>");
             out.println("<td style = rowspan\"7\" aling=\"center\" bgcolor=\"#f8f8f8\"> NOMBRE</td>");
             out.println("<td style = rowspan\"7\" aling=\"center\" bgcolor=\"#f8f8f8\">APELLIDO</td>");
             out.println("<td style = rowspan\"7\" aling=\"center\" bgcolor=\"#f8f8f8\">EDAD</td>");
             out.println("</tr>");
             
             for (int i = 0; i <personas.size(); i++) {
                 Persona persona = personas.get(i);
                 out.println("<tr>");
                 out.println("<td style=rowspan=\"7\" align=\"center\" bgcolor=\"#f8f8f8\">"+persona.getNombre()+"</td>");
                 out.println("<td style=rowspan=\"7\" align=\"center\" bgcolor=\"#f8f8f8\">"+persona.getApellido()+"</td>");
                 out.println("<td style=rowspan=\"7\" align=\"center\" bgcolor=\"#f8f8f8\">"+persona.getEdad()+"</td>");   }
                 out.println("</tr>");
         out.println("</table>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
