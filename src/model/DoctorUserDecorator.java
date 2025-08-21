/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */


public class DoctorUserDecorator extends UserDecorator {
    private static final String[] DOCTOR_PERMISSIONS = {
        "view_patient_records", "edit_patient_records", "prescribe_medication",
        "schedule_appointments", "cancel_own_appointments", "view_lab_results"
    };
    
    public DoctorUserDecorator(User user) {
        super(user);
    }
    
    @Override
    public boolean hasPermission(String permission) {
        for (String doctorPermission : DOCTOR_PERMISSIONS) {
            if (doctorPermission.equals(permission)) {
                return true;
            }
        }
        return super.hasPermission(permission);
    }
}