package lesson_5;

public class Cat extends Animal {

    private static int totalCats = 0;
    //  int boulFood = 18; //миска с едой
    private String name;
    private boolean fullnes = false;//сытость кота, изначально кот голодный
    private int howMuchCatEat;//сколько ест кот

    public int getHowMuchCatEat() {
        return howMuchCatEat;
    }


    //создание массива котов
    private static Cat[] catArray = {
            new Cat("Рыжик", false, 10),
            new Cat("Мурзик", false, 5),
            new Cat("Зевс", false, 3)
    };

    public Cat(String name, boolean fullnes, int howMuchCatEat) {
        this.name = name;
        this.fullnes = fullnes;
        this.howMuchCatEat = howMuchCatEat;
        totalCats++;

    }

    public static int getTotalCats() {
        return totalCats;
    }

    @Override
    public void run(int distation) {
        System.out.println((distation <= 200) ? (name + " пробежал " + distation + "m") : (name + " столько не бегает"));
    }

    @Override
    public void swim(int distation) {
            System.out.println(name + " не умеет плавать");
    }

    public void eatBowl(Bowl bowl) { //кормим одинокого кота
        System.out.println((fullnes = bowl.getBowlFood() - howMuchCatEat >= 0) ? fullnes : (name + " остался голодным"));
    }

    //public void addFood() { //добавляем еду в миску
    //int leftovers = boulFood - howMuchCatEat; //остаток после еды
    // System.out.println((leftovers >= 0) ? ("Миска с едой = " + (boulFood + leftovers)) : "Миска с едой = " + (boulFood += 10));
    // }

    public void eatFromBowlarraycat(Bowl bowl) { //массив котов кушает
        int bowl2 = bowl.getBowlFood();
        for (Cat cat : catArray) {
            bowl2 -= howMuchCatEat;
            System.out.println(bowl.getBowlFood() >= 0 ? (cat.name + " поел из миски") : (cat.name + " остался голодный"));
        }
    }
}
