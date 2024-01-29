package lesson_12_junit_5;

public class Factorial {
    public static long getFactorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не существует");
        }
        if (n == 0) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
