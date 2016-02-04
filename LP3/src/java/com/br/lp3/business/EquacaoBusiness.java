/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31338283
 */
@WebServlet(name = "EquacaoBusiness", urlPatterns = {"/EquacaoBusiness"})
public class EquacaoBusiness extends HttpServlet {

    private double paramA;
    private double paramB;
    private double paramC;

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
            out.println("<title>Servlet EquacaoBusiness</title>");
            out.println("</head>");
            out.println("<body>");

            paramA = Double.parseDouble(request.getParameter("paramA"));
            paramB = Double.parseDouble(request.getParameter("paramB"));
            paramC = Double.parseDouble(request.getParameter("paramC"));

            List<Double> resp = calculaRaizes();
            out.println("<p>Resultados:</p>");

            for (int i = 0; i < resp.size(); i++) {
                out.println("<p>x" + (i + 1) + " = " + resp.get(i) + "</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    public List<Double> calculaRaizes() {
        List<Double> respostas = new ArrayList<>();

        Double delta = Math.pow(paramB, 2) - 4 * paramA * paramC;
        Double x1 = (-paramB + Math.sqrt(delta)) / (2 * paramA);
        Double x2 = (-paramB - Math.sqrt(delta)) / (2 * paramA);

        respostas.add(x1);
        respostas.add(x2);

        return respostas;
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
