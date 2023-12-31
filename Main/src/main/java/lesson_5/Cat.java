package lesson_5;

    public class Cat extends Animal {
        private int countCat = 0;
        int boulFood = 20; //миска с едой
        private String name;
        private boolean fullnes = false;//сытость кота, изначально кот голодный
        private int howMuchCatEat;//сколько ест кот

        public Cat(String name, boolean fullnes, int howMuchCatEat) {
            this.name = name;
            this.fullnes = fullnes;
            this.howMuchCatEat = howMuchCatEat;
        }

        public void run( int distation) {
            System.out.println((distation <= 200) ? (name + " пробежал " + distation + "m") : (name + " столько не бегает"));
        }
        public void swim( int distation) {
            if (distation > 0) {
                System.out.println(name + " не умеет плавать");
            }
        }
        public void eatBoul() {

            System.out.println((fullnes = boulFood - howMuchCatEat >= 0) ? fullnes: (name + " остался голодным"));
        }
        public void addFood() {
            int leftovers = boulFood - howMuchCatEat; //остаток после еды
            System.out.println((leftovers >= 0) ? ("Миска с едой = " + (boulFood+leftovers)) : "Миска с едой = " + (boulFood += 10));
        }

    }
}
