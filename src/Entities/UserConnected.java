/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Oussama
 */
public class UserConnected {
  private  static int userId;  

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserConnected.userId = userId;
    }
    
}
