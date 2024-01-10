package lesson_5;

public class Circle extends Figures implements Calculabe {
    private double radius;

    public Circle(String colorFill, String colorBoulder, double radius) {
        super(colorFill, colorBoulder);
        this.radius = radius;
    }

    @Override
    public void getPerimetr() {
        System.out.println("Периметр круга " + (2 * Math.PI * radius));
    }

    @Override
    public void getArea() {
        System.out.println("Плащадь круга " + (Math.PI * radius * radius));

    }

    @Override
    public void outputColor() {
        System.out.println("Цвет заливки круга " + colorFill);
        System.out.println("Цвет границы круга " + colorBoulder);
    }
}
