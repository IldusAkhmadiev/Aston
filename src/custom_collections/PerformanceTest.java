package custom_collections;

import custom_collections.FileUtil;
import custom_collections.NumericArrayList;

import java.util.Optional;

public class PerformanceTest {
    private static int iterCountJVM = 10;
    // показывает сколько раз выполнить тест
    private static int testIterCount = 10;

    public static void main(String[] args) {
        // мой комп не смог выдержать больше 30 млн цифр . 8 гб оперативка
        FileUtil.createFile("temp", 10000000);
        Integer[] arrays = FileUtil.getArray();
        NumericArrayList<Integer> list = new NumericArrayList<>(arrays);

        // чтобы JVM мог оптимизировать запрос.
        for (int i = 0; i < iterCountJVM; i++) {
            list.max(true);
            list.max(false);
        }

        long totalTimeWith = 0;
        long totalTimeWithout = 0;

        // проводим сразу несколько тестов
        for (int i = 0; i < testIterCount; i++) {
            System.gc();

            long startTime = System.nanoTime();
            Optional<Integer> max = list.max(true);
            long endTime = System.nanoTime();
            totalTimeWith += (endTime - startTime);

            System.gc();


            startTime = System.nanoTime();
            Optional<Integer> maxNo = list.max(false);
            endTime = System.nanoTime();
            totalTimeWithout += (endTime - startTime);

        }
        // это не магическое число
        // 1 млн наносекунд  = 1 миллисекнда
        // 1000 миллисекунд  = 1 секунда
        double avgTimeWithStreams = totalTimeWith / (double) testIterCount / 1_000_000.0;
        double avgTimeWithoutStreams = totalTimeWithout / (double) testIterCount / 1_000_000.0;

        System.out.println("Время выполнения с многопоточностью " + avgTimeWithStreams);
        System.out.println("Время выполнения без многопоточности " + avgTimeWithoutStreams);
        System.out.println("Максимальное число с многопоточностью " + list.max(true).get());
        System.out.println("Максимальное число без многопоточности " + list.max(false).get());

        FileUtil.deleteFile();
    }


}