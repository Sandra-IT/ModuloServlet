/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.serveltsiv;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luka927
 */
@WebServlet(name = "RecibirDatos", urlPatterns = {"/RecibirDatos"})
public class RecibirDatos extends HttpServlet {

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
            out.println("<title>Servlet RecibirDatos</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RecibirDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
             
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        
        String user=request.getParameter("user");
        String password=request.getParameter("password");
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/sistema_inventario_virtual", "root", "");
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM inventario WHERE user='"+user+"' and password='"+password+"'");
            if(rs.next()){
                request.getSession().setAttribute("user", user);
                response.sendRedirect("panel.jsp");
              
              
            } else {
                response.sendRedirect("index.html");
            }
                
             out.println(request.getParameter("user"));
            out.println(request.getParameter("password"));
            
        } catch (SQLException ex) {
            Logger.getLogger(serveltSIV.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
            //out.println("<h1>Servlet RecibirDatos at " + request.getContextPath() + " </h1>");
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

    private static class serveltSIV {

        public serveltSIV() {
        }
    }

}
