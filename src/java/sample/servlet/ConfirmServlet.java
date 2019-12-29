/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import promotion.PromotionObj;
import promotion.User;
import sample.tbl_promotion.Tbl_PromotionDAO;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ConfirmServlet", urlPatterns = {"/ConfirmServlet"})
public class ConfirmServlet extends HttpServlet {

    private static final String SEARCH_PAGE = "SearchServlet";

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
        PrintWriter out = response.getWriter();
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String url = SEARCH_PAGE;
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            String user = (String) session.getAttribute("USER");
            if (user == null) {
                url = "login.html";
            } else {
                if (session != null) {

                    PromotionObj promotion = (PromotionObj) session.getAttribute("PROMOTION");

                    if (promotion != null) {

                        Map<String, User> list = promotion.getPromotionList();
                        if (list != null) {

                            for (Map.Entry item : list.entrySet()) {
                                Tbl_PromotionDAO dao = new Tbl_PromotionDAO();
                                if (dao.isAddedToPromotionList((String) item.getKey())) {
                                    dao.updateUserOnPromotionList((String) item.getKey(), ((User) item.getValue()).getRank(), date.toString());
                                } else {
                                    dao.insertToPromotionList((String) item.getKey(), ((User) item.getValue()).getRank(), date.toString());
                                }

                            }
                        }
                        session.removeAttribute("PROMOTION");
                    }

                }
            }

        } catch (SQLException ex) {
            log("ConfirmServlet _ SQLException" + ex.getMessage());
        } catch (NamingException ex) {
            log("ConfirmServlet _ NamingException" + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
