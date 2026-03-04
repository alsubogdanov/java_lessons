
public static ArrayList<String> task0_1_readFile(String filename) throws IOException{
//    Path p = Path.of(filename);
//    String content = Files.readString(p);
//
//    ArrayList<String> list = new ArrayList<>();
//    int ind = 0;
//
//    while (ind <= content.length()) {
//        int enterInd = content.indexOf("\n", ind);
//
//        if (enterInd == -1) {
//            enterInd = content.length();
//        }
//
//        String item = content.substring(ind, enterInd).strip();
//        list.add(item);
//
//        ind = enterInd + 1;
//
//        if (enterInd == content.length()) {
//            break;
//        }
//    }
//
//    return list;

    return (ArrayList<String>) Files.readAllLines(Path.of(filename));
}
public static void task0_1_writeFile(ArrayList<String> list, String filename) throws IOException{
//    StringBuilder listStr = new StringBuilder();
//    for(String item: list){
//        listStr.append(item + "\n");
//    }
//    String content=listStr.toString();
//    Path p = Path.of(filename);
//    Files.writeString(p, content);
    Files.write(Path.of(filename),list);

}

public static void task0_2(String filename)throws IOException{
    String content = Files.readString(Path.of(filename)).strip();
    int spaceCount = 0;
    int wordsCount = 0;
    boolean inWord = false;

    for (int i = 0; i < content.length(); i++) {
        char c = content.charAt(i);

        if (c == ' ') {
            spaceCount++;
            inWord = false; // вышли из слова
        } else if (c == '\n' || c == '\r') {
            inWord = false; // перенос строки — тоже разделитель
        } else {
            if (!inWord) {
                wordsCount++; // начинаем новое слово
                inWord = true;
            }
        }
    }
    System.out.println("Всего символов: " + content.length());
    System.out.println("Пробелов: " + spaceCount);
    System.out.println("слов: " + wordsCount);
}

public static void task0_3() throws IOException{
//    write
//    String str = "aSECRET";
//
//    byte[] bytes=str.getBytes();
//    Files.write(Path.of("secret.bin"), bytes);

    //read
    byte[] bytes = Files.readAllBytes(Path.of("secret.bin"));
//    StringBuilder strBuilder = new StringBuilder();
//    for(byte item: bytes){
//        strBuilder.append((char) item);
//    }
//    String str = strBuilder.toString();
    String str = new String(bytes, StandardCharsets.UTF_8);
    System.out.println(str);
}

public static void task0_4() throws IOException{
    String filename = "daily.txt";
    Path p = Path.of(filename);
    boolean isExists=Files.exists(p);
    if (!isExists){
        String str = "Первая запись в дневнике";
        Files.writeString(p, str);
    }else {
        long size = Files.size(p);
        System.out.println(size);
    }
//    System.out.println(isExists);
}
public static void main(String[] args){
    //        task#0_1
//    try {
//        Path p = Path.of("hello.txt");
//
////        Files.writeString(p, "Привет, файл!");
//        String content = Files.readString(p);
//        System.out.println(content);
//
//        System.out.println(task0_1_readFile("hello.txt"));
//
//        ArrayList<String> list = new ArrayList<>(Arrays.asList("Молоко", "Хлеб","Яблоки","Сыр"));
//        task0_1_writeFile(list, "hello.txt");
//
//    }catch (IOException e){
//        System.out.println(e.getMessage());
//    }

    //        task#0_2
//    try{
//        task0_2("hello.txt");
//    }catch(IOException e){
//        System.out.println(e.getMessage());
//    }

    //task0_3
//    try{
//        task0_3();
//
//    }catch(IOException e){
//        System.out.println(e.getMessage());
//    }

    //task0_4
    try{
        task0_4();

    }catch(IOException e){
        System.out.println(e.getMessage());
    }



}
