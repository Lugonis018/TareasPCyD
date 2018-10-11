/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Bean.UsuarioBean;
import Modelo.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcad = request.getParameter("op");
        int op = Integer.parseInt(opcad);
        String pagina = "";

        switch (op) {
            case 1: {
                String usuario = request.getParameter("txtusu");
                String clave = request.getParameter("txtclave");

                UsuarioBean objUsuarioBean = new UsuarioBean();
                objUsuarioBean.setUsuario(usuario);
                objUsuarioBean.setClave(clave);

                UsuarioDAO objUsuarioDAO = new UsuarioDAO();

                boolean estado = objUsuarioDAO.ValidarUsuario(objUsuarioBean);
                System.out.println("Estado: " + estado);

                if (estado) {
                    pagina = "/Vista/FrmPrincipalUsuario.jsp";
                } else {
                    pagina = "/Vista/FrmLoginUsuario.jsp";
                    request.setAttribute("mensaje", "Usuario y clave incorrecto!");
                }
                break;
            }
        }
        getServletContext().getRequestDispatcher(pagina).forward(request, response);

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

}
