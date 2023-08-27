package com.system;

public class Order {
    private int orderId;
    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}

    private boolean onPrescription;
    public boolean getOnPrescription() {return onPrescription;}
    private void setOnPrescription(boolean onPrescription) {
        this.onPrescription = onPrescription;
    }

    private Prescription prescription;
    public Prescription getPrescription() {
        return prescription;
    }
    private void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    void addPrescription(Prescription prescription) {
        this.onPrescription = true;
        this.prescription = prescription;
    }

    void removePrescription(Prescription prescription) {
        this.onPrescription = false;
        this.prescription = null;
    }

    private Glasses glasses;
    public Glasses getGlasses() {return glasses;}
    public void setGlasses(Glasses glasses) {this.glasses = glasses;}

    private Customer customer;
    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}

    private OrderStatus status;
    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}

    double getPrice(){
        return glasses.getPrice();
    }

    Order(int orderId, Glasses glasses, Customer customer) {
        this.orderId = orderId;
        this.glasses = glasses;
        this.customer = customer;
        setStatus(OrderStatus.IN_PROGRESS);
        setOnPrescription(false);
    }

    Order(int orderId, Glasses glasses, Customer customer, Prescription prescription) {
        this.orderId = orderId;
        this.glasses = glasses;
        this.customer = customer;
        setStatus(OrderStatus.IN_PROGRESS);
        addPrescription(prescription);
    }
}
enum OrderStatus {IN_PROGRESS, READY, DONE}
