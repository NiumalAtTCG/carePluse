/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */

public interface User {
    String getUsername();
    String getFname();
    String getLname();
    int getRoleId();
    boolean hasPermission(String permission);

}
