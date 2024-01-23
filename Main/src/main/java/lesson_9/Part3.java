package lesson_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Part3 {
    public static void sortCollection() {
        List<String> listF = new ArrayList<>();
        listF.add("f10");
        listF.add("f15");
        listF.add("f2");
        listF.add("f4");
        listF.add("f4");
        System.out.println(listF.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .collect(Collectors.toList()));
    }
}
