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

    public void negativeBalanceIsJustFine() {
        SavingsAccount account = new SavingsAccount();
        account.withdrawal(75);
        assertEquals(-75, account.balance());
    }
}
