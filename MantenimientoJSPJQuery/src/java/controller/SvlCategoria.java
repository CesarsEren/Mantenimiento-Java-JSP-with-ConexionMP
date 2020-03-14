/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.conectar;
import entity.productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SvlCategoria extends HttpServlet {

    conectar MysqlConect = new conectar();

    int limit;
    int offset;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            limit = Integer.parseInt(request.getParameter("limit"));
            offset = Integer.parseInt(request.getParameter("offset"));

            Map<String, Object> rpta = new HashMap<>();
            
            ArrayList<productos> listpro = new ArrayList<>();
            Object[][] total = MysqlConect.select("productos", "idproducto", null);
            ResultSet rs = MysqlConect.EjecutarSQL("select p.idproducto,p.nombreproducto,p.precio,c.idcategoria,c.nombrecategoria from productos p inner join categoria c on p.idcategoria = c.idcategoria order by  p.idproducto desc LIMIT "+offset+","+limit+";");
                    //+ " OFFSET " + offset + " ROWS "
                    //+ " FETCH NEXT " + limit + " ROWS ONLY");
            while (rs.next()) {
                productos pr = new productos();
                pr.setIdproducto(rs.getInt(1));
                pr.setNombre(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setIdcategoria(rs.getInt(4));
                pr.setNombrecategoria(rs.getString(5));
                listpro.add(pr);
            }
            if (!listpro.isEmpty()) {
                Map<String, Object> rpta2 = new HashMap<>();
                rpta2.put("total", total.length);
                rpta2.put("rows", listpro);
                rpta.put("productos", rpta2);
            } else {
                rpta.put("msgserver", "NONE");
            }
            String employeeJsonString = new Gson().toJson(rpta);
            System.out.println("JSON:" + employeeJsonString);
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            //out.flush();
        } catch (SQLException ex) {
            Logger.getLogger(SvlCategoria.class.getName()).log(Level.SEVERE, null, ex);
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
