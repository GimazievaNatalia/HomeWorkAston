package lesson_9;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.function.Predicate;


public class Login {
    public static void acceptingLogins() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> boxLogin = new ArrayList();
        System.out.println("Введите ваш логин");

        while (true) {
            String login = scanner.nextLine();

            if (login.equals("") == true)
                break;
            boxLogin.add(login);
        }
        Predicate<String> nameStartsWithS = str -> str.startsWith("f");
        boxLogin.stream().filter(nameStartsWithS).forEach(System.out::println);
    }
}

