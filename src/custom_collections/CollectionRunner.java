package custom_collections;

import java.util.ArrayList;

public class CollectionRunner {
    public static void main(String[] args) {
        new ArrayList<>();
        Integer[] integers = new Integer[10];
        integers[0] = 1;
        integers[1] = 2;
        System.out.println(integers[integers.length - 3]);
    }
}
