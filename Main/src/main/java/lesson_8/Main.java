package lesson_8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        PhoneBook phoneBook = new PhoneBook();

        fruit.add("apple");
        fruit.add("banana");
        fruit.add("orange");
        fruit.add("grape");
        fruit.add("watermelon");
        fruit.add("strawberry");
        fruit.add("pear");
        fruit.add("kiwi");
        fruit.add("melon");
        fruit.add("cherry");
        fruit.add("orange");
        fruit.add("banana");
        fruit.getUniqueFruit();
        fruit.getCountFruit();


        phoneBook.add("Петров", "89199151537");
        phoneBook.add("Коротков", "89199121266");
        phoneBook.add("Иванов", "89185624545");
        phoneBook.add("Петров", "89457815256");
        phoneBook.add("Лазарев", "87512201266");
        System.out.println("Номера телефона для Иванова: " + phoneBook.get("Иванов"));
        System.out.println("Номера телефона для Петрова: " + phoneBook.get("Петров"));

    }
}






