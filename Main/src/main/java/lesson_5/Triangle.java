package lesson_5;

public class Triangle extends Figures implements Calculabe {
    private int sideA;
    private int sideB;
    private int sideC;
    private int height;

    public Triangle(String colorFill, String colorBoulder, int sideA, int sideB, int sideC, int height) {
        super(colorFill, colorBoulder);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
    }

    @Override
    public void getPerimetr() {
        System.out.println("Периметр треугольника " + (sideA + sideB + sideC));
    }

    @Override
    public void getArea() {
        System.out.println("Площадь треугольника " + ((sideA * height) / 2));
    }

    @Override
    public void outputColor() {
        System.out.println("Цвет заливки треугольника " + colorFill);
        System.out.println("Цвет границы треугольника " + colorBoulder);
    }
}
