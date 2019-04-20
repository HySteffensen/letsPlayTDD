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
        assertEquals(11000, newAccount.endingBalance(25));
    }

    @Test
    public void nextYearsStartingBalanceEqualsThisYearsEndingBalance() {
        SavingsAccountYear newAccount = newAccount();
        assertEquals(newAccount.endingBalance(25), newAccount.nextYear(25).startingBalance());
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate() {
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear(25).interestRate());
    }

    @Test
    public void withdrawingFundsOccursAtTheBeginningOfTheYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdrawal(1000);
        assertEquals(9900, year.endingBalance(25));
    }

    @Test
    public void multipleWithdrawalsInAYear() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 10);
        year.withdrawal(1000);
        year.withdrawal(2000);
        assertEquals(3000, year.totalWithdrawn());
    }

    @Test
    public void startingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        assertEquals(3000, year.startingPrincipal());
    }

    @Test
    public void endingPrincipal() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdrawal(2000);
        assertEquals("ending principal", 1000, year.endingPrincipal(25));
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdrawal(4000);
        assertEquals("ending principal", 0, year.endingPrincipal(25));
    }

    @Test
    public void capitalGainsWithdrawn() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdrawal(1000);
        assertEquals(0, year.capitalGainsWithdrawn());
        year.withdrawal(3000);
        assertEquals(1000, year.capitalGainsWithdrawn());
    }

    @Test
    public void capitalGainsTaxIncurred_NeedsToCoverCapitalGainsWithdrawn_AND_theAdditionalCapitalGainsWithdrawnToPayCapitalGainsTax() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        year.withdrawal(5000);
        assertEquals(2000, year.capitalGainsWithdrawn());
        assertEquals(666, year.capitalGainsTaxIncurred(25));
    }

    @Test
    public void capitalGainsTaxIsIncludedInEndingBalance() {
        SavingsAccountYear year = new SavingsAccountYear(10000, 3000, 10);
        int amountWithdrawn = 5000;
        year.withdrawal(amountWithdrawn);
        int expectedCapitalGainsTax = 666;
        assertEquals(expectedCapitalGainsTax, year.capitalGainsTaxIncurred(25));
        int expectedStartingBalanceAfterWithdrawals = 10000 - amountWithdrawn - expectedCapitalGainsTax;
        assertEquals((int)(expectedStartingBalanceAfterWithdrawals * 1.10), year.endingBalance(25));
        // TODO: Need to withdraw enough money to cover capital gains tax; that money will also be taxed
    }

    private SavingsAccountYear newAccount() {
        SavingsAccountYear account = new SavingsAccountYear(10000, 10);
        return account;
    }
}
