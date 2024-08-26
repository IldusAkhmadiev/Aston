package custom_collections;

import java.lang.reflect.Array;
import java.util.Optional;

public class NumericArrayList<T extends Number> implements CRUDCollection<T> {

    private int currentSize;
    private int basicSize = 10;
    private T[] data;
    private int multiplier = 2;

    public NumericArrayList(T[] data) {
        this.data = data;
        this.currentSize = data.length;
    }

    public NumericArrayList(Class<T> clazz  ) {
        this.data = (T[]) Array.newInstance(clazz, basicSize);

    }

    @Override
    public void add(T o) {
        if (CollectionUtil.isFull(data)) {
            T[] newData = (T[]) new Number[data.length * multiplier];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            data[currentSize++] = o;
        } else {
            data[currentSize] = o;
            currentSize++;
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
        } else if (index >= currentSize) {
            return data[currentSize - 1];
        } else {
            return data[index];
        }



    }

    public int getSize() {
        return currentSize;
    }
}
