/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package securelogin;

/**
 *
 * @author ndaed
 */
public class UserNameFormat {
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }
}
