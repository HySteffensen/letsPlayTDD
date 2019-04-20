package com.htools.tdd;

public class SavingsAccountYear {
    private int startingBalance = 0;
    private int capitalGainsAmount = 0;
    private int interestRate = 0;

    public SavingsAccountYear(int amount, int interestRate) {
        this.startingBalance = amount;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int amount, int capitalGainsAmount, int interestRate) {
        this.startingBalance = amount;
        this.capitalGainsAmount = capitalGainsAmount;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingBalance() {
        return startingBalance() + (startingBalance() * interestRate / 100);
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public int withdrawal(int amount) {
        return startingBalance -= amount;
    }
}
