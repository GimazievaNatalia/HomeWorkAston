package lesson_3;

public class HomeWork3_5 {
    public static void isLeapYear(int year) {
        boolean isLeap = true;
        System.out.println(((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) ? isLeap : false);

    }
}
