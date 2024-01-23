package lesson_7;

public class Array {
    public static void checkArray(String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        if (myArray.length != 4 || myArray[0].length != 4) {
            throw new MyArraySizeException("Не верный размер массива");
        }
        int sumMassiv = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                try {

                    int value = Integer.parseInt(myArray[i][j]);
                    sumMassiv += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        System.out.println("Сумма массива: " + sumMassiv);
    }
}








