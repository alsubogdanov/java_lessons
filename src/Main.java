import java.util.*;
import java.util.function.Predicate;

public class Main {


    public static void task0_1(){

    }
    public static void task0_2(){

    }
    public static void task0_3(){


    }
    public static void task0_4(){


    }
    public static void task0_5(){

    }


    public static void main(String[] args) {
//        task0_1();
//        task0_2();
//        task0_3();
//        task0_4();
//        task0_5();


        //1
//        List<String> cards = List.of(
//                "1234567812345678",
//                "9999888877776666"
//        );
//
//        List<String> result = new ArrayList<>();
//
//        for (String card : cards) {
//            String last4 = card.substring(card.length() - 4);
//            result.add("****" + last4);
//        }
//
//        System.out.println(result);
//
//
//        //2
//        List<String> names = List.of(
//                "Ivan Petrov",
//                "Anna Smith"
//        );
//
//        List<String> logins = new ArrayList<>();
//
//        for (String name : names) {
//            String login = name.toLowerCase().replace(" ", "_");
//            logins.add(login);
//        }
//
//        System.out.println(logins);
//        //3
//        List<Integer> celsius = List.of(0, 20, 30);
//
//        List<Double> fahrenheit = new ArrayList<>();
//
//        for (Integer c : celsius) {
//            double f = c * 9.0 / 5 + 32;
//            fahrenheit.add(f);
//        }
//
//        System.out.println(fahrenheit);
//
//        //4
//        class Product {
//            String name;
//            boolean expired;
//
//            Product(String name, boolean expired) {
//                this.name = name;
//                this.expired = expired;
//            }
//        }
//
//        List<Product> products = List.of(
//                new Product("Milk", true),
//                new Product("Bread", false),
//                new Product("Cheese", true)
//        );
//
//        List<String> expiredNames = new ArrayList<>();
//
//        for (Product p : products) {
//            if (p.expired) {
//                expiredNames.add(p.name);
//            }
//        }
//
//        System.out.println(expiredNames);
//        //5
//        List<String> employees = List.of("Anna", "Boris", "Kate");
//
//        List<String> emails = new ArrayList<>();
//
//        for (String employee : employees) {
//            emails.add(employee.toLowerCase() + "@company.com");
//        }
//
//        System.out.println(emails);
//
//        //6
//        List<Integer> amounts = List.of(500, 1200, 3000, 700);
//
//        List<String> result = new ArrayList<>();
//
//        for (Integer amount : amounts) {
//            if (amount > 1000) {
//                result.add("VIP");
//            } else {
//                result.add("REGULAR");
//            }
//        }
//
//        System.out.println(result);
//
//        //7
//        List<Integer> occupied = List.of(1, 3, 5, 7);
//
//        List<Integer> free = new ArrayList<>();
//
//        for (int i = 1; i <= 10; i++) {
//            if (!occupied.contains(i)) {
//                free.add(i);
//            }
//        }
//
//        System.out.println(free);
//
//        //8
//        List<String> messages = List.of(
//                "hello",
//                "java",
//                "collections"
//        );
//
//        List<String> result = new ArrayList<>();
//
//        for (String msg : messages) {
//            result.add(msg.toUpperCase() + "!");
//        }
//
//        System.out.println(result);
//
//        //9
//        class Item {
//            String name;
//            double price;
//            int quantity;
//
//            Item(String name, double price, int quantity) {
//                this.name = name;
//                this.price = price;
//                this.quantity = quantity;
//            }
//        }
//
//        List<Item> items = List.of(
//                new Item("Laptop", 1200, 2),
//                new Item("Mouse", 25, 5)
//        );
//
//        List<String> result = new ArrayList<>();
//
//        for (Item item : items) {
//            double total = item.price * item.quantity;
//            result.add(item.name + ": " + total);
//        }
//
//        System.out.println(result);
//        //10
//        List<List<String>> schedule = List.of(
//                List.of("Math", "English"),
//                List.of("Physics")
//        );
//
//        List<String> result = new ArrayList<>();
//
//        String[] days = {"Monday", "Tuesday"};
//
//        for (int i = 0; i < schedule.size(); i++) {
//
//            List<String> lessons = schedule.get(i);
//
//            for (String lesson : lessons) {
//                result.add(days[i] + ": " + lesson);
//            }
//        }
//
//        System.out.println(result);
//
//        //11
//        class User {
//            String login;
//            String password;
//
//            User(String login, String password) {
//                this.login = login;
//                this.password = password;
//            }
//        }
//
//        List<User> users = List.of(
//                new User("anna", "123"),
//                new User("boris", "qwerty123"),
//                new User("kate", "abc")
//        );
//
//        List<String> weakUsers = new ArrayList<>();
//
//        for (User user : users) {
//            if (user.password.length() < 6) {
//                weakUsers.add(user.login);
//            }
//        }
//
//        System.out.println(weakUsers);

    }
}
