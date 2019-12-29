/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_role;

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
public class Tbl_RoleDAO implements Serializable {

    List<Tbl_RoleDTO> listRole;

    public List<Tbl_RoleDTO> getListRole() throws SQLException, NamingException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select roleid, rolename from tbl_role";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    int roleid = rs.getInt("roleid");
                    String rolename = rs.getString("rolename");
                    Tbl_RoleDTO dto = new Tbl_RoleDTO(roleid, rolename);
                    if (listRole == null) {
                        listRole = new ArrayList<>();
                    }
                    listRole.add(dto);
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
        return listRole;
    }

    public String getRoleName(int roleId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select rolename from tbl_role where roleid = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, roleId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getString("rolename");
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

}
