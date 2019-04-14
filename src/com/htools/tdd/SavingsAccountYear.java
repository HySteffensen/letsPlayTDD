package com.htools.tdd;

public class SavingsAccountYear {
    private int startingBalance = 0;
    private int interestRate = 0;

    public SavingsAccountYear() { }

    public SavingsAccountYear(int amount, int interestRate) {
        this.startingBalance = amount;
        this.interestRate = interestRate;
    }

    public int startingBalance() {
        return startingBalance;
    }

    public void deposit(int amount) {
        startingBalance += amount;
    }

    public int balance() {
        return startingBalance;
    }

    public void withdrawal(int amount) {
        startingBalance -= amount;
    }


    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public int endingBalance() {
        return balance() + (balance() * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }
}
