import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    public static void task0_1(){
        List<Integer> numbers = List.of(3, 10, 15, 20, 25, 30);
        numbers.stream()
                .filter(el->el>15)
                .forEach(System.out::println);

    }
    public static void task0_2(){
        List<String> words = List.of("java", "stream", "api", "code");

    }
    public static void task0_3(){
        List<Integer> data = List.of(5, 10, 15, 20, 25);
        List<Integer> res = data.stream()
                .filter(el->el%10==0)
                .peek(el-> System.out.println("Прошло фильтр: "+el))
                .collect(Collectors.toList());
    }
    public static void task0_4(){
        List<Student> students = List.of(
                new Student("Anna", 90),
                new Student("Boris", 45),
                new Student("Alex", 75),
                new Student("Ivan", 60)
        );
        List<String> res = students.stream()
                .filter(el->el.score>=60)
                .map(el->el+" passed")
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
        task0_1();
//        task0_2();
//        task0_3();
//        task0_4();
//        task0_11();


    }
}
