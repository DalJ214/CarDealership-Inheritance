package com.pluralsight.dealership;

abstract class Contract {

    private String date, customerName, customerEmail;
    private boolean vehicleSold;


    public Contract(String date, String customerName, String customerEmail, boolean vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }
    abstract double totalPrice();
    abstract double monthlyPayment();


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(boolean vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    public abstract  double getTotalPrice();

    public abstract double getMonthlypayment();

    // Method to calculate the monthly payment for the lease contract
    public abstract double getMonthlyPayment();
}
