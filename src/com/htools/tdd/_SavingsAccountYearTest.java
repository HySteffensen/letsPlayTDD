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

    @Test
    public void withdrawingFundsOccursAtTheBeginningOfTheYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdrawal(1000);
        assertEquals(9900, year.endingBalance());
    }

    @Test
    public void multipleWithdrawalsInAYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdrawal(1000);
        year.withdrawal(2000);
        assertEquals(7700, year.endingBalance());
    }

    @Test
    public void startingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals(3000, year.startingPrincipal());
    }

    @Test
    public void endingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("starting principal", 3000, year.startingPrincipal());
        year.withdrawal(2000);
        assertEquals("ending principal", 1000, year.endingPrincipal());
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("starting principal", 3000, year.startingPrincipal());
        year.withdrawal(4000);
        assertEquals("ending principal", 0, year.endingPrincipal());

    }


//    @Test
//    public void withdrawingMoreThanPrincipalIncursCapitalGainsTax(){
//        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
//        year.withdrawal(3000);
//        assertEquals(7700, year.endingBalance());
//        year.withdrawal(5000);
//        assertEquals(2000 + 200 - (1250), year.endingBalance());
//    }

    private SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }
}
