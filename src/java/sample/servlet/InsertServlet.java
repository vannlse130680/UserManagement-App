/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import errors.InsertErrors;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.tbl_user.Tbl_UserDAO;

/**
 *
 * @author Acer
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet {

    private static final String ERROR_PAGE = "PreInsertServlet";
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
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String conPassword = request.getParameter("conPassword");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String photo = request.getParameter("source");
        int roleId = Integer.parseInt(request.getParameter("roleName"));
        String emailFomat = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String phoneFormat = "\\d{10,15}";
        String url = ERROR_PAGE;
        try {
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("USER");
            if (user == null) {
                url = "login.html";
            } else {
                InsertErrors errors = new InsertErrors();
                boolean foundError = false;
                Tbl_UserDAO dao = new Tbl_UserDAO();
                if (userName.trim().isEmpty()) {
                    foundError = true;
                    errors.setUserName("Please enter userID !");
                } else {
                    if (dao.isDuplicateUserName(userName)) {
                        foundError = true;
                        errors.setUserName("This userID is duplicated !");
                    }

                }
                if (password.trim().isEmpty()) {
                    foundError = true;
                    errors.setPassword("Please enter password !");
                } else if (!password.equals(conPassword)) {
                    foundError = true;
                    errors.setNotMactchPassword("Cofirm must match password !");
                }
                if (fullName.trim().isEmpty()) {
                    foundError = true;
                    errors.setFullName("Please enter full name!");
                }
                if (!email.trim().matches(emailFomat)) {
                    foundError = true;
                    errors.setEmail("Incorret format of email");
                }
                if (!phone.trim().matches(phoneFormat)) {
                    foundError = true;
                    errors.setPhone("Incorrect phone number format (10-15)");
                }
                if (photo.trim().isEmpty()) {

                    foundError = true;
                    errors.setPhoto("Pleaes choose an image !");
                } else if (!photo.substring(photo.lastIndexOf("\\")).contains(".jpg") && !photo.substring(photo.lastIndexOf("\\")).contains(".png") && !photo.substring(photo.lastIndexOf("\\")).contains(".gif")) {
                    foundError = true;
                    errors.setPhoto("This file is not support");
                }
                if (foundError) {

                    request.setAttribute("INSERTERRORS", errors);
                } else {
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
                    String encoded = Base64.getEncoder().encodeToString(encodedhash);
                    boolean result = dao.insertUser(userName, fullName, encoded, email, phone, photo, roleId);

                    if (result) {
                        url = SEARCH_PAGE;
                    }
                }
            }

        } catch (SQLException ex) {
            log("InsertServlet _ SQLException" + ex.getMessage());
        } catch (NamingException ex) {
            log("InsertServlet _ NamingException" + ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            log("InsertServlet _ NoSuchAlgorithmException" + ex.getMessage());
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
