package com.htools.tdd;

import org.junit.*;

import static org.junit.Assert.*;

public class _SavingsAccountYearTest {

    @Test
    public void startingBalanceMatchesConstructor() {
        SavingsAccountYear newAccount = newAccount();
        assertEquals(10000, newAccount.startingBalance());
    }

    @Test
    public void interestRateMatchesConstructor() {
        SavingsAccountYear newAccount = newAccount();
        assertEquals(10, newAccount.interestRate());
    }

    @Test
    public void endingBalanceAppliesInterestRate() {
        SavingsAccountYear newAccount = newAccount();
        assertEquals(11000, newAccount.endingBalance());
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccountYear newAccount = newAccount();
        assertEquals(newAccount.endingBalance(), newAccount.nextYear().startingBalance());
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }

    private SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }
}
