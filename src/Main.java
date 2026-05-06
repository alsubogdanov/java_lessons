import java.util.*;
import java.util.function.Predicate;

public class Main {


    public static void task0_1(){
        List<String> list = new ArrayList<>(Arrays.asList("login", "open", "click", "click", "error", "logout"));
        System.out.println(list.lastIndexOf("click"));

    }
    public static void task0_2(){
        List<String> list = new ArrayList<>(Arrays.asList("login", "open", "click", "click", "error", "logout"));
        list.removeIf(item->item.equals("click"));
        System.out.println(list);
    }
    public static void task0_3(){
        List<String> list = new ArrayList<>(Arrays.asList("step1", "step2", "step3"));
        list.add(1, "step1.5");
        System.out.println(list);

    }
    public static void task0_4(){
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 2, 9, 12, 5, 8));
        list.removeIf(el->el>7);
        System.out.println(list);

    }
    public static void task0_5(){
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 7, 2, 9, 12, 5, 8));
        list.add(0,list.get(list.size()-1));
        list.remove(list.size()-1);
        System.out.println(list);
    }


    public static void main(String[] args) {
//        task0_1();
//        task0_2();
//        task0_3();
//        task0_4();
//        task0_5();

        //Set

        List<String> list = new ArrayList<>(Arrays.asList("a@mail.com", "b@mail.com", "a@mail.com"));
        //1
        Set<String> set = new HashSet<>(list);
//        System.out.println(set);
        //2
//        System.out.println(set.contains("b@mail.com"));

        //3
//        Set<String> users = new HashSet<>();
//        Scanner scan = new Scanner(System.in);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Enter user name:");
//            String name = scan.nextLine();
//            users.add(name);
//        }
//        System.out.println(users);
//
        //4
//        Set<String> set = new HashSet<>();
//
//        for (String e : list) {
//            if (!set.add(e)) {
//                return true; // дубликат найден
//            }
//        }
//        return false;

        //5
//        Set<String> common = new HashSet<>(a);
//        common.retainAll(b);


        //Map
        //1
//        List<Integer> grades = new ArrayList<>(Arrays.asList(90, 80, 90, 70, 80, 90));
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int item: grades){
//            int count = map.getOrDefault(item,0);
//            map.put(item, count+1);
//        }
//        System.out.println(map);

        //2
//        Map<String, Integer> map = new HashMap<>();
//        map.put("Kate", 80);
//        map.put("Dan", 80);
//        map.put("Ben", 70);
//        map.put("Olga", 70);
//        map.put("Yan", 80);
//
//        Map<Integer, List<String>> res = new HashMap<>();

        //👉 Проверяешь: есть ли уже такой ключ (оценка)
        //👉 Если нет — создаёшь пустой список
        //👉 Добавляешь имя в список
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            String name = entry.getKey();     // имя
//            Integer grade = entry.getValue(); // оценка
//
//            if (!res.containsKey(grade)) {
//                res.put(grade, new ArrayList<>());
//            }
//            res.get(grade).add(name);
//        }

//        System.out.println(res);

        //3
//        List<String> list2 = new ArrayList<>(Arrays.asList("asd","qwe","asd","asd","ert"));
//        Map<String,Integer> res = new HashMap<>();
//        for(String item: list2){
//            int count = res.getOrDefault(item, 0);
//            res.put(item,count+1);
//        }
//        System.out.println(res);
//        int maxVal = 0;
//        String maxW = null;
//        for(Map.Entry<String,Integer> m: res.entrySet()){
//            if(m.getValue()>maxVal) {
//                maxVal = m.getValue();
//                maxW=m.getKey();
//            }
//        }
//        System.out.println(maxW);

        //4
//        создаётся новая HashMap, куда копируются все пары из a
//        Map<String, Integer> result = new HashMap<>(a);
//
//        for (Map.Entry<String, Integer> e : b.entrySet()) {
//        result.getOrDefault(key, 0)
//        если ключ есть → берём значение
//        если нет → берём 0
//            result.put(e.getKey(),
//                    result.getOrDefault(e.getKey(), 0) + e.getValue());
//        }

        //5
//        Map<String, Integer> api = new HashMap<>();
//
//        for (String url : requests) {
//            api.put(url, api.getOrDefault(url, 0) + 1);
//        }
    }
}
