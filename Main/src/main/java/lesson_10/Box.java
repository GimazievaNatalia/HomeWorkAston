package lesson_10;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> box = new ArrayList<T>();

    public Box() {
        this.box = box;
    }

    public List<T> getBox() {
        return box;
    }

    public void setBox(List<T> box) {
        this.box = box;
    }

    //Добавление фрукта
    public void addFruit(T fruit) {
        System.out.println("Фрукт в коробке " + this.box.add(fruit));
    }

    //Вычисление веса коробки
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : box) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    //Сравнение коробок
    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    //Переложить фрукты
    public void moveFriut(Box<T> otherBox) {
        if (this == otherBox) {
            System.out.println("Нельзя пересыпать в ту же самую коробку");
        }
        if ((box.get(0) instanceof Apple) && (otherBox.box.get(0) instanceof Orange)) {
            System.out.println("Нельзя пересыпать фрукты разных типов");
        }
        otherBox.box.addAll(this.box);
        this.box.clear();
    }

}

