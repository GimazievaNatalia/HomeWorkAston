package lesson_7;

public class Array {
    public static void getArray (String[][] myArray) throws MyArraySizeException, MyArrayDataException {
        if(myArray.length != 4 || myArray[0].length != 4) {
            throw new MyArraySizeException("Не верный размер массива");
        }
        int [][] newArray = new int[4][4];
        int sumMassiv = 0;
        for (String[] i : myArray) {
            for (String[] j : myArray) {
                newArray[i][j] = Integer.parseInt(myArray[i][j]);
                sumMassiv += newArray[i][j];
                System.out.println(sumMassiv);
                if ((i instanceof String) && (j instanceof String)) {

                }
                throw new MyArrayDataException("Не верный тип элемента");
            }


            }
        }
    }

}


