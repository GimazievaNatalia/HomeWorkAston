package lesson_5;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Bowl bowl = new Bowl();

        Cat cat = new Cat("Барсик", false, 8);



        Circle circle = new Circle("желтый", "голубой", 5);
        Triangle triangle = new Triangle("белый", "розовый", 1, 2, 3, 4);
        Rectangle rectangle = new Rectangle("черный", "красный", 2, 3);

        dog.run(200);
        dog.swim(30);
        cat.run(1000);
        cat.swim(100);
        cat.eatBowl(bowl);
        bowl.addFood(cat);
        cat.eatFromBowlarraycat(bowl);
        System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Количество созданных котов: " + Cat.getTotalCats());
        System.out.println("Количество созданных собак: " + Dog.getTotalDogs());


        circle.getPerimetr();
        circle.getArea();
        circle.outputColor();
        rectangle.getArea();
        rectangle.getPerimetr();
        rectangle.outputColor();
        triangle.getArea();
        triangle.getPerimetr();
        triangle.outputColor();

    }
}

