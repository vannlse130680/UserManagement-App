/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errors;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class InsertErrors implements Serializable {

    String userName;
    String password;
    String notMactchPassword;
    String fullName;
    String email;
    String phone;
    String photo;

    public InsertErrors() {
    }

    public InsertErrors(String userName, String password, String notMactchPassword, String fullName, String email, String phone, String photo) {
        this.userName = userName;
        this.password = password;
        this.notMactchPassword = notMactchPassword;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
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

    public String getNotMactchPassword() {
        return notMactchPassword;
    }

    public void setNotMactchPassword(String notMactchPassword) {
        this.notMactchPassword = notMactchPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

   
}
