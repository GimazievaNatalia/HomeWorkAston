package lesson_3;

import java.util.Arrays;

public class HomeWork3_10 {
    public static void arrayInitializer(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);

        for (int value : array) {
            System.out.print(value);
        }
    }
}
