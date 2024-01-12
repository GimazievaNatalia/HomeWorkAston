package lesson_6;

public class Main {
    public static void main(String args[]) {
        String[] header = {"value1", "value2", "value3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        AppData appData = new AppData(header, data);
        appData.save(header, data);
        appData.reading();
    }
}

