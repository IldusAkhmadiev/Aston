package custom_collections;

import java.util.ArrayList;
import java.util.Objects;

public class NumericArrayList<T extends Number> implements CRUDCollection<T> {

    private int size = 10;
    private T[] data;
    private int multiplier = 2;

    public NumericArrayList(T[] data) {
        this.data = data;
        this.size = data.length;
    }

    @Override
    public void add(T o) {
        if (CollectionUtil.isFull(data)) {
            T[] newData = (T[]) new Object[data.length * multiplier];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        } else {
            data[size] = o;
            size++;
        }


    }

    @Override
    public void remove(T o) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    public int getSize() {
        return size;
    }
}
