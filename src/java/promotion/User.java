/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotion;

import java.io.Serializable;

/**
 *
 * @author Acer
 */
public class User implements Serializable {

    String userName;
    
    String fullName;
    int rank;

    public User() {
    }

    public User(String userName, String fullName, int rank) {
        this.userName = userName;
        this.fullName = fullName;
        this.rank = rank;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

   

}
