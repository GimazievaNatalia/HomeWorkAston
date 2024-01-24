package lesson_7;

public class Main {
    public static void main(String[] args) {
        String[][] arrayNumber = new String[][]{{"1", "2", "3", "7"}, {"5", "6", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            Array.checkArray(arrayNumber);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            throw new RuntimeException(e);
        }


    }
}
