package lesson_5;

public class Rectangle extends Figures implements Calculabe {
    private int sideA;
    private int sideB;

    public Rectangle(String colorFill, String colorBoulder, int sideA, int sideB) {
        super(colorFill, colorBoulder);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void getPerimetr() {
        System.out.println("Периметр прямоугольника " + (2 * (sideA + sideB)));
    }

    @Override
    public void getArea() {
        System.out.println("Площадь прямоугольника " + (sideB * sideA));
    }

    @Override
    public void outputColor() {
        System.out.println("Цвет заливки прямоугольника " + colorFill);
        System.out.println("Цвет границы прямоугольника " + colorBoulder);
    }
}
