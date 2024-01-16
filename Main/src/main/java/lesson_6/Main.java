package lesson_6;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        String[] header = {"value1", "value2", "value3"};
        int[][] data = {{100, 200, 123}, {300, 400, 600}};
        AppData appData = new AppData(header, data);
        appData.save();
        appData.reading();
    }
}

