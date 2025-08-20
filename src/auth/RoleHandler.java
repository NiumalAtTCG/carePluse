/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;
import model.User_Bean;
/**
 *
 * @author User
 */
public abstract class RoleHandler {
    protected RoleHandler successor; // The next handler in the chain
    protected int roleId;

    public void setSuccessor(RoleHandler successor) {
        this.successor = successor;
    }

    // The method that handles the request
    public abstract void handleLogin(User_Bean user);
    
    
public boolean checkPermission(String featureCode, int userRoleId) {
        if (this.roleId == userRoleId) {
            // This is the correct handler for the user's role.
            // Now, check if the role has the requested permission.
            return hasPermission(featureCode);
        } else if (successor != null) {
            // Pass the request to the next handler in the chain
            return successor.checkPermission(featureCode, userRoleId);
        }
        // No handler could be found for this user's role (should not happen if chain is built correctly)
        return false;
    }

    // NEW: Abstract method each concrete handler must implement.
    // It defines the specific permissions for that role.
    protected abstract boolean hasPermission(String featureCode);
}