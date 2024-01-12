package lesson_5;

public class Cat extends Animal {

    private static int totalCats = 0;
    private String name;
    private boolean fullnes = false;//сытость кота, изначально кот голодный
    private int howMuchCatEat;//сколько ест кот

    public int getHowMuchCatEat() {
        return howMuchCatEat;
    }

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
        int bowl2 = bowl.getBowlFood() - howMuchCatEat;
        bowl.setBowlFood(bowl2);
        System.out.println((bowl2 >= 0) ? fullnes : (name + " остался голодным"));
    }

    public void eatFromBowlarraycat(Bowl bowl, Cat[] catArray) { //массив котов кушает
        int bowl2 = bowl.getBowlFood();
        for (Cat cat : catArray) {
            bowl2 -= cat.howMuchCatEat;
            System.out.println(bowl2 > 0 ? (cat.name + " поел из миски") : (cat.name + " остался голодный"));
        }
    }

}
