package lesson_4;

public class Person {

        private static String name;
        private static String position;
        private static String email;
        private static String phone;
        private static int salary;
        private static int age;

        public Person(String name, String position, String email, String phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;

        }

        public static void showPersoninformation() {
            System.out.println("ФИО: " + name + "; Должность: " + position + "; email: " + email +
                    "; Телефон: " + phone + "; Зарплата: " + salary + "; Возраст: " + age);
        }
}
