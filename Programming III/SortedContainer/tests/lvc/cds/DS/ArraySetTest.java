package lvc.cds.DS;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ArraySetTest {
    public static final int SIZE = 1000;
    public static final int STR_LEN = 20;
    ArraySet<String> set;


    static String randoString(int sz) {
        StringBuilder sb = new StringBuilder("");
        Random r = new Random();

        for (int i=0; i<sz; ++i) {
            sb.append(r.nextInt(26) + 'a');
        }

        return sb.toString();
    }



    @Before
    public void setUp() throws Exception {
        set = new ArraySet<String>();

        for (int i=0; i<SIZE; ++i)
            set.add(randoString(STR_LEN));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test complete");
    }

    @Test
    public void contains() {
        assertTrue("set is unsorted", set.checkInvariant());

        for (int i=0; i<set.size(); ++i) {
            assertTrue("containment error", set.contains(set.get(i)));
        }

        for (int i=0; i<SIZE; ++i) {
            assertFalse("containment error", set.contains(randoString(STR_LEN + 1)));
        }
    }

    @Test
    public void add() {
        set = new ArraySet<String>();
        for (int i=0; i<SIZE; ++i) {
            String s = randoString(STR_LEN);
            int sz1 = set.size();
            int cnt1 = set.numEqual(s);
            set.add(s);
            int sz2 = set.size();
            int cnt2 = set.numEqual(s);
            assertTrue("set is unsorted", set.checkInvariant());
            assertEquals("size invariant failed", sz2, sz1 + 1);
            assertEquals("insertion failed", cnt2, cnt1 + 1);
        }
    }

    @Test
    public void remove() {
    }
}