package lesson_5;

public class Main {
    static Bowl bowl = new Bowl();

    public static void eatFromBowlarraycat() { //массив котов кушает
        Cat[] catArray = new Cat[3];
        catArray[0] = new Cat("Рыжик", false, 10);
        catArray[1] = new Cat("Мурзик", false, 5);
        catArray[2] = new Cat("Зевс", false, 3);
        int bowl2 = bowl.getBowlFood();
        for (Cat cat1 : catArray) {
            bowl2 -= cat1.getHowMuchCatEat();
            System.out.println(bowl.getBowlFood() >= 0 ? (cat1.getName() + " поел из миски") : (cat1.getName() + " остался голодный"));
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
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
        System.out.println("Общее количество животных: " + Animal.getTotalAnimals());
        System.out.println("Количество созданных котов: " + Cat.getTotalCats());
        System.out.println("Количество созданных собак: " + Dog.getTotalDogs());
        eatFromBowlarraycat();

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

