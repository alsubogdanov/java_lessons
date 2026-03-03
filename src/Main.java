public static void task0_1(){
    HashMap<String, String> phonebook = new HashMap<>();
    phonebook.put("Ann","123");
    phonebook.put("Kate","234");
    phonebook.put("Dan","345");
    phonebook.put("Ben","456");
    phonebook.put("Alex","567");
    System.out.println("Ben");
    System.out.println(phonebook.containsValue("456"));
}

public static void task0_2(){
    var list = new ArrayList<>(Arrays.asList("Anna", "Ivan", "Anna", "Oleg", "Ivan", "Anna"));
    HashMap<String, Integer> map = new HashMap<>();
    for(String item: list){
        if(map.containsKey(item)){
            map.put(item, map.get(item)+1);
        }else map.put(item, 1);
    }
    for(var item: map.entrySet()){
        System.out.println(item.getKey()+"->"+item.getValue());
    }
}

public static void task0_3(){
    HashMap<String, Integer> map = new HashMap<>();

}

public static void task0_3AddProduct(HashMap<String, Integer> stock, String productName,int quantity){
    System.out.println("Add");
    if(quantity<=0)
        throw new IllegalArgumentException("Количество должно быть > 0");
    if(stock.containsKey(productName)){
        stock.put(productName, stock.get(productName)+quantity );
    }else {
        stock.put(productName, quantity);
    }
}

public static void task0_3SellProduct(HashMap<String, Integer> stock, String productName,int quantity){
    System.out.println("Sell");
    if(!stock.containsKey(productName))
        throw new NoSuchElementException("Товар отсутствует на складе");
    if (quantity<=0)
        throw new IllegalArgumentException("Количество продажи должно быть > 0");
    if (stock.get(productName)<quantity)
        throw new IllegalStateException("Недостаточно товара на складе");

    stock.put(productName, stock.get(productName)-quantity);
}

public static void task0_3PrintStock(HashMap<String, Integer> stock){
    System.out.println("Stock: ");
    for (var item: stock.entrySet()){
        System.out.println(item.getKey()+"->"+item.getValue());
    }
}

public static ArrayList<String> task0_4(ArrayList<String> list){
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> duplicateLogins = new ArrayList<>();
    for(var item: list){
        if(map.containsKey(item))
            map.put(item,map.get(item)+1);
        else
            map.put(item, 1);
    }
    for (var item: map.entrySet()){
        if(item.getValue()>1)
            duplicateLogins.add(item.getKey());
    }
    return duplicateLogins;
}

public static HashMap<String, Integer> task0_5(ArrayList<String> list){
    HashMap<String, Integer> originalMap = new HashMap<>();
    for(String item: list){
        String[] itemData = item.split(" ");
        String itemName = itemData[0];
        int itemAmount  = Integer.parseInt(itemData[1]);
        int newVal = originalMap.getOrDefault(itemName,0)+itemAmount;

        originalMap.put(itemName, newVal);
    }
    return originalMap;
}

public  static void task0_6AddOrUpdatePlayer(HashMap<String, Integer> players, String playerName, String scoreToAddStr){
    int score = Integer.parseInt(scoreToAddStr);
    if(score<0) throw new IllegalArgumentException("score have to be positive");
    int newScoreVal = players.getOrDefault(playerName,0)+score;
    players.put(playerName, newScoreVal);
}
public static String task0_6GetTopPlayer(HashMap<String, Integer> players){
    String topPlayer = "";
    int max = 0;
    for(var item: players.entrySet()){
        if(item.getValue()>max){
            max=item.getValue();
            topPlayer=item.getKey();
        }
    }
    return topPlayer;
}
public static void task0_6RemovePlayer(HashMap<String, Integer> players, String playerName){
    if(players.containsKey(playerName)){
        players.remove(playerName);
        System.out.println(playerName + " was deleted");
    }
    else
        System.out.println(playerName + " not found");
}
public static void main(String[] args){

//    task0_1();
//    task0_2();

    //task0_3
//    HashMap<String, Integer> stock = new HashMap<>();
//    stock.put("Apple", 5);
//    stock.put("Banana", 3);
//    stock.put("Orange", 7);
//    try{
//        task0_3PrintStock(stock);
//        task0_3AddProduct(stock, "Apple", -10);
//        task0_3PrintStock(stock);
//        task0_3AddProduct(stock, "Kiwi", 8);
//        task0_3PrintStock(stock);
//        task0_3SellProduct(stock, "Kiwi", 4);
//        task0_3PrintStock(stock);
//
//    }catch(Exception e){
//        System.out.println(e.getMessage());
//    }

    //task0_4
//    ArrayList<String> logins = new ArrayList<>(Arrays.asList(
//            "alice", "bob", "charlie", "alice", "david", "bob", "eve", "frank"
//    ));
//    System.out.println(task0_4(logins));

    //task0_5
//    ArrayList<String> list = new ArrayList<>(Arrays.asList("Food t50", "Transport 20", "Food 30", "Entertainment 100"));
//    System.out.println();
//    try{
//        System.out.println(task0_5(list));
//    }catch(NumberFormatException e){
//        System.out.println(e.getMessage());
//    }

    //task 0_6
    String[] startingPlayers= {
            "Alice 50",
            "Bob 30",
            "Charlie 40",
            "Diana 25",
            "Ethan 60"
    };
    HashMap<String, Integer> map = new HashMap<>();
    for(String item: startingPlayers){
        String player = item.substring(0, item.indexOf(" "));
        String score = item.substring(item.indexOf(" ")+1);
        try{
            map.put(player, Integer.parseInt(score));
        }catch(NumberFormatException e){
            System.out.println("score " + score+ " is not a number");
        }
    }
    System.out.println(map);

    try{
        task0_6AddOrUpdatePlayer(map, "Dan", "22");
        task0_6AddOrUpdatePlayer(map, "Diana", "10");
        System.out.println(map);
        task0_6RemovePlayer(map, "Bыob");
        System.out.println(map);

    }catch(NumberFormatException e){
        System.out.println(e.getMessage());
    }


    System.out.println(task0_6GetTopPlayer(map));




}
