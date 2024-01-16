package lesson_6;

import java.io.*;
import java.util.Scanner;

public class AppData {
    private String[] header;
    private int[][] data;
    private File file;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
        this.file = null;
    }


       public void save() throws IOException { //записываем в файл
        PrintWriter writer = null;

           String relativePath = "Main/src/main/resources/testtest.csv";
           this.file = new File(relativePath);

           File parentDir = file.getParentFile();
           if (!parentDir.exists() && !parentDir.mkdirs()) {
               throw new IOException("Failed to create directory: " + parentDir);
           }

           // Создаем файл по относительному пути, если он не существует
           if (file.createNewFile()) {
               System.out.println("File created successfully at path: " + file.getAbsolutePath());
           } else {
               System.out.println("File already exists at path: " + file.getAbsolutePath());
           }

        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (String line : this.header) { //записываем массив строк
            writer.print(line);
            writer.print(";");
        }
        writer.println();
        for (int[] range : this.data) {  // записываем многомерный массив чисел
            for (int number : range) {
                writer.print(number);
                writer.print(";");
            }
            writer.println();
        }
        writer.close();
    }

    public void reading() { // читаем из файла
        if (file == null) {
            throw new RuntimeException("File is not yet created or saved.");
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
