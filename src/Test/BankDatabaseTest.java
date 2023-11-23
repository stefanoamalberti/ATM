package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Code.Business_logic.Euro;
import Code.Database.BankDatabase;

public class BankDatabaseTest {
    
    @Test
    public void testAuthenticateUser() {
        // Create a BankDatabase object
        BankDatabase bankDatabase = new BankDatabase();

        // Test case 1: Valid account number and PIN
        assertTrue(bankDatabase.authenticateUser(12345, 54321));

        // Test case 2: Invalid account number and PIN
        assertFalse(bankDatabase.authenticateUser(98765, 54569));
    }

    @Test
    public void testCredit() {
        // Create a BankDatabase object
        BankDatabase bankDatabase = new BankDatabase();

        // Test case 1: Credit amount to an account
        bankDatabase.credit(12345, new Euro(100));
        assertEquals(100000, bankDatabase.getAvailableBalance(12345).getValore());

        // Test case 2: Credit negative amount to an account
        bankDatabase.credit(12345, new Euro(-50));
        assertEquals(100000, bankDatabase.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testDebit() {
        // Create a BankDatabase object
        BankDatabase bankDatabase = new BankDatabase();

        // Test case 1: Debit amount from an account with sufficient balance
        bankDatabase.credit(12345, new Euro(100));
        bankDatabase.debit(12345, new Euro(50));
        assertEquals(95000, bankDatabase.getAvailableBalance(12345).getValore());

        // Test case 2: Debit amount from an account with insufficient balance
        bankDatabase.debit(12345, new Euro(100));
        assertEquals(85000, bankDatabase.getAvailableBalance(12345).getValore());
    }

    @Test
    public void testGetAvailableBalance() {
        // Create a BankDatabase object
        BankDatabase bankDatabase = new BankDatabase();
        

        // Test case 1: Get available balance of an account
        bankDatabase.credit(12345, new Euro(100));
        assertEquals(100000, bankDatabase.getAvailableBalance(12345).getValore());

        // Test case 2: Get available balance of an account with no transactions
        assertEquals(20000, bankDatabase.getAvailableBalance(98765).getValore());
    }

    @Test
    public void testGetTotalBalance() {
        // Create a BankDatabase object
        BankDatabase bankDatabase = new BankDatabase();

        // Test case 1: Get total balance of an account
        bankDatabase.credit(12345, new Euro(100));
        assertEquals(130000, bankDatabase.getTotalBalance(12345).getValore());

        // Test case 2: Get total balance of an account with no transactions
        assertEquals(20000, bankDatabase.getTotalBalance(98765).getValore());
    }
}
