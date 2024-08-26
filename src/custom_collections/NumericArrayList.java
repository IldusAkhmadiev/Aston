package custom_collections;

import java.util.Optional;

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
            T[] newData = (T[]) new Number[data.length * multiplier];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            data[size++] = o;
        } else {
            data[size] = o;
            size++;
        }


    }

    @Override
    public void remove(T o) {

    }

    /**
     * Возвращает по индексу если индекс выходит зза пределы массива возвращает последний элемент
     * Если передать отрицательное число то вернет 1 элемент
     */
    @Override
    public T get(int index) {
        if(index < 0) {
            return data[0];
        } else if (index >= size) {
            return data[size - 1];
        } else {
            return data[index];
        }



    }

    public int getSize() {
        return size;
    }
}
