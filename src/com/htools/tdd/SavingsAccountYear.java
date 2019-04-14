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

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);
    }

    public int endingBalance() {
        return startingBalance() + (startingBalance() * interestRate / 100);
    }

    public int interestRate() {
        return interestRate;
    }
}
