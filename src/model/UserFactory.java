/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */

public class UserFactory {
    public static User createDecoratedUser(User_Bean bean) {
        User baseUser = new BaseUser(bean.getUsername(),bean.getFname(),bean.getLname(),bean.getRoleId());
        
        switch (bean.getRoleId()) {
            case 1: // Admin
                return new AdminUserDecorator(baseUser);
            case 2: // Doctor
                return new DoctorUserDecorator(baseUser);
            case 3: // Pharmacist
                return new PharmacistUserDecorator(baseUser);
            case 4: // Nurse
                return new NurseUserDecorator(baseUser);
            default:
                return baseUser;
        }
    }
}