@FunctionalInterface
interface StringProcessor {
    String process(String s);
}

public static void task0_1(){
    Runnable printHello = ()-> System.out.println("Hello, Lambda!");
    printHello.run();
}

public static void task0_2(){

    Function<Integer, Integer> doubleNumber = (x)->x*2;
    System.out.println(doubleNumber.apply(5));
}
public static void task0_3(){
    List<Integer> nums = Arrays.asList(5, 1, 10, 3, 2);
    nums.sort((a,b)->b-a);
    System.out.println(nums);


}
public static void task0_4(){
    StringProcessor st = (s)-> new StringBuilder(s).reverse().toString();
    System.out.println(st.process("Hello"));

}



public static void task0_5(){

}
public static void main(String[] args)  {















}
