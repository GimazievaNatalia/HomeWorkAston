package lesson_5;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();

        Cat cat = new Cat("Барсик", false, 8);

        dog.run(200);
        dog.swim(30);
        cat.run(1000);
        cat.swim(100);
        cat.eatBoul();
        cat.addFood();
        cat.eatFromBowlarraycat();
        System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Количество созданных котов: " + Cat.getTotalCats());
        System.out.println("Количество созданных собак: " + Dog.getTotalDogs());
    }

}

