package bankAccount;


import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BankAccountTest {
    private final String name = "Bank";
    private final BigDecimal balance = BigDecimal.valueOf(10000);
    BankAccount bankAccount;
    @Before
    public void setUp(){
        bankAccount = new BankAccount(name, balance);
    }

    @Test
    public void testConstructor(){
        assertEquals(name, bankAccount.getName());
        assertEquals(balance, bankAccount.getBalance());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameWithLengthLessThan3(){
        bankAccount= new BankAccount("aa", balance);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameWithLengthMoreThan25(){
        bankAccount= new BankAccount("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", balance);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetBalanceWithInvalid(){
        bankAccount=new BankAccount(name, BigDecimal.valueOf(-20));
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testDepositWithInvalid(){
        bankAccount.deposit(BigDecimal.valueOf(-2));
    }
    @Test
    public void testDepositWithValid(){
        bankAccount.deposit(BigDecimal.valueOf(20));
        BigDecimal bigDecimal = BigDecimal.valueOf(10020);
        assertEquals(bigDecimal, bankAccount.getBalance());
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testWithdrawWithInvalid(){
        bankAccount.withdraw(BigDecimal.valueOf(-2));
    }
    @Test
    public void testWithdrawWithValid(){
        BigDecimal withdraw = bankAccount.withdraw(BigDecimal.valueOf(2000));
        BigDecimal bigDecimal = BigDecimal.valueOf(8000);
        assertEquals(bigDecimal, bankAccount.getBalance());
        assertEquals(BigDecimal.valueOf(2000), withdraw);
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testWithdrawWithInvalid2(){
        bankAccount.withdraw(BigDecimal.valueOf(20000));
    }
}