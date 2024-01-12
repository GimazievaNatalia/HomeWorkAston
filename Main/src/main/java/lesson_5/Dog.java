package lesson_5;

public class Dog extends Animal {
    private static int totalDogs = 0;

    public Dog() {
        // При создании новой собаки увеличиваем счетчик собак
        totalDogs++;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }

    @Override
    public void run(int distation) {
        System.out.println((distation <= 500) ? "Dog пробежал " + distation + "m" : "Dog столько не бегает");
    }

    @Override
    public void swim(int distation) {
        System.out.println((distation <= 10) ? "Dog проплыл " + distation + "m" : "Dog столько не плавает");
    }
}
