/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
import sample.tbl_role.Tbl_RoleDAO;
import sample.tbl_role.Tbl_RoleDTO;
import sample.tbl_user.Tbl_UserDAO;
import sample.tbl_user.Tbl_UserDTO;

/**
 *
 * @author Acer
 */
@WebServlet(name = "PreUpdateServlet", urlPatterns = {"/PreUpdateServlet"})
public class PreUpdateServlet extends HttpServlet {
private static final String UPDATE_PAGE = "update.jsp";
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
        String username = request.getParameter("userName");
        String roleId = request.getParameter("id");
        
        int id = Integer.parseInt(roleId);
        String url = UPDATE_PAGE;
        try {
            HttpSession session = request.getSession();
            String ad = (String) session.getAttribute("USERNAME");
            if(username.equals(ad)) {
                url = "DispatchServlet?btAction=Search";
                request.setAttribute("UPDATEADMIN", "CANT UPDATE YOURSELF");
            }
            Tbl_RoleDAO roleDao = new Tbl_RoleDAO();
            List<Tbl_RoleDTO> listRole = roleDao.getListRole();
            String roleName = roleDao.getRoleName(id);
            Tbl_UserDAO userDao = new Tbl_UserDAO();
            
            request.setAttribute("LISTROLE", listRole);
           request.setAttribute("ROLENAME", roleName);
            
            
        } catch (SQLException ex) {
         log("PreUpdateServlet _ SQLException" + ex.getMessage());
    } catch (NamingException ex) {
         log("PreUpdateServlet _ NamingException" + ex.getMessage());
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
