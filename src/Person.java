import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compare(Person other) {
//        return Integer.compare(age, other.getAge());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // это один и тот же объект
        if (o == null || getClass() != o.getClass()) return false; // проверяем класс
        Person person = (Person) o; // приводим к нужному типу
        return age == person.age && name.equals(person.name); // сравниваем поля
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(age, o.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age); // чтобы работало с HashSet/HashMap
    }
}
