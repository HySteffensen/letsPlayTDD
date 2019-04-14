package com.htools.tdd;

import org.junit.*;

import static org.junit.Assert.*;

public class _SavingsAccountTest {
    
    @Test
    public void depositAndWithdrawal(){
        SavingsAccount account = new SavingsAccount();
        account.deposit(100);
        assertEquals(100, account.balance());
        account.withdrawal(50);
        assertEquals(50, account.balance());
    }

    @Test
    public void negativeBalanceIsJustFine() {
        SavingsAccount account = new SavingsAccount();
        account.withdrawal(75);
        assertEquals(-75, account.balance());
    }

    @Test
    public void nextYear() {
        SavingsAccount account = new SavingsAccount();
        account.deposit(1000);
        SavingsAccount nextYear = account.nextYear(10);
        assertEquals(1100, nextYear.balance());

    }

}
