package lesson_9;

import java.util.Random;
import java.util.stream.IntStream;

public class Part1 { //определяем количество четных чисел в случайном наборе
    public static void getQuantityNumbersEvenRandomSet() {
        Random random = new Random();
        IntStream randomNumbers = random.ints().limit(50)
                .filter(number -> number % 2 == 0);
        randomNumbers.forEach(System.out::println);
    }

}
