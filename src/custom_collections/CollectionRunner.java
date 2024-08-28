package custom_collections;

import java.lang.reflect.Array;

/**
 *         Самое крутое тут sortThread(50) который принимает количество потоков
 *         Для тестирования производительности используйте класс PerformanceTest
 *         FileUtil используется для создания массива из заданного количества чисел
 */
public class CollectionRunner {
    public static void main(String[] args) {

        Double[] doubles = {2.2, 3.4, 4D,2.5, 44d,2.3, 88d, 55d};
        NumericArrayList<Double> list5 = new NumericArrayList<>(doubles);
        NumericArrayList<Double> doubleNumericArrayList = list5.sortThread(10);
        for (Double d : doubleNumericArrayList.getArray()) {
            System.out.println(d);
        }


        PerformanceTest.main(args);


        // не сравнивайте производительность как ниже
        FileUtil.createFile("test",1_000_0);
        Integer[] array = FileUtil.getArray();
        NumericArrayList<Integer> list1 = new NumericArrayList<>(array);
        long startTime = System.nanoTime();
        NumericArrayList<Integer> list = list1.sortThread(10);
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
        NumericArrayList<Integer> list4 = list3.sortThread(10);
        for (Integer i : list4.getArray()) {
            System.out.println(i);
        }

        // проверка сортировки
        for (int i = 0; i < list.getArray().length; i++) {
            System.out.println(list.get(i));
            if(i == 10) {
                break;
            }
        }
    }
}

