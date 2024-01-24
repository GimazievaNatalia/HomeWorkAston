package lesson_7;

public class Array {
    public static void checkArray(String[][] arrayNumber) throws MyArraySizeException, MyArrayDataException {
        int rows = arrayNumber.length;
        int cols = arrayNumber[0].length;

        if (rows != 4 || cols != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        int sumMassiv = 0;
        for (int i = 0; i < rows; i++) {
            if (arrayNumber[i].length != cols) {
                throw new MyArraySizeException("Неверный размер строки массива");
            }

            for (int j = 0; j < cols; j++) {
                try {
                    int value = Integer.parseInt(arrayNumber[i][j]);
                    sumMassiv += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("Сумма массива: " + sumMassiv);
    }
}





