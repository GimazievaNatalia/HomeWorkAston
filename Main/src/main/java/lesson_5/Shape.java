package lesson_5;

public interface Shape {
    default void getPerimetr() {
        System.out.println("Базовая реализация метода в интерфейсе");
    }
    void getArea();

    void outputColor();
}
