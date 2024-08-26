package custom_collections;

import java.lang.reflect.Array;
import java.util.*;

public class NumericArrayList<T extends Number & Comparable<T>> implements CRUDCollection<T> {

    private int currentSize;
    private int basicSize = 10;
    private T[] data;
    private int multiplier = 2;
    private String classType;

    public NumericArrayList(T[] data) {
        this.data = data;
        this.currentSize = data.length;
        if (data.length > 0) {
            Class<?> clazz = data.getClass();
            this.classType = clazz.getSimpleName();
        }
    }

    public NumericArrayList(Class<T> clazz) {
        this.data = (T[]) Array.newInstance(clazz, basicSize);
        this.classType = clazz.getSimpleName();

    }

    public NumericArrayList(Collection<? extends T> c) {
        this.currentSize = c.size();
        if (currentSize > 0) {
            Class<?> clazz = c.iterator().next().getClass();
            this.classType = clazz.getSimpleName();
            this.data = (T[]) Array.newInstance(clazz, currentSize);
            int i = 0;
            for (T element : c) {
                this.data[i++] = element;
            }
        } else {
            this.data = (T[]) new Number[basicSize];
        }
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
            if (data[i] == null) {
                T[] newData = (T[]) new Number[currentSize];
                System.arraycopy(data, 0, newData, 0, newData.length);
                System.arraycopy(data, i + 1, newData, i, newData.length - 1);
                data = newData;
            }
        }
    }

    /**
     * Возвращает по индексу если индекс выходит за пределы массива возвращает последний элемент
     * Если передать отрицательное число то вернет 1 элемент
     */
    @Override
    public T get(int index) {
        if (index < 0) {
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

    public static void sort(NumericArrayList list) {
        boolean wasSwap = true;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < list.size() - 1; i++) { // последний элемент мы будем сравнивать поэтому по нему не итерируемся
                if (list.data[i].doubleValue() > list.data[i + 1].doubleValue()) {
                    Number datum = list.data[i];
                    list.data[i] = list.data[i + 1];
                    list.data[i + 1] = datum;
                    wasSwap = true;
                }
            }

        }
    }

    public T[] getArray() {
        return data;
    }

    public Optional<T> max(boolean useThreads) {
        if (useThreads) {
            Optional<T> max = Arrays.stream(data).parallel().max(Comparator.naturalOrder());
            return max;
        } else {
            Optional<T> max = Arrays.stream(data).max(Comparator.naturalOrder());
            return max;
        }

    }

    public Optional<T> min(boolean useThreads) {
        if (useThreads) {
            Optional<T> min = Arrays.stream(data).parallel().min(Comparator.naturalOrder());
            return min;
        } else {
            Optional<T> min = Arrays.stream(data).min(Comparator.naturalOrder());
            return min;
        }

    }

}


