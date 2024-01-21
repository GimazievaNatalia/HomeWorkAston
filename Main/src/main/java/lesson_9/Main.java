package lesson_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        IntStream randomNumbers = random.ints().limit(10)
        .filter(number -> number % 2 == 0);
        randomNumbers.forEach(System.out::println);
    }
}




               //
                // Печатаем четные числа (для примера)
               // .forEach(System.out::);

        // Определяем количество четных чисел
       // int count = Math.toIntExact(randomNumbers.limit(10)
               // .filter(number -> number % 2 == 0)
               // .count());

        // Выводим результат
      //  System.out.println("Количество четных чисел: " + count);

