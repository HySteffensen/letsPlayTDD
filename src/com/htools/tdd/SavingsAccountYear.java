package com.htools.tdd;

public class SavingsAccountYear {
    private int startingBalance = 0;
    private int capitalGainsAmount = 0;
    private int interestRate = 0;
    private int totalWithdrawn = 0;

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

    public int startingPrincipal() {
        return startingBalance - capitalGainsAmount;
    }

    public int interestRate() {
        return interestRate;
    }

    public int endingPrincipal() {
        int result = startingPrincipal() - totalWithdrawn;
        return (result < 0) ? 0 : result;
    }

    public int endingBalance() {
        int modifiedStart = startingBalance - totalWithdrawn;
        return modifiedStart + (modifiedStart * interestRate / 100);
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public void withdrawal(int amount) {
        this.totalWithdrawn += amount;
    }

}
