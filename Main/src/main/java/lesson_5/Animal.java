package lesson_5;

public class Animal {
    private static int totalAnimals = 0;

    public Animal() {
        // При создании нового животного увеличиваем счетчик
        totalAnimals++;
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public void run(int distantion) {

    }

    public void swim(int distation) {

    }

}

