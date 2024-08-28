package custom_collections;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NumericArrayList<T extends Number & Comparable<T>> implements CRUDCollection<T>{

    private int currentSize;
    private int basicSize = 10;
    private T[] data;
    private int multiplier = 2;

    public NumericArrayList(NumericArrayList<T> list) {
        this.currentSize = list.currentSize;
        this.data = (T[]) list.data;
        this.multiplier = list.multiplier;
    }

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


    public void addAll(NumericArrayList<T> c) {
        if(c.size() == 0) {
            return;
        }
        int newSize = currentSize + c.size();
        T[] newData = (T[]) new Number[newSize];
        System.arraycopy(data, 0, newData, 0, currentSize);
        int index = currentSize;
        for (T item : c.getArray()) {
            if(index == newSize){
                break;
            }
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
        return (T[]) data;
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

    // пока работает только с Integer
    // да пока он работает только с Integer и не разделяет минусовые значения .
    // то есть после сортировки пока что у вас пропадут все числа которые имеют отрицательное значение
    public NumericArrayList<T> sortPositiveThread() {
        ExecutorService executor = Executors.newCachedThreadPool();

        NumericArrayList<T> integers1 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers2 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers3 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers4 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers5 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers6 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers7 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers8 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers9 = new NumericArrayList(Integer.class);
        NumericArrayList<T> integers10 = new NumericArrayList(Integer.class);

        int[][] ranges = {
                {0, 9},
                {10, 99},
                {100, 999},
                {1000, 9999},
                {10000, 99999},
                {100000, 999999},
                {1000000, 9999999},
                {10000000, 99999999},
                {100000000, 999999999},
                {1000000000, 2_147_483_647}
        };

        // Передача задачи в потоки
        executor.submit(() -> { processRange(ranges[0], integers1,data);
        integers1.sort(integers1);});

        executor.submit(() -> { processRange(ranges[1], integers2,data);
            integers2.sort(integers2);});

        executor.submit(() -> { processRange(ranges[2], integers3,data);
            integers3.sort(integers3);});

        executor.submit(() -> { processRange(ranges[3], integers4,data);
            integers4.sort(integers4);});

        executor.submit(() -> { processRange(ranges[4], integers5,data);
            integers5.sort(integers5);});

        executor.submit(() -> { processRange(ranges[5], integers6,data);
            integers6.sort(integers6);});

        executor.submit(() -> { processRange(ranges[6], integers7,data);
            integers7.sort(integers7);});

        executor.submit(() -> { processRange(ranges[7], integers8,data);
            integers8.sort(integers8);});

        executor.submit(() -> { processRange(ranges[8], integers9,data);
            integers9.sort(integers9);});

        executor.submit(() -> { processRange(ranges[9], integers10,data);
            integers10.sort(integers10);});
        executor.shutdown();
        //ConcurrentModificationException
        //Поток может завершиться раньше и приступить к работе по объединению этот код исправляет это
        try {
            // Ожидание завершения всех задач
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NumericArrayList list = integers1;
        list.addAll(integers2);
        list.addAll(integers3);
        list.addAll(integers4);
        list.addAll(integers5);
        list.addAll(integers6);
        list.addAll(integers7);
        list.addAll(integers8);
        list.addAll(integers9);
        list.addAll(integers10);
        return list;
    }

    private void processRange(int[] range, NumericArrayList<T> list,T[] source) {
        for (int i = 0; i < currentSize; i++) {
            if(source[i].intValue() > range[0] && source[i].intValue() <= range[1]) {
                list.add(source[i]);
            }
        }

    }

}


