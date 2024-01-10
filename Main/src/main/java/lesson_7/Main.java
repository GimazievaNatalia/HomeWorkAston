package lesson_7;

public class Main {
    public static void main( String[] args ) {
        String[][] myArray = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            Array.getArray(myArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            throw new RuntimeException(e);
        }


    }
}
