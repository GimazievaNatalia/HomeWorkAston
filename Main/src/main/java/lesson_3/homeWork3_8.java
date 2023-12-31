package lesson_3;

public class homeWork3_8 {
    public static void multiplyNumbersLessThanSix() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int number : numbers) {
            if (number < 6) {
                number = number * 6;
            }
            System.out.println(number);
        }
    }
}
