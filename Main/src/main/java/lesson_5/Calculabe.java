package lesson_5;

public interface Calculabe {
    default void getPerimetr() {
        System.out.println("Базовая реализация метода в интерфейсе");
    }
    void getArea();

    void outputColor();
}
