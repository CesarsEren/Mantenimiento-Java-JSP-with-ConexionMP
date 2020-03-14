/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.conectar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilitarios.Conexion;

/**
 *
 * @author Cesar´s
 */
public class SvlCargarDatos extends HttpServlet {

    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    Conexion ConMysql = new conectar();
    String cargar = "index";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        cargar = request.getParameter("cargar");
        if ("".equals(cargar) || cargar == null) {
            cargar = "index";
        }
        switch (cargar) {
            case "index": {
                Object[][] categorias = ConMysql.select("categoria", "idcategoria,nombrecategoria", null);
                Object[][] productos = ConMysql.select("productos p inner join categoria c ON p.idcategoria = c.idcategoria", "p.idproducto,p.nombreproducto,p.precio,c.nombrecategoria", null);
                request.setAttribute("categorias", categorias);
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp?pagina=productos").forward(request, response);
            }
            break;
            case "categorias": {
                Object[][] categorias = ConMysql.select("categoria", "idcategoria,nombrecategoria", null);
                //Object[][] productos = ConMysql.select("productos p inner join categoria c ON p.idcategoria = c.idcategoria", "p.idproducto,p.nombreproducto,p.precio,c.nombrecategoria", null);
                //System.out.println("Consulkta realizada");
                request.setAttribute("categorias", categorias);

                //request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp?pagina=categorias").forward(request, response);
            }
            break;
        }

//        response.sendRedirect("index.jsp");
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
