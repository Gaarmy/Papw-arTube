/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Beans.UsuarioVo;
import modelo.Dao.UsuarioDao;

/**
 *
 * @author garmy
 */
public class CLogin extends HttpServlet {

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
        
        if(request.getParameter("confirmado") != null){
            RequestDispatcher rd = null;
            String email = request.getParameter("email");
            String contraseña = request.getParameter("pass");
            
            boolean faltaRellenar = Revisor.revisaLlenadoLogin(email, contraseña);
            if(faltaRellenar){
                request.setAttribute("rellenado", "falso");
                request.setAttribute("comentario", "Rellene Todos Los Campos");
                rd=request.getRequestDispatcher("/jsp/iniciarSesion.jsp");
            }else{
                UsuarioVo busuario = new UsuarioVo("", email, contraseña, 0);
                boolean sw = UsuarioDao.buscaUsuario(busuario);
                if (sw) {
                    //RequestDispatcher disp = getServletContext().getRequestDispatcher(path);
                    //disp.forward(request, response);
                    if(busuario.getIdPersona() == 0){
                        request.setAttribute("encontrado", "falso");
                        request.setAttribute("rellenado", "true");
                        request.setAttribute("comentario", "Usuario no Encontrado");
                        rd = request.getRequestDispatcher("/jsp/iniciarSesion.jsp");
                    }else{
                        request.setAttribute("encontrado", "true");
                        request.setAttribute("rellenado", "true");
                        request.setAttribute("nivel", busuario.getNivel());
                        request.setAttribute("nombre", busuario.getNombre());
                        rd = request.getRequestDispatcher("/jsp/iniciarSesion.jsp");    
                    }
                } else {

                    rd = request.getRequestDispatcher("nocreado.jsp");
                }                
            }
            rd.forward(request, response);
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

}
