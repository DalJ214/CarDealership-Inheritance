package com.pluralsight.dealership;

public class LeaseContract extends Contract {

    private double vehiclePrice; // Original vehicle price
    private boolean isLeased;    // To track if the vehicle is leased or not
    private double leaseFeePercent; // Lease fee percentage (7% by default)
    private double expectedEndingValuePercent; // Expected ending value percentage (50% by default)
    private double leaseInterestRate; // Lease interest rate (4% by default)
    private int leaseTerm; // Lease term (36 months by default)

    // Constructor
    public LeaseContract(String date, String customerName, String customerEmail, boolean vehicleSold,
                         double vehiclePrice, boolean isLeased) {
        super(date, customerName, customerEmail, vehicleSold);
        this.vehiclePrice = vehiclePrice;
        this.isLeased = isLeased;

        // Default values, but they can be overridden when needed
        this.leaseFeePercent = 0.07; // 7% lease fee
        this.expectedEndingValuePercent = 0.50; // 50% expected ending value
        this.leaseInterestRate = 0.04; // 4% interest rate for leases
        this.leaseTerm = 36; // Lease term of 36 months
    }

    @Override
    double totalPrice() {
        return 0;
    }

    @Override
    double monthlyPayment() {
        return 0;
    }

    // Method to calculate the total price for the lease contract
    @Override
    public double getTotalPrice() {
        if (!isLeased) {
            return 0; // No total price if not leased
        }

        // Calculate the lease fee and expected ending value
        double leaseFee = vehiclePrice * leaseFeePercent;
        double expectedEndingValue = vehiclePrice * expectedEndingValuePercent;

        // Total price is the original vehicle price + lease fee - expected ending value
        return vehiclePrice + leaseFee - expectedEndingValue;
    }

    @Override
    public double getMonthlypayment() {
        return 0;
    }

    // Method to calculate the monthly payment for the lease contract
    @Override
    public double getMonthlyPayment() {
        if (!isLeased) {
            return 0; // No payment if not leased
        }

        // Calculate the amount to be financed (original price + lease fee - expected ending value)
        double amountFinanced = vehiclePrice + (vehiclePrice * leaseFeePercent) - (vehiclePrice * expectedEndingValuePercent);

        // Monthly interest rate and lease term
        double monthlyInterestRate = leaseInterestRate / 12; // Monthly interest rate
        int months = leaseTerm; // Lease term (36 months)

        // Loan amortization formula to calculate the monthly payment
        double denominator = Math.pow(1 + monthlyInterestRate, months) - 1;
        double monthlyPayment = amountFinanced * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / denominator;

        return monthlyPayment;
    }

}
