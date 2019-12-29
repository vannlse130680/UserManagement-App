/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_role;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Tbl_RoleDTO implements Serializable{
    int roleId;
    String roleName;

    public Tbl_RoleDTO() {
    }

    public Tbl_RoleDTO(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
    
    
}
