package com.pluralsight.dealership;

public class SalesContract extends Contract{

        private double vehiclePrice, salesTax, recordingFee, processingFee;

        private boolean isFinanced;


    public SalesContract(String date, String customerName, String customerEmail, boolean vehicleSold,
                         double vehiclePrice, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.vehiclePrice = vehiclePrice;
        this.isFinanced = isFinanced;

        // Initialize fees and sales tax based on the vehicle price
        this.salesTax = 0.05 * vehiclePrice; // 5% Sales tax
        this.recordingFee = 100.00; // Flat $100 recording fee
        this.processingFee = (vehiclePrice < 10000) ? 295.00 : 495.00; // Processing fee based on vehicle price
    }

    // Getter and setter methods for salesTax, recordingFee, processingFee, and isFinanced
    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    // Calculate the total price (including sales tax, recording fee, and processing fee)
    public double totalPrice() {
        return vehiclePrice + salesTax + recordingFee + processingFee;
    }

    // Calculate the monthly payment based on whether the vehicle is financed
    public double monthlyPayment() {
        if (!isFinanced) {
            return 0; // If not financed, return 0
        }

        double loanAmount = totalPrice(); // Total price is the loan amount
        double annualInterestRate = (vehiclePrice >= 10000) ? 4.25 / 100 : 5.25 / 100; // Interest rate based on vehicle price
        int months = (vehiclePrice >= 10000) ? 48 : 24; // Loan term based on vehicle price

        double monthlyInterestRate = annualInterestRate / 12; // Monthly interest rate
        double denominator = Math.pow(1 + monthlyInterestRate, months) - 1;
        double monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / denominator;

        return monthlyPayment;
    }

    // Getters for the total price and monthly payment
    public double getTotalPrice() {
        return totalPrice();
    }

    @Override
    public double getMonthlypayment() {
        return 0;
    }


}
