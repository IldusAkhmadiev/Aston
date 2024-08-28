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
    private Class<?> classType;

    public NumericArrayList(NumericArrayList<T> list) {
        this.currentSize = list.currentSize;
        this.data = (T[]) list.data;
        this.multiplier = list.multiplier;
    }


    public NumericArrayList(T[] data) {
        this.data = data;
        this.currentSize = data.length;
        if (data.length > 0) {

            this.classType = data.getClass();
        }
    }

    public NumericArrayList(Class<T> clazz) {
        clazz = CollectionUtil.deleteArray(clazz);
        this.data = (T[]) Array.newInstance(clazz, basicSize);
        this.classType = clazz;

    }

    public NumericArrayList(Collection<? extends T> c) {
        this.currentSize = c.size();
        if (currentSize > 0) {
            Class<?> clazz = c.iterator().next().getClass();
            this.classType = clazz;
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
        for (T t : c.getArray()) {
            if(index == newSize){
                break;
            }
            newData[index++] = t;
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
        this.classType = CollectionUtil.deleteArray(classType);
        T[] array = (T[]) java.lang.reflect.Array.newInstance(classType,currentSize);

        for (int i = 0; i < array.length; i++) {
            array[i] = data[i];
        }
        return array;

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

    public NumericArrayList<T> sortThread(int threadCount) {
        if(threadCount == 1 || threadCount == 0 || threadCount < 0) {
            threadCount = 2;
        }
        if(threadCount > this.currentSize) {
            threadCount = this.currentSize-1;
        }
        ExecutorService executor = Executors.newCachedThreadPool();
        // получает список листов которые в будущем будут заполнены каждым потоком
        NumericArrayList[] lists = CollectionUtil.getNumericLists(threadCount, classType);
        // создает диапозон для каждого потока
        Number[][] ranges =  CollectionUtil.getRanges(classType, threadCount);

        for (int i = 0; i < threadCount; i++) {
            int finalI = i; // idea трубет final для лямды.
            executor.submit(() -> {processRange(ranges[finalI],lists[finalI],data); NumericArrayList.sort(lists[finalI]);});
        }
        executor.shutdown();
        //ConcurrentModificationException
        //Поток может завершиться раньше и приступить к работе по объединению этот код исправляет это
        try {
            // Ожидание завершения всех задач
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NumericArrayList<T> list = lists[0];
        for (int i = 1; i < threadCount; i++) {
            list.addAll(lists[i]);
        }
        return list;
    }

    private void processRange(Number[] range, NumericArrayList<T> list,T[] source) {
        for (int i = 0; i < currentSize; i++) {
            if (source[i].doubleValue() > range[0].doubleValue() && source[i].doubleValue() <= range[1].doubleValue()) {
                list.add(source[i]);
            }
        }

    }

}


