package org.example.gimazieva;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public static void save(AppData appData){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("F:/data.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter BufferedWriter = new BufferedWriter(osw);
        

    }

}