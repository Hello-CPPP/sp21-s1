package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> aListNoResizing = new AListNoResizing<>();
        BuggyAList<Integer> buggyAList = new BuggyAList<>();

        for (int i = 0; i < 88; i++) {
            aListNoResizing.addLast(i);
            buggyAList.addLast(i);
        }

        for (int i = 0; i < 88; i++) {
            Assert.assertEquals(aListNoResizing.removeLast(), buggyAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                Assert.assertEquals(size, sizeB);
                System.out.println("size: " + size);
            } else if (operationNumber == 2 && L.size() > 0) {
                int last = L.getLast();
                int lastB = B.getLast();
                Assert.assertEquals(last, lastB);
                System.out.println("last: " + last);
            } else if (operationNumber == 3 && L.size() > 0) {
                int last = L.removeLast();
                int lastB = B.removeLast();
                Assert.assertEquals(last, lastB);
                System.out.println("last: " + last);
            }
        }
    }
}
