import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    @FunctionalInterface
    interface Printer {
        void print(String text);
    }

    @FunctionalInterface
    interface StringToInt {
        int convert(String s);
    }

    @FunctionalInterface
    interface StringLength {
        int apply(String s);
    }

    @FunctionalInterface
    interface IntProcessor {
        String process(int x);
    }

    public static int getLength(String s) {
        return s.length();
    }

    public static void run(IntProcessor processor) {
        System.out.println(processor.process(10));
    }

    public static void task0_1(){
        Printer p2 = System.out::println;
        p2.print("Hi");
    }
    public static void task0_2(){
        String[] numbers = {"10", "20", "30"};
        StringToInt converter1 = (s)->Integer.parseInt(s);
        System.out.println(converter1.convert("123"));

        StringToInt converter2 = Integer::parseInt;
        System.out.println(converter2.convert("1234"));

        for(String item: numbers){
            System.out.println(converter1.convert(item));
            System.out.println(converter2.convert(item));
        }

    }
    public static void task0_3(){
        StringLength s1 = Main::getLength;
        StringLength s2 = (s)->getLength(s);
        System.out.println(s1.apply("java"));
        System.out.println(s2.apply("java-new"));

    }
    public static void task0_4(){
        List<User> users = new ArrayList<>();
        users.add(new User("Boris"));
        users.add(new User("Anna"));
        users.add(new User("Kate"));
        users.add(new User("Dan"));
        users.add(new User("Alex"));
        for(User item: users){
            System.out.println(item.getName());
        }

//        users.sort((b,a)->a.getName().compareTo(b.getName()));
        users.sort(Comparator.comparing(User::getName));
        for(User item: users){
            System.out.println(item.getName());

        }

    }
    public static void task0_5(){
        run((x)->Integer.toHexString(x));
        run(Integer::toHexString);
        run((x)->"Result: " + Integer.toHexString(x));
    }


    public static void main(String[] args) {
//        task0_2();
//        task0_3();
//        task0_4();
        task0_5();
    }
}
