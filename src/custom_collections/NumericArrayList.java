package custom_collections;

import java.lang.reflect.Array;
import java.util.Collection;

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
    public void remove(int index) {
        data[index] = null;
        currentSize--;
        // 3 4 5 9 22 > 3 4 null 9 22
        for (int i = 0; i < currentSize; i++) {
            if(data[i] == null) {
                T[] newData = (T[]) new Number[currentSize];
                System.arraycopy(data, 0, newData, 0, newData.length);
                System.arraycopy(data, i + 1, newData, i, newData.length -1  );
                data = newData;
            }
        }
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

    @Override
    public void addAll(Collection<? extends T> c) {
          int newSize = currentSize + c.size();
          T[] newData = (T[]) new Number[newSize];
          System.arraycopy(data, 0, newData, 0, currentSize);
            int index = currentSize;
            for (T item : c) {
            newData[index++] = item;
            }

        this.data = newData;
        this.currentSize = newSize;
    }

    public int size() {
        return currentSize;
    }
}
