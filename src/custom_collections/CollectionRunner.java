package custom_collections;

/**
 *         Самое крутое тут sortThread(50) который принимает количество потоков
 *         Для тестирования производительности используйте класс PerformanceTest
 *         FileUtil используется для создания массива из заданного количества чисел
 */
public class CollectionRunner {
    public static void main(String[] args) {

        PerformanceTest.main(args);


        // не сравнивайте производительность как ниже
        FileUtil.createFile("test",1_000_0);
        Integer[] array = FileUtil.getArray();
        NumericArrayList<Integer> list1 = new NumericArrayList<>(array);
        long startTime = System.nanoTime();
        NumericArrayList<Integer> list = list1.sortThread(50);
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
        for (int i = 0; i < list.getArray().length; i++) {
            System.out.println(list.get(i));
            if(i == 30) {
                break;
            }
        }
    }
}

