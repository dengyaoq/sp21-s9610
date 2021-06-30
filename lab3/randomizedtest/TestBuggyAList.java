package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        randomizedtest.BuggyAList<Integer> broken = new randomizedtest.BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        randomizedtest.BuggyAList<Integer> broken = new randomizedtest.BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int correctSize = correct.size();
                int brokenSize = broken.size();
                if (brokenSize != correctSize) {
                    System.out.println("Shit happens!");
                } else if (brokenSize == correctSize){
                    System.out.println("S'all good man!");
                }
            }
            if (operationNumber == 2 && correct.size() > 0) {
                //getLast
                int correctLast = correct.getLast();
                int brokenLast = broken.getLast();
                if (correctLast != brokenLast) {
                    System.out.println("Shit happens!");
                } else if (brokenLast == correctLast){
                    System.out.println("S'all good man!");
                }
            } else if (operationNumber == 3 && correct.size() > 0) {
                //removeLast
                correct.removeLast();
                broken.removeLast();
            }
        }
    }
}