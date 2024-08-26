package custom_collections;

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
        list1.sortThread();
        long endTime = System.nanoTime();
        NumericArrayList<Integer> list2 = new NumericArrayList<>(array);
        System.out.println("Мультипотоковая сортировка: " + ( (endTime - startTime) / 1_000_000) + " ms");

        startTime = System.nanoTime();
        NumericArrayList.sort(list2);
        endTime = System.nanoTime();
        System.out.println("Обычная сортировка : " + ( (endTime - startTime) / 1_000_000) + " ms");
        FileUtil.deleteFile();

    }
}

