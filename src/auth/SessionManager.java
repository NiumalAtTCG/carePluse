/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;
import model.User;
import javax.swing.JComponent;
import model.User;

/**
 *
 * @author User
 */








public class SessionManager {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    // Helper method to check permissions easily anywhere in the app
    public static boolean currentUserHasPermission(String permissionCode) {
        if (currentUser != null) {
            return currentUser.hasPermission(permissionCode);
        }
        return false; // No user is logged in
    }
}