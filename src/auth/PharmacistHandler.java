/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import model.User_Bean;
import view.DashboardPharmacy;

public class PharmacistHandler extends RoleHandler {
    @Override
    public void handleLogin(User_Bean user) {
        if (user.getRoleId() == 3) {
            DashboardPharmacy pharmacyDashboard = new DashboardPharmacy();
            pharmacyDashboard.setUserBean(user);
            pharmacyDashboard.setVisible(true);
        } else if (successor != null) {
            successor.handleLogin(user);
        }
    }
 @Override
    protected boolean hasPermission(String featureCode) {
        // Define what a Pharmacist can do
        switch (featureCode) {
            case "VIEW_PATIENT_RECORDS":
            case "VIEW_PRESCRIPTIONS":
            case "DISPENSE_MEDICATION":
            case "MANAGE_INVENTORY":
            case "UPDATE_STOCK_LEVELS":
                return true; // Pharmacist has these permissions
            case "PRESCRIBE_MEDICATION":
            case "UPDATE_TREATMENT_PLAN":
            case "DELETE_PATIENT":
            case "BILLING_APPROVAL":
            case "MANAGE_STAFF":
                return false; // Pharmacist does NOT have these permissions
            default:
                return false; // Default deny for any unknown feature
        }
    }
}
