package lesson_5;

public class Main {
    public class Main {
        public static void main(String[] args) {
            Dog dog = new Dog();
            Cat cat = new Cat("Барсик", false, 8);
            //создание массива котов
            Cat[] catArray = new Cat[3];
            catArray[0] = new Cat("Рыжик", false, 22);
            catArray[1] = new Cat("Мурзик", false, 5);
            catArray[2] = new Cat("Зевс", false, 3);



            dog.run(200);
            dog.swim(30);
            cat.run(1000);
            cat.swim(100);
            for (Cat kote : catArray) {
                cat.eatBoul();
            }
            cat.eatBoul();
            cat.addFood();
        }

    }

}
