package lesson_5;

public class Bowl {
    private int bowlFood = 20; //миска с едой

    public int getBowlFood() {
        return bowlFood;
    }

    public void setBowlFood(int bowlFood) {
        this.bowlFood = bowlFood;
    }

    public void addFood(Cat cat) { //добавляем еду в миску
        int leftovers = bowlFood; //остаток после еды
        System.out.println((leftovers <= 0) ? "Миска с едой = " + (bowlFood = leftovers + 10) : ("Миска с едой = " + leftovers));
    }
}
