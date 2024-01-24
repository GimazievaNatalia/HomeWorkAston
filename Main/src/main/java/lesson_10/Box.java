package lesson_10;

import java.util.ArrayList;

    class Box<T extends Fruit> {
        private ArrayList<T> fruits;

        public Box() {
            this.fruits = fruits;
        }
        //Добавление фрукта
        public void addFruit(T fruit){
            fruits.add(fruit);
        }
        //Вычисление веса коробки
        public void getVolueBox(){
           fruits.stream().mapToDouble(Fruit::getWeight).sum();
        }
    }

