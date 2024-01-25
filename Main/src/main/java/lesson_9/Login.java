package lesson_9;

import java.util.Scanner;
import java.util.ArrayList;

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
        boxLogin.stream().filter(str -> str.startsWith("f")).forEach(System.out::println);
        scanner.close();
    }

}

