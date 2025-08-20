/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import model.User_Bean;
import view.DashboardAdmin;

public class AdminHandler extends RoleHandler {
    @Override
    public void handleLogin(User_Bean user) {
        if (user.getRoleId() == 1) { // Check if this handler is responsible
            DashboardAdmin adminDashboard = new DashboardAdmin();
            adminDashboard.setUserBean(user);
            adminDashboard.setVisible(true);
            // You can also set specific permissions or context here
        } else if (successor != null) {
            // Pass the request to the next handler in the chain
            successor.handleLogin(user);
        }
        // Else, the chain ends. No one handled the request.
    }
 @Override
    protected boolean hasPermission(String featureCode) {
        // Admin has all permissions
        switch (featureCode) {
            case "VIEW_PATIENT_RECORDS":
            case "PRESCRIBE_MEDICATION":
            case "UPDATE_TREATMENT_PLAN":
            case "VIEW_APPOINTMENTS":
            case "DELETE_PATIENT":
            case "BILLING_APPROVAL":
            case "MANAGE_STAFF":
            case "MANAGE_INVENTORY":
            case "GENERATE_REPORTS":
            case "SYSTEM_CONFIGURATION":
                return true; // Admin has all permissions
            default:
                return true; // Default allow for any unknown feature for admin
        }
    }
}