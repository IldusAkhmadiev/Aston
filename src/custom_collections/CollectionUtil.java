package custom_collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollectionUtil {
    /**
     * Если последний элемент не null значит коллекция не полная
     */
    public static <T extends Number> boolean isFull(T[] t) {
        return t[t.length - 1] == null ? false : true;
    }

    public static NumericArrayList[] getNumericLists(int count, Class clazz) {
        NumericArrayList[] lists = new NumericArrayList[count];
        for (int i = 0; i < count; i++) {
            lists[i] = new NumericArrayList(clazz);
        }
        return lists;
    }

    public static Number[][] getRanges(Class clazz, int count) {
        clazz = CollectionUtil.deleteArray(clazz);
        Number[][] array = (Number[][]) Array.newInstance(clazz, count, 2);
        int allPositive = 0;
        int allNegative = 0;
        long allLongP = 0;
        long allLongN = 0;
        double allDoubleP = 0;
        double allDoubleN = 0;
        int half = count / 2;
        int size1array = 0;
        switch (clazz.getSimpleName()) {
            case "Integer":
                allPositive = Integer.MAX_VALUE;
                allNegative = Integer.MIN_VALUE;
                size1array = allPositive/2;
                break;
            case "Short":
                allPositive = Short.MAX_VALUE;
                allNegative = Short.MIN_VALUE;
                size1array = allPositive/2;
                break;
            case "Byte":
                allPositive = Byte.MAX_VALUE;
                allNegative = Byte.MIN_VALUE;
                size1array = allPositive/2;
                break;
            case "Long":
                allLongP = Long.MAX_VALUE;
                allLongN = Long.MIN_VALUE;
                size1array = (int) (allLongP/2);
                break;
            case "Float":
                allDoubleP = Float.MAX_VALUE;
                allDoubleN = Float.MIN_VALUE;
                size1array = (int) (allDoubleP/2);
                break;
            case "Double":
                allDoubleP = Double.MAX_VALUE;
                allDoubleN = Double.MIN_VALUE;
                size1array = (int) (allDoubleP/2);
                break;
        }
        switch (clazz.getSimpleName()) {
            case "Integer":
            case "Short":
            case "Byte":
            case "Long":
                for (int i = 1; i <= half; i++) {
                    Integer[] integers = new Integer[2];
                    integers[0] = -(size1array * (i - 1));
                    integers[1] = -(size1array * i);
                    array[half - i] = integers;
                }
                for (int i = 1; i <= half; i++) {
                    Integer[] integers = new Integer[2];
                    integers[0] = size1array * (i - 1);
                    integers[1] = size1array * i;
                    array[i + half - 1] = integers;
                }
            }

            switch (clazz.getSimpleName()) {
            case "Float":
            case "Double":
                    double step = (allDoubleP - allDoubleN) / count;
                    for (int i = 0; i < count; i++) {
                        Double[] doubles = new Double[2];
                        doubles[0] = allDoubleN + i * step;
                        doubles[1] = allDoubleN + (i + 1) * step;
                        array[i] = doubles;
                    }
                    break;
            }

            return array;
        }

    public static Class deleteArray (Class clazz){

        switch (clazz.getSimpleName()) {
            case "Integer[]":
                return Integer.class;
            case "Long[]":
                return Long.class;
            case "Short[]":
                return Short.class;
            case "Byte[]":
                return Byte.class;
            case "Float[]":
                return Float.class;
            case "Double[]":
                return Double.class;
        }
        return clazz;
    }
}


