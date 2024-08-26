package custom_collections;

import org.junit.jupiter.api.Test;

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

    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }
}