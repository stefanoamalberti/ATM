package Test;

import org.junit.*;
import Code.Business_logic.Euro;

public class EuroTest {
    Euro e1, e2, e3, e4, e5;

    @Before
    public void setup() {
        e1 = new Euro(100.00);
        e2 = new Euro(59, 99);
        e3 = new Euro(-10, 50);
        e4 = new Euro(100, 0);
        e5 = new Euro(59, 98);
    }

    @Test
    public void testGetValore1() {
        Assert.assertEquals(10000.00, e1.getValore(), 0.0);
    }

    @Test
    public void testGetValore2() {
        Assert.assertEquals(5999.00, e2.getValore(), 0.0);
    }

    @Test
    public void testGetValore3() {
        Assert.assertEquals(-1050.00, e3.getValore(), 0.0);
    }

    @Test
    public void testGetValore4() {
        Assert.assertEquals(10000.00, e4.getValore(), 0.0);
    }

    @Test
    public void testGetValore5() {
        Assert.assertEquals(5998.00, e5.getValore(), 0.0);
    }

    @Test
    public void testSomma1() {
        Assert.assertEquals(15999.00, e1.somma(e2).getValore(), 0.0);
    }

    @Test
    public void testSomma2() {
        Assert.assertEquals(20000.00, e1.somma(e1).getValore(), 0.0);
    }

    @Test
    public void testSottrai1() {
        Assert.assertEquals(4001.00, e1.sottrai(e2).getValore(), 0.0);
    }

    @Test
    public void testSottrai2() {
        Assert.assertEquals(-4001.00, e2.sottrai(e1).getValore(), 0.0);
    }

    @Test
    public void testUgualeA() {
        Assert.assertTrue(e1.ugualeA(e4));
    }

    @Test
    public void testNonUgualeA() {
        Assert.assertTrue(!(e2.ugualeA(e5)));
    }

    @Test
    public void testMinoreDi1() {
        Assert.assertTrue(e5.minoreDi(e2));
    }

    @Test
    public void testMinoreDi2() {
        Assert.assertTrue((e1.minoreDi(e4)));
    }

    @Test
    public void testStampa1() {
        Assert.assertEquals("100.0 euro", e1.stampa());
    }

    @Test
    public void testStampa2() {
        Assert.assertEquals("-10.5 euro", e3.stampa());
    }
}