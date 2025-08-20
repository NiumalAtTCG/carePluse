/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import model.User_Bean;

public class AuthManager {
    private RoleHandler chain;

    public AuthManager() {
        buildChain();
    }

    private void buildChain() {
        // 1. Create all handlers
        RoleHandler adminHandler = new AdminHandler();
        RoleHandler doctorHandler = new DoctorHandler();
        RoleHandler pharmacistHandler = new PharmacistHandler();
        RoleHandler nurseHandler = new NurseHandler();

        // 2. Build the chain: Admin -> Doctor -> Pharmacist -> Nurse
        adminHandler.setSuccessor(doctorHandler);
        doctorHandler.setSuccessor(pharmacistHandler);
        pharmacistHandler.setSuccessor(nurseHandler);

        // 3. Set the starting point of the chain
        this.chain = adminHandler;
    }

    public void processLogin(User_Bean user) {
        if (chain != null) {
            chain.handleLogin(user);
        } else {
            System.err.println("Authentication chain not built.");
        }
    }
    public boolean userHasPermission(User_Bean user, String featureCode) {
        if (user == null || chain == null) {
            return false;
        }
        // Start the permission check at the beginning of the chain
        return chain.checkPermission(featureCode, user.getRoleId());
    }
}
