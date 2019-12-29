/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.tbl_user;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class Tbl_UserDTO implements Serializable{
    String userName;
    String password;
    String fullName;
    String phone;
    int role;
    String photo;
    String email;
    String status;
    public Tbl_UserDTO() {
    }

    public Tbl_UserDTO(String userName, String password, String fullName, String phone, int role, String photo, String email, String status) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
        this.photo = photo;
        this.email = email;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
