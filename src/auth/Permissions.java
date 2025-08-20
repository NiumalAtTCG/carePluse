/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

public final class Permissions {
    private Permissions() {} // Prevent instantiation

    // Patient Records
    public static final String VIEW_PATIENT_RECORDS = "VIEW_PATIENT_RECORDS";
    public static final String EDIT_PATIENT_RECORDS = "EDIT_PATIENT_RECORDS";
    public static final String DELETE_PATIENT = "DELETE_PATIENT";

    // Appointments
    public static final String SCHEDULE_APPOINTMENT = "SCHEDULE_APPOINTMENT";
    public static final String VIEW_APPOINTMENTS = "VIEW_APPOINTMENTS";
    public static final String CANCEL_APPOINTMENT = "CANCEL_APPOINTMENT";

    // Pharmacy
    public static final String DISPENSE_MEDICATION = "DISPENSE_MEDICATION";
    public static final String VIEW_INVENTORY = "VIEW_INVENTORY";

    // Billing
    public static final String GENERATE_BILL = "GENERATE_BILL";
    public static final String BILLING_APPROVAL = "BILLING_APPROVAL";

    // Administration
    public static final String MANAGE_STAFF = "MANAGE_STAFF";
    public static final String VIEW_FINANCIAL_REPORTS = "VIEW_FINANCIAL_REPORTS";

    // ... add more as needed
}
