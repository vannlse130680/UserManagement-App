/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Acer
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String LOGOUT_SERVLET = "LogoutServlet";
    private final String SEARCH_SERVLET = "SearchServlet";
    private final String DELETE_SERVLET = "DeleteServlet";
    private final String PREPARE_UPDATE_SERVLET = "PreUpdateServlet";
    private final String UPDATE_SERVLET = "UpdateServlet";
    private final String PRE_INSERT_SERVLET = "PreInsertServlet";
    private final String INSERT_SERVLET = "InsertServlet";
    private final String ADD_SERVLET = "AddToPromotionServlet";
    private final String REMOVE_SERVLET = "RemovePromtionServlet";
    private final String UPDATE_PROMOTION_SERVLET = "UpdatePromotionServlet";
     private final String CONFIRM_SERVLET = "ConfirmServlet";
     private final String VIEW_HISTORY_SERVLET = "ViewHistoryServlet";

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

        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {

            if (button == null) {

            } else if (button.equals("Login")) {
                url = LOGIN_SERVLET;
            } else if (button.equals("Logout")) {
                url = LOGOUT_SERVLET;
            } else if (button.equals("Search")) {
                url = SEARCH_SERVLET;
            } else if (button.equals("Delete")) {
                url = DELETE_SERVLET;
            } else if (button.equals("Update")) {
                url = PREPARE_UPDATE_SERVLET;
            } else if (button.equals("Update Information")) {
                url = UPDATE_SERVLET;
            } else if (button.equals("Insert")) {
                url = PRE_INSERT_SERVLET;
            } else if (button.equals("Create Account")) {
                url = INSERT_SERVLET;
            } else if (button.equals("Cancel")) {
                url = SEARCH_SERVLET;
            } else if (button.equals("Add To Promotion List")) {
                url = ADD_SERVLET;
            } else if (button.equals("Remove")) {
                url = REMOVE_SERVLET;
            } else if (button.equals("Update Rank")) {
                url = UPDATE_PROMOTION_SERVLET;
            } else if (button.equals("Confirm")) {
                url = CONFIRM_SERVLET;
            } else if (button.equals("History")) {
                url = VIEW_HISTORY_SERVLET;
            } 
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
