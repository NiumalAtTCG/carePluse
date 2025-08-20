/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import model.User_Bean;
import view.DashboardDoctor; // Assuming nurse uses a similar dashboard for now

public class NurseHandler extends RoleHandler {
    @Override
    public void handleLogin(User_Bean user) {
        if (user.getRoleId() == 4) {
            // In a real system, you might have a DashboardNurse
            // For now, we'll reuse the doctor view but this demonstrates the pattern.
            DashboardDoctor nurseDashboard = new DashboardDoctor();
            nurseDashboard.setUserBean(user);
            nurseDashboard.setTitle("Nurse Dashboard - " + user.getFname()); // Customize title
            nurseDashboard.setVisible(true);
        } else if (successor != null) {
            successor.handleLogin(user);
        }
    }
@Override
    protected boolean hasPermission(String featureCode) {
        // Define what a Nurse can do
        switch (featureCode) {
            case "VIEW_PATIENT_RECORDS":
            case "UPDATE_PATIENT_VITALS":
            case "ASSIST_IN_TREATMENTS":
            case "VIEW_APPOINTMENTS":
            case "SCHEDULE_APPOINTMENTS":
            case "UPDATE_TREATMENT_PLAN": // Limited to assisting
                return true; // Nurse has these permissions
            case "PRESCRIBE_MEDICATION":
            case "DELETE_PATIENT":
            case "BILLING_APPROVAL":
            case "MANAGE_STAFF":
            case "MANAGE_INVENTORY":
                return false; // Nurse does NOT have these permissions
            default:
                return false; // Default deny for any unknown feature
        }
    }
}