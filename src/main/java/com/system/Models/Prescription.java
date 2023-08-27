package com.system;

public class Prescription {

    private int prescriptionId;
    public int getPrescriptionId() {return prescriptionId;}
    public void setPrescriptionId(int prescriptionId) {this.prescriptionId = prescriptionId;}

    private int prescriptionCode;
    public int getPrescriptionCode() {return prescriptionCode;}

    private String prescriptionDetails;
    public String getPrescriptionDetails() {return prescriptionDetails;}
    public void setPrescriptionDetails(String prescriptionDetails) {this.prescriptionDetails = prescriptionDetails;}

    private boolean completed;
    public boolean getCompleted() {return completed;}
    public void setCompleted(boolean completed) {this.completed = completed;}

    public Prescription(int prescriptionId, String prescriptionDetails) {
        this.prescriptionId = prescriptionId;
        this.prescriptionCode = (int)Math.floor(Math.random() * (9999 - 1111 + 1) + 1111);;
        this.prescriptionDetails = prescriptionDetails;
        setCompleted(false);
    }
}

