import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void task0_1(){
        List<String> names = List.of("Anna", "Boris", "Alex", "Ivan", "Kate");
        List<String> res = names.stream()
                .limit(3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    public static void task0_2(){
        List<String> emails = List.of(
                "a@mail.com",
                "b@mail.com",
                "a@mail.com",
                "c@mail.com",
                "b@mail.com"
        );
        List<String> res = emails.stream()
                .distinct()
                .limit(2)
                .collect(Collectors.toList());
    }
    public static void task0_3(){
        List<Integer> scores = List.of(50, 90, 70, 100, 90, 60);
        List<Integer> res = scores.stream()
                .distinct()
                .sorted((a,b)->b-a)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(res);
    }
    public static void task0_4(){
        List<Product> products = List.of(
                new Product("Phone", 900),
                new Product("Laptop", 1500),
                new Product("Mouse", 30),
                new Product("Keyboard", 80),
                new Product("Monitor", 300)
        );
        List<String> res = products.stream()
                .filter(el->el.price>100)
                .sorted((a,b)->b.price-a.price)
                .limit(2)
                .map(el->el.name)
                .collect(Collectors.toList());
    }
    public static void task0_5(){
    }
    public static void task0_6(){
    }
    public static void task0_7(){
    }
    public static void task0_10(){
    }
    public static void task0_11(){
    }



    public static void main(String[] args) {
//        task0_1();
//        task0_2();
        task0_3();
//        task0_4();
//        task0_11();


    }
}
