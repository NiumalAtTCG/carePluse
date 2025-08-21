/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */


public class NurseUserDecorator extends UserDecorator {
    private static final String[] NURSE_PERMISSIONS = {
        "view_patient_records", "update_vital_signs", "schedule_appointments",
        "cancel_own_appointments", "administer_medication"
    };
    
    public NurseUserDecorator(User user) {
        super(user);
    }
    
    @Override
    public boolean hasPermission(String permission) {
        for (String nursePermission : NURSE_PERMISSIONS) {
            if (nursePermission.equals(permission)) {
                return true;
            }
        }
        return super.hasPermission(permission);
    }
}