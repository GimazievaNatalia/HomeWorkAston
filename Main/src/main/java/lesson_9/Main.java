package lesson_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.Collection;
import java.util.*;

public class Main {
    //определяем количество четных чисел в случайном наборе
    public static void main(String[] args) {
        Random random = new Random();
        IntStream randomNumbers = random.ints().limit(10)
        .filter(number -> number % 2 == 0);
        randomNumbers.forEach(System.out::println);

        //2-ое
        List<String> listHigh = new ArrayList<>();

        listHigh.addAll(Arrays.asList(new String[]{"Highload", "High", "Load", "Highload"}));

        System.out.println(listHigh.stream().filter("High"::equals).findAny().orElse("High"));//вывести High
        System.out.println(listHigh.stream().findAny().orElse("0"));//первый элемент коллекции или ноль
        System.out.println(listHigh.stream().skip(3).findFirst().orElse("0")); //последний элемент или ноль

        //3
        List<String> listF = new ArrayList<>();
        listF.add("f10");
        listF.add("f15");
        listF.add("f2");
        listF.add("f4");
        listF.add("f4");
        System.out.println(listF.stream().sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1)))).collect(Collectors.toList()));

        //4
       University.ReturnStudent();











    }

}



