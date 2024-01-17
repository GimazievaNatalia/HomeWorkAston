package lesson_8;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();


        Fruit fruit1 = new Fruit("apple");
        Fruit fruit2 = new Fruit("banana");
        Fruit fruit3 = new Fruit("orange");
        Fruit fruit4 = new Fruit("grape");
        Fruit fruit5 = new Fruit("watermelon");
        Fruit fruit6 = new Fruit("strawberry");
        Fruit fruit7 = new Fruit("pear");
        Fruit fruit8 = new Fruit("kiwi");
        Fruit fruit9 = new Fruit("melon");
        Fruit fruit10 = new Fruit("cherry");
        Fruit fruit11 = new Fruit("orange");
        Fruit fruit12 = new Fruit("banana");

        list.add(fruit1);
        list.add(fruit2);
        list.add(fruit3);
        list.add(fruit4);
        list.add(fruit5);
        list.add(fruit6);
        list.add(fruit7);
        list.add(fruit8);
        list.add(fruit9);
        list.add(fruit10);
        list.add(fruit11);
        list.add(fruit12);

        Set<String> uniqueFruit = new LinkedHashSet<>();

        for (Fruit fruit : list) {
            uniqueFruit.add(fruit.getFruit());
        }

        System.out.println("Список уникальных слов:");
        for (String word : uniqueFruit) {
            System.out.println(word);
        }
        Map<String, Integer> fruitCountMap = new HashMap<>();
        System.out.println("Сколько раз встречается каждое слово:");
        for (Fruit fruit : list) {
            if (fruit.getFruit() != null) {
                Integer count = fruitCountMap.get(fruit.getFruit());
                if (count == null) {
                    count = 0;
                }
                fruitCountMap.put(fruit.getFruit(), ++count);
            }
        }
        for (Map.Entry<String, Integer> entry : fruitCountMap.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }
    }
}






