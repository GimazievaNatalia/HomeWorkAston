package lesson_9;

import java.util.Arrays;
import java.util.List;

public class Part2 {
    static List<String> listHigh = Arrays.asList(new String[]{"Highload", "High", "Load", "Highload"});

    public static void getHighCollection() {
        System.out.println(listHigh.stream().filter("High"::equals).findAny().orElse("High"));//вывести High
    }

    public static void getFistElementCollection() {
        System.out.println(listHigh.stream().findAny().orElse("0"));//первый элемент коллекции или ноль
    }

    public static void getLastElementCollection() {
        System.out.println(listHigh.stream().skip(3).findFirst().orElse("0")); //последний элемент или ноль

    }
}

