package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Code.Business_logic.Euro;
import Code.Database.Account;

public class AccountTest {
    Account a1, a2, a3, a4, a5;

    @Before
    public void setup() {
        a1 = new Account(1, 1234, new Euro(100), new Euro(100));
        a2 = new Account(2, 1234, new Euro(0), new Euro(-700));
        a3 = new Account(3, 1234, new Euro(100), new Euro(700));
        a4 = new Account(4, 1234, new Euro(100), new Euro(700));
    }

    @Test
    public void testCredit() {
        a1.credit(new Euro(100));
        Assert.assertEquals(200.00, a1.getTotalBalance().getValoreDouble(), 0);
        
        a2.credit(new Euro(1000));
        Assert.assertEquals(300, a2.getTotalBalance().getValoreDouble(), 0);
    }

    @Test
    public void testDebit() {
        a3.debit(new Euro(500));
        Assert.assertEquals(-400, a3.getAvailableBalance().getValoreDouble(), 0);
        Assert.assertEquals(200, a3.getTotalBalance().getValoreDouble(), 0);

        a4.debit(new Euro(200));
        Assert.assertEquals(-100, a4.getAvailableBalance().getValoreDouble(), 0);
        Assert.assertEquals(500, a4.getTotalBalance().getValoreDouble(), 0);
    }
}