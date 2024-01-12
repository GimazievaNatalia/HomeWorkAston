package lesson_6;

import java.io.*;
import java.util.Scanner;

    public class AppData {
        private String[] header;
        private int[][] data;

        public AppData(String[] header, int[][] data) {
            this.header = header;
            this.data = data;
        }

        public String[] getHeader() {
            return header;
        }

        public int[][] getData() {
            return data;
        }

        File file = new File("F:/test.csv");

        public void save(String[] header, int[][] data) { //записываем в файл

            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            for (String line : header) { //записываем массив строк
                writer.print(line);
                writer.print(";");
            }
            writer.println();
            for (int[] range : data) {  // записываем многомерный массив чисел
                for (int number : range) {
                    writer.print(number);
                    writer.print(";");
                }
                writer.println();
            }
            writer.close();
        }

        public void reading(String[] header, int[][] data) {  //читаем из файла
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

