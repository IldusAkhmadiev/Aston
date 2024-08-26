package custom_collections;

import java.util.Collection;

public class CollectionUtil {
    /**
     * Если последний элемент не null значит коллекция не полная
     */
    public static  <T extends Number> boolean isFull(T[] t) {
        return t[t.length - 1 ] == null ? false : true;

    }
}

