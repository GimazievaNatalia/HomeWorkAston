package lesson_9;

import java.util.stream.Stream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt()).limit(10);

                .filter(number -> number % 2 == 0)
                // Печатаем четные числа (для примера)
                .forEach(System.out::println);

        // Определяем количество четных чисел
        int count = Math.toIntExact(randomNumbers.limit(10)
                .filter(number -> number % 2 == 0)
                .count());

        // Выводим результат
        System.out.println("Количество четных чисел: " + count);

    }
}