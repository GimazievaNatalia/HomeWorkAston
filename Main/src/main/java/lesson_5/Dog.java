package lesson_5;

public class Dog extends Animal {
    private int countDog = 0;

    public void run(int distation) {
        System.out.println((distation <= 500) ? "Dog пробежал " + distation + "m" : "Dog столько не бегает");
        countDog++;
    }

    public void swim(int distation) {
        System.out.println((distation <= 10) ? "Dog проплыл " + distation + "m" : "Dog столько не плавает");
    }
}
