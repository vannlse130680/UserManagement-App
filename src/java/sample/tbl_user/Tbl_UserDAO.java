/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtilities;

/**
 *
 * @author Acer
 */
public class Tbl_UserDAO implements Serializable {
    
    private List<Tbl_UserDTO> listUser;
    
    public List<Tbl_UserDTO> getListUser() {
        return listUser;
    }
    
    public int checkLogin(String userName, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select roleid from tbl_User where username = ? and password = ? and status = 'Active'";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    return rs.getInt("roleid");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;
    }
    
    public String getFullName(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select fullname from tbl_user where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getString("fullname");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return "";
    }
    
    public void searchUserByName(String name) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where fullname like ? and status = 'Active'";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                Tbl_UserDTO dto = new Tbl_UserDTO(userName, password, fullName, phone, role, photo, email, status);
                if (listUser == null) {
                    listUser = new ArrayList<>();
                }
                listUser.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void searchUserByNameAndRole(String name, int roleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where fullname like ? and roleid = ? and status = 'Active'";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            pst.setInt(2, roleId);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                Tbl_UserDTO dto = new Tbl_UserDTO(userName, password, fullName, phone, role, photo, email, status);
                if (listUser == null) {
                    listUser = new ArrayList<>();
                }
                listUser.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean deleteUser(String userName) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "update tbl_user set status = ? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, "Inactive");
                pst.setString(2, userName);
                
                int row = pst.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            }
            
        } finally {
            
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public void loadInfor(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                Tbl_UserDTO dto = new Tbl_UserDTO(userName, password, fullName, phone, role, photo, email, status);
                if (listUser == null) {
                    listUser = new ArrayList<>();
                }
                listUser.add(dto);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public boolean updateUser(String fullName, String oldUserName, String password, String email, String phone, String photo, int roleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "update tbl_user set fullName = ?, password = ?, email = ?, phone = ?, photo = ?, roleid =? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, fullName);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, photo);
                pst.setInt(6, roleId);
                pst.setString(7, oldUserName);
                int row = pst.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            }
            
        } finally {
            
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean isDuplicateUserName(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            String sql = "select username from tbl_user where username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    public boolean insertUser(String userName,String fullName, String password, String email, String phone, String photo, int roleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "insert tbl_user(username, password,fullname, email, phone, photo, roleid, status) values(?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                pst.setString(3, fullName);
                pst.setString(4, email);
                pst.setString(5, phone);
                pst.setString(6, photo);
                pst.setInt(7, roleId);
                pst.setString(8, "Active");
                
                int row = pst.executeUpdate();
                
                if (row > 0) {
                    return true;
                }
            }
            
        } finally {
            
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
