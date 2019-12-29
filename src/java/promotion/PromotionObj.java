/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotion;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import sample.tbl_user.Tbl_UserDTO;

/**
 *
 * @author Acer
 */
public class PromotionObj implements Serializable{
    private String userName;
    private Map<String, User> promotionList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, User> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(Map<String, User> promotionList) {
        this.promotionList = promotionList;
    }

    public boolean isUserOnList(User u) {
        if (this.promotionList == null) {
            this.promotionList = new HashMap<>();
            
        }
        
        if(this.promotionList.containsKey(u.userName)) {
           return true;
        }
        return false;
    }
    public void addUserToPromotionList(User u) {
        if (this.promotionList == null) {
            this.promotionList = new HashMap<>();
            
        }
        
        
         this.promotionList.put(u.userName, u);
    }
    
    public void removeUserFromPromotionList(String title) {
        if (this.promotionList == null) {
            return;
        }
        if (this.promotionList.containsKey(title)) {
            this.promotionList.remove(title);
            if(this.promotionList.isEmpty()) {
                this.promotionList = null;
            }
        }
    }

    

   
}
