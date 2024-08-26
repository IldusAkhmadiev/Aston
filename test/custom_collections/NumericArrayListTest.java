package custom_collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumericArrayListTest {

    @Test
    void createNumericArrayListAsInteger() {
        NumericArrayList numericArrayList2 = new NumericArrayList(new Integer[]{1,2,3,4,5,8,10});
        assertTrue(numericArrayList2 != null);
    }
    @Test
    void createNumericArrayListAsDouble() {
        NumericArrayList numericArrayList2 = new NumericArrayList(new Double[]{1.3,2.7,3.9,4.1,5.0,8d,10d});
        assertTrue(numericArrayList2 != null);
    }


    @Test
    void add() {
        NumericArrayList n1 = new NumericArrayList(new Integer[]{1,2,3,4,5,8,10});
        n1.add(10000);
        assertEquals(10000, n1.get(n1.size()-1));
    }

    @Test
    void remove() {
        NumericArrayList<Integer> n1 = new NumericArrayList<>(new Integer[]{12,22,33,44,55,8,10});
        n1.remove(1); // 22
        assertEquals(6, n1.size());
    }

    @Test
    void get() {
        NumericArrayList<Integer> n1 = new NumericArrayList<>(new Integer[]{12,22,33,44,55,8,10});
        Integer i = n1.get(0);
        assertEquals(12,i);
        Integer i2 = n1.get(-233);
        assertEquals(12,i2);
        Integer i3 = n1.get(99999);
        assertEquals(10,i3);
    }

    @Test
    void createAsClazz() {
        NumericArrayList numericArrayList = new NumericArrayList(Integer.class);
        assertTrue(numericArrayList != null);
    }

    @Test
    void addAll() {
        NumericArrayList<Integer> n1 = new NumericArrayList(new Integer[]{1,2,3,4,5,8,10});
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(111);
        integers.add(222);
        integers.add(333);
        n1.addAll(integers);
        assertEquals(10, n1.size());
    }

    @Test
    void size() {
        NumericArrayList<Integer> n1 = new NumericArrayList(new Integer[]{1,2,3,4,5,8,10});
        assertEquals(7, n1.size());
    }
}