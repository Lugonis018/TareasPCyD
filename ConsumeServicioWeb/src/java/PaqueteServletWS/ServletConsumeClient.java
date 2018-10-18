/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteServletWS;

import WebService.ServiciosWeb_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author AUTONOMA
 */
public class ServletConsumeClient extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8083/ServiciosWeb/ServiciosWeb.wsdl")
    private ServiciosWeb_Service service;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Operaciones para Parcial</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Calculando Operaciones</h1>");
            out.println("<form method=get>");
            out.println("<table id=tabla border=1 "
                    + "style='HEIGHT:100%;WIDTH:100%;'"
                    + ">");
            out.println("<tr align='center'>"
                        + "<td colspan=6>Operaciones</td>"
                    + "</tr>"
                        + "<td colspan=2>Cuadrado</td>"
                        + "<td colspan=2>Triangulo</td>"
                        + "<td colspan=2>Rectangulo</td>"
                    + "<tr>"
                        + "<td colspan=2>Calcular el lado y perimetro<br>Ingresando:</td>"
                        + "<td colspan=2>Calcular el perimetro y area<br>Ingresando:</td>"
                        + "<td colspan=2>Calcular la base, el perimetro y el area<br>Ingresando:</td>"
                    + "</tr>"
                        +"<td>Area:</td>"
                        +"<td><input type='text' name='areaCua'></td>"
                        +"<td>Base:</td>"
                        +"<td><input type='text' name='baseTrian'></td>"
                        +"<td>Diagonal:</td>"
                        +"<td><input type='text' name='diagonalRect'></td>"
                    + "<tr>"
                        +"<td>Medida:</td>"
                        +"<td><select name='medidaCua'>"
                            + "<option>Metros</option>"
                            + "<option>Centrimentos</option>"
                            + "</select>"
                        + "</td>"
                        +"<td>Altura:</td>"
                        +"<td><input type='text' name='alturaTrian'></td>"
                        +"<td>Altura:</td>"
                        +"<td><input type='text' name='alturaRect'></td>"
                    + "</tr>"
                        + "<td></td>"
                        + "<td></td>"
                        + "<td>Medida:</td>"
                        + "<td><select name='medidaTrian'>"
                            + "<option>Metros</option>"
                            + "<option>Centrimentos</option>"
                            + "</select>"
                            + "</td>"
                        + "<td>Medida:</td>"
                        + "<td><select name='medidaRect'>"
                            + "<option>Metros</option>"
                            + "<option>Centrimentos</option>"
                            + "</select>"
                            + "</td>"
                    + "<tr align='center'>"
                        +"<td colspan=6><input type='submit' value='Calcular Operaciones'></td>"
                    + "</tr>");
            ////Obtención de datos:
            double areaCua=Double.parseDouble(request.getParameter("areaCua"));
            String medidaCua=request.getParameter("medidaCua");
            //
            double baseTrian=Double.parseDouble(request.getParameter("baseTrian"));
            double alturaTrian=Double.parseDouble(request.getParameter("alturaTrian"));
            String medidaTrian=request.getParameter("medidaTrian");
            //
            double diagonalRect=Double.parseDouble(request.getParameter("diagonalRect"));
            double alturaRect=Double.parseDouble(request.getParameter("alturaRect"));
            String medidaRect=request.getParameter("medidaRect");
            ////
            out.println("</table>");
            out.println("<br><br>");
            out.println("<table id='porqqw'>"
                    + "<tr>"
                        + "<td>Cuadrado</td>"
                        + "<td>Triangulo</td>"
                        + "<td>Rectangulo</td>"
                    + "</tr>"
                    + "<tr>"
                        + "<td>"+calculaLadoPerimCuadrado(areaCua, medidaCua)+"</td>"
                        + "<td>"+calcularPerimAreaTriangulo(baseTrian, alturaTrian, medidaTrian)+"</td>"
                        + "<td>"+calcularBasePerimAreaRectangulo(diagonalRect, alturaRect, medidaRect)+"</td>"
                    + "</tr>");
            
            out.println("</table>");
            out.println("</form>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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

    private String calculaLadoPerimCuadrado(double area, java.lang.String medida) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.ServiciosWeb port = service.getServiciosWebPort();
        return port.calculaLadoPerimCuadrado(area, medida);
    }

    private String calcularBasePerimAreaRectangulo(double diagonal, double altura, java.lang.String medida) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.ServiciosWeb port = service.getServiciosWebPort();
        return port.calcularBasePerimAreaRectangulo(diagonal, altura, medida);
    }

    private String calcularPerimAreaTriangulo(double base, double altura, java.lang.String medida) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        WebService.ServiciosWeb port = service.getServiciosWebPort();
        return port.calcularPerimAreaTriangulo(base, altura, medida);
    }

}
