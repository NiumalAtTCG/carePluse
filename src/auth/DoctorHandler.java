/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import model.User_Bean;
import view.DashboardDoctor;

public class DoctorHandler extends RoleHandler {
    @Override
    public void handleLogin(User_Bean user) {
        if (user.getRoleId() == 2) {
            DashboardDoctor doctorDashboard = new DashboardDoctor();
            doctorDashboard.setUserBean(user);
            doctorDashboard.setVisible(true);
        } else if (successor != null) {
            successor.handleLogin(user);
        }
    }
 @Override
    protected boolean hasPermission(String featureCode) {
        // Define what a Doctor can do. Use constants for feature codes.
        switch (featureCode) {
            case "VIEW_PATIENT_RECORDS":
            case "PRESCRIBE_MEDICATION":
            case "UPDATE_TREATMENT_PLAN":
            case "VIEW_APPOINTMENTS":
                return true; // Doctor has these permissions
            case "DELETE_PATIENT":
            case "BILLING_APPROVAL":
            case "MANAGE_STAFF":
                return false; // Doctor does NOT have these permissions
            default:
                return false; // Default deny for any unknown feature
        }
    }
}