package lesson_8;


import java.util.*;

public class Fruit {

    private ArrayList<String> fruit;

    public Fruit() {
        this.fruit = new ArrayList<>();
    }


    public void add(String string) {
        fruit.add(string);
    }

    public void getUniqueFruit() {
        Set<String> uniqueFruit = new LinkedHashSet<>();
        for (String f : fruit) {
            uniqueFruit.add(f);
        }

        System.out.println("Список уникальных слов:");
        for (String word : uniqueFruit) {
            System.out.println(word);
        }
    }

    public void getCountFruit() {
        Map<String, Integer> fruitCountMap = new HashMap<>();
        System.out.println("Сколько раз встречается каждое слово:");
        for (String f : fruit) {
            if (f != null) {
                Integer count = fruitCountMap.get(f);
                if (count == null) {
                    count = 0;
                }
                fruitCountMap.put(f, ++count);
            }
        }
        for (Map.Entry<String, Integer> o : fruitCountMap.entrySet()) {
            System.out.println(o.getKey() + " :" + o.getValue());
        }
    }
}



