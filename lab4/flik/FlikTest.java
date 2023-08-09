package flik;

import org.junit.Assert;
import org.junit.Test;

public class FlikTest {
    @Test
    public void test() {
        for (int i = 1000; i < 10000; i++) {
            Assert.assertTrue(Flik.isSameNumber(i, i));
            Assert.assertFalse(Flik.isSameNumber(i, i - 1));
        }
    }
}
