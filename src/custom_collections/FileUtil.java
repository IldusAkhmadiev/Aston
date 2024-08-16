package custom_collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.IntStream;

public class FileUtil {
    static Random random = new Random();
    static File file;

    public static void createFile(String fileName,int totalLines) {
        try  {
            Path tempFile = Files.createTempFile(fileName, ".txt");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < totalLines; i++) {
                sb.append(random.nextInt()).append("\n");
            }
            Files.write(tempFile, sb.toString().getBytes());
            file = tempFile.toFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static Integer[] getArray() {
        int[] numbersArray = null;
        try {
            numbersArray = Files.lines(file.toPath())
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            return IntStream.of(numbersArray).boxed().toArray(Integer[]::new);
        }
    }

    public static void deleteFile() {
        file.delete();
    }
}
