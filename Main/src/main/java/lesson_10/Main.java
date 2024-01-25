package lesson_10;

public class Main {
    public static void main(String[] array) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Apple> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();

        box1.addFruit(apple1);
        box2.addFruit(apple2);
        box3.addFruit(orange1);
        System.out.println("Вес коробки box1: " + box1.getWeight());
        System.out.println("Вес коробки box2: " + box2.getWeight());
        System.out.println("Вес коробки box3: " + box3.getWeight());
        System.out.println("Сравнение box1 и box2: " + box1.compare(box2));
        System.out.println("Сравнение box1 и box3: " + box1.compare(box3));
        box1.moveFriut(box2);

        System.out.println("Вес коробки box1 после пересыпания: " + box1.getWeight());
        System.out.println("Вес коробки box2 после пересыпания: " + box2.getWeight());
    }

}
