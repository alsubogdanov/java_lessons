

public static void printElement(ArrayList<Integer> list, int index){
    try {
        System.out.println(list.get(index));
    }catch (IndexOutOfBoundsException e){
        System.out.println("Неверный индекс");
    }
}

public static ArrayList<Integer> convertAndStore(String[]arrStr){
    ArrayList<Integer> arr = new ArrayList<>();
    for(String item: arrStr){
        try {
            int num = Integer.parseInt(item);
            arr.add(num);
        }catch (NumberFormatException e){
            System.out.println("Ошибка ввода");
        }
    }
    return arr;
}

public static void Task0_4(ArrayList<Integer> arr){
    arr.add(arr.size()/2, 100);
    System.out.println(arr);
    for(int i= arr.size()-1; i>=0; i--){
        if(arr.get(i)<0){
            arr.remove(i);
        }
    }
    System.out.println(arr);

}
public static void divideElements(ArrayList<Integer> list, int divisor){

//        try{
//            for(int item: list) {
//                System.out.println(item / divisor);
//            }
//        }catch (ArithmeticException e){
//            System.out.println("0");
//        }catch (NullPointerException e){
//            System.out.println("null");
//        }
    try {
        if(list == null){
            throw new NullPointerException();
        }

        for(int item : list){
            System.out.println(item / divisor);
        }

    } catch (ArithmeticException e){
        System.out.println("Деление на 0 невозможно");
    } catch (NullPointerException e){
        System.out.println("Список равен null");
    }
}

public static void task0_6(ArrayList<Integer> list){

    try{
        for(int item: list){
            if (item<0||item>120)
                throw new IllegalArgumentException("age");
        }
    }catch(IllegalArgumentException e){
        System.out.println(e.getMessage());

    }
}

public static void removeAt(ArrayList<Integer> list, String indexText){
    try{
        int ind = Integer.parseInt(indexText);
        list.remove(ind);
    }catch(NumberFormatException e){
        System.out.println("not a number");
    }catch (IndexOutOfBoundsException e){
        System.out.println("index");
    }
}

public static int task0_11(ArrayList<String> list){
    int sum = 0;
    for(String item: list){
        try{
            int num = Integer.parseInt(item);
            if(num<0) throw new IllegalArgumentException();
            else sum+=num;
        }catch(NumberFormatException e){
            System.out.println("not a number");
        }catch (IllegalArgumentException e){
            System.out.println("negative");
        }
    }
    return sum;
}
public static void main(String[] args){
    ArrayList<Integer> arr = new ArrayList<>();
//    ArrayList<Integer> arr = null;
    arr.add(34);
    arr.add(-34);
    arr.add(-634);
    arr.add(6434);
    arr.add(234);
    System.out.println(arr);
//    Task0_4(arr);
    removeAt(arr, "4");

    ArrayList<String> list = new ArrayList<>();
    list.add("10");
    list.add("-150");
    list.add("20");
    list.add("90");
    list.add("1034df");
    list.add("10df");
    System.out.println(task0_11(list));
}
