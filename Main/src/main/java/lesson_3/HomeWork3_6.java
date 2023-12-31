package lesson_3;

public class HomeWork3_6 {
    public static void replacementNumber() {
        int[] numbers = {1, 1, 1, 0, 0, 1, 0, 0, 0, 1};
        for (int number : numbers) {
            if (number == 0) {
                number = 1;
            } else {
                number = 0;
            }
            System.out.println(number);
        }
    }
}
