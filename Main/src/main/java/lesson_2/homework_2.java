package lesson_2;

public class homework_2 {

        public static void printThreeWords() {
            String[] words = {"Orange", "Banana", "Apple"};
            for (String word : words) {
                System.out.println(word);
            }
        }
        public static void checkSumSign() {
            int a = 1;
            int b = -1;
            System.out.println((a + b >= 0) ? "Сумма положительная": "Сумма отрицательная");
        }
        public static void printColor() {
            int value = 100;
            if (value > 100) {
                System.out.println("Зеленый");
            } else if (value <= 0) {
                System.out.println("Красный");
            } else {
                System.out.println("Желтый");
            }
        }
        public static void compareNumbers() {
            int a = 30;
            int b = 20;
            System.out.println((a >= b) ? "a >= b" : "a < b");
        }
}
