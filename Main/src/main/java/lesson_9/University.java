package lesson_9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class University {

    public static void ReturnStudent(){
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Sex.MAN),
                new Student("Максим", 20, Sex.MAN),
                new Student("Екатерина", 20, Sex.WOMAN),
                new Student("Михаил", 28, Sex.MAN)
        );
        System.out.println(students.stream()
                .filter(stu -> stu.getGender() == Sex.MAN)
                .mapToInt(University.Student::getAge)
                .average());//средний возраст мужиков
        System.out.println(students.stream().filter(stud -> stud.getAge() < 27 && stud.getAge() > 18 && stud.getGender() == Sex.MAN).collect(Collectors.toList()));
    }
    private enum Sex {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Sex gender;


        public Student(String name, Integer age, Sex gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }



    }
}
