package lesson_3;

public class HomeWork3_9 {
    public static void matrixDiagonalFiller() {
        int[][] numbers = new int[5][5];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    numbers[i][j] = 1;
                }
                int k = numbers.length - i - 1;
                numbers[i][k] = 1;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int k = 0; k < numbers.length; k++) {
                System.out.print(numbers[i][k] + " ");
            }
            System.out.println();
        }
    }
}
