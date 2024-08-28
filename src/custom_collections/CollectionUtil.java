package custom_collections;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CollectionUtil {
    /**
     * Если последний элемент не null значит коллекция не полная
     */
    public static  <T extends Number> boolean isFull(T[] t) {
        return t[t.length - 1 ] == null ? false : true;
    }

    public static NumericArrayList[] getNumericLists(int count,Class clazz) {
        NumericArrayList[] lists = new NumericArrayList[count];
        for (int i = 0; i < count; i++) {
            lists[i] = new NumericArrayList(clazz);
        }
        return lists;
    }

}

