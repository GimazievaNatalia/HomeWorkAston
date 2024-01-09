package lesson_4;

public class Main {
    public static void main(String[] args) {
        // Создание массива сотрудников
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        personArray[1] = new Person("Loshkin Pavel", "Engineer", "pashalo@mail.ru", "89166154123", 30000, 32);
        personArray[2] = new Person("Koshkin Kir", "Director", "kirdir@mail.ru", "894551552365", 150000, 35);
        personArray[3] = new Person("Gorbunova Maria", "Booker", "prostomaria@mailbox.ru", "89157158169", 40000, 30);
        personArray[4] = new Person("Prohorov Stepan", "Engineer", "stepankaftan@mail.ru", "87456122365", 30000, 40);

        // Вывод информации о сотрудниках
        for (Person person : personArray) {
            Person.showPersoninformation();
        }

        Park park = new Park();
        Attraction attraction = park.new Attraction();
    }
}



