package lesson_5;

public class Bowl {
    private int bowlFood = 18; //миска с едой
    public int getBowlFood() {
        return bowlFood;
    }

       public void addFood(Cat cat) { //добавляем еду в миску
       int leftovers = bowlFood - cat.getHowMuchCatEat(); //остаток после еды
       System.out.println((leftovers >= 0) ? ("Миска с едой = " + (bowlFood + leftovers)) : "Миска с едой = " + (bowlFood += 10));
    }
}
