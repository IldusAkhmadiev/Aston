package custom_collections;

import java.util.Arrays;

public class CollectionRunner {
    public static void main(String[] args) {
        // Для тестирования производительности используйте класс PerformanceTest
        // FileUtil используется для создания массива из заданного количества чисел
        // для быстрого изменения можно использовать ctrl shift r и менять название функции
        PerformanceTest.main(args);
        // не сравнивайте производительность как ниже

        FileUtil.createFile("test",1_000_0);
        Integer[] array = FileUtil.getArray();
        NumericArrayList<Integer> list1 = new NumericArrayList<>(array);
        long startTime = System.nanoTime();
        list1.sortPositiveThread();
        long endTime = System.nanoTime();
        NumericArrayList<Integer> list2 = new NumericArrayList<>(array);
        System.out.println("Мультипотоковая сортировка: " + ( (endTime - startTime) / 1_000_000) +  " миллисекунд");

        startTime = System.nanoTime();
        NumericArrayList.sort(list2);
        endTime = System.nanoTime();
        System.out.println("Обычная сортировка пузырьком : " + ( (endTime - startTime) / 1_000_000) +  " миллисекунд");
        FileUtil.deleteFile();


        Integer[] integers = {2, 3, 4, 44, 88, 55};
        NumericArrayList<Integer> list3 = new NumericArrayList<>(integers);
        NumericArrayList<Integer> list4 = list3.sortPositiveThread();
        Number[] numberArray = list4.getArray();
        Integer[] array1 = Arrays.stream(numberArray)
                .map(number -> (Integer)number)
                .toArray(Integer[]::new);
        for (Integer i : array1) {
            System.out.println(i);
        }
    }
}

