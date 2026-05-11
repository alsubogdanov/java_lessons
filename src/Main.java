import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void task0_1(){
        List<Integer> orders = List.of(120, 450, 90, 700, 300, 50);
        List<String> newList = orders.stream().filter(elem->elem>200).map(elem->"Order: $"+elem).collect(Collectors.toList());
        System.out.println(newList);
    }
    public static void task0_2(){
        List<String> emails = List.of(
                "Anna@gmail.com",
                "BORIS@yahoo.com",
                "alex@gmail.com",
                "anna@gmail.com",
                "test@mail.ru"
        );
        Set<String> res = emails.stream().filter(el->el.toLowerCase().endsWith("gmail.com")).map(String::toLowerCase).collect(Collectors.toSet());
        System.out.println(res);
    }
    public static void task0_3(){
    }
    public static void task0_4(){
    }
    public static void task0_5(){
        List<String> users = List.of(
                "Anna",
                "",
                "Boris",
                "   ",
                "Alex",
                "Ivan"
        );
        List<String> result = users.stream()
                .filter(u -> !u.trim().isEmpty())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }


    public static void task0_6(){
        List<Product> products = List.of(
                new Product("Waptop", 1200),
                new Product("Mouse", 25),
                new Product("Keyboard", 80),
                new Product("Phone", 900)
        );
        List<String> res = products.stream()
                .filter(el->el.price>100)
                .map(el->el.name)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(res);
    }
    public static void task0_7(){
        List<Employee> employees = List.of(
                new Employee("Anna", 22),
                new Employee("Boris", 17),
                new Employee("Alex", 30),
                new Employee("Kate", 16)
        );
        Set<String> res = employees.stream()
                .filter(el->el.age>18)
                .map(el->el.name+"("+el.age+")")
                .collect(Collectors.toSet());
        System.out.println(res);
    }
    public static void task0_10(){
        List<Account> accounts = List.of(
                new Account("Anna", 1500),
                new Account("Boris", -200),
                new Account("Ivan", 3000),
                new Account("Kate", -50)
        );
        List<String> res = accounts.stream()
                .filter(el->el.balance<0)
                .map(el->el.owner)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(res);
    }
    public static void task0_11(){
        List<Student> students = List.of(
                new Student("Anna", 90),
                new Student("Boris", 75),
                new Student("Alex", 75),
                new Student("Ivan", 30)
        );
        List<Student> res = students.stream()
                .filter(el->el.score>=60)
//                .sorted((a,b)->b.name.compareTo(a.name)) //Comparator
                .sorted() // Comparable
                .collect(Collectors.toList());
        System.out.println(res);
    }
    public static void task0_1032(){
    }


    public static void main(String[] args) {
//        task0_1();
//        task0_2();
//        task0_3();
//        task0_4();
        task0_11();


    }
}
