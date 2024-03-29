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
import modelo.Dao.UsuarioDao;
import modelo.Beans.UsuarioVo;

/**
 *
 * @author garmy
 */
public class GenerarUsuario extends HttpServlet {

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
        //String path = "/jsp/indexlogged.jsp";
        
       
        if(request.getParameter("confirmed") != null){
            String nombre = request.getParameter("nickname");
            String email = request.getParameter("email");
            String contraseña = request.getParameter("pass");
            String nombregenero = request.getParameter("gender");
            RequestDispatcher rd = null;

            boolean faltaRellenar = Revisor.revisaContenidoRegistro(nombre, email, contraseña, nombregenero);
            if (faltaRellenar) {
                request.setAttribute("rellanado", faltaRellenar);
                rd=request.getRequestDispatcher("/jsp/register.jsp");
            }else{
                int genero = Revisor.parseogenero(nombregenero);
                UsuarioVo busuario = new UsuarioVo(nombre,email,contraseña,genero);
                boolean sw = UsuarioDao.agregarUsuario(busuario);
                if(sw){
                    //RequestDispatcher disp = getServletContext().getRequestDispatcher(path);
                    //disp.forward(request, response);
                    request.setAttribute("nivel", busuario.getNivel());
                    request.setAttribute("nombre", busuario.getNombre());
                    rd=request.getRequestDispatcher("/jsp/register.jsp");
                }else{

                    rd=request.getRequestDispatcher("nocreado.jsp");
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
