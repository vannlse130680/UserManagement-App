/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_promotion;

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
public class Tbl_PromotionDAO implements Serializable {

    List<Tbl_PromotionDTO> history = null;

    public List<Tbl_PromotionDTO> getHistory() {
        return this.history;
    }

    public boolean insertToPromotionList(String username, int rank, String date) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "insert tbl_promotion(username, rank, date) values(?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setInt(2, rank);
                pst.setString(3, date);
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

    public boolean isAddedToPromotionList(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select username from tbl_promotion where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);

                rs = pst.executeQuery();

                if (rs.next()) {
                    return true;
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
        return false;
    }

    public boolean updateUserOnPromotionList(String username, int rank, String date) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "update tbl_promotion set rank = ?, date = ? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(3, username);
                pst.setInt(1, rank);
                pst.setString(2, date);
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

    public void loadHistory() throws SQLException, NamingException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select username, rank, date from tbl_promotion ORDER BY CONVERT(DATE, date) asc";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    String username = rs.getString("username");
                    int rank = rs.getInt("rank");
                    String date = rs.getString("date");
                    Tbl_PromotionDTO dto = new Tbl_PromotionDTO(username, rank, date);
                    if (history == null) {
                        history = new ArrayList<>();
                    }
                    history.add(dto);
                }

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }
}
