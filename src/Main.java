import com.sun.net.httpserver.Request;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

static HttpClient client = HttpClient.newHttpClient();

public static void task0_2(){
    try{
        // Создаем новую колоду
        String newDeckResponse = fetch("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
        System.out.println("Ответ сервера при создании колоды:");
        System.out.println(newDeckResponse);

        // извлечение deck_id из fetchBody
        String deckId = getDataFromStr(newDeckResponse, "\"deck_id\": \"", 12, "\"");
        System.out.println("Deck ID: " + deckId);

        // Вытягиваем 1 карту
        String drawOneResponse = fetch("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=1");
        System.out.println("\nВытянутые карты (JSON):");

//        // извлекаем value
        String value = getDataFromStr(drawOneResponse, "\"value\": \"", 10, "\"");

        // извлекаем suit
        String suit = getDataFromStr(drawOneResponse, "\"suit\": \"", 9, "\"");

        // извлекаем remaining
        String remaining = getDataFromStr(drawOneResponse, "\"remaining\":", 12, "}");

        // вывод результата
        System.out.println("\nYou got: " + value + " of " + suit);
        System.out.println("Cards remaining: " + remaining);
        System.out.println(drawOneResponse);

    }catch(IOException|InterruptedException e){
        System.out.println(e.getMessage());
    }
}
public static void task0_3(){
    try{
        // Создаем новую колоду
        String newDeckResponse = fetch("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");

        // извлечение deck_id из fetchBody
        String deckId = getDataFromStr(newDeckResponse, "\"deck_id\": \"", 12, "\"");
        System.out.println("Deck ID: " + deckId);

        // Вытягиваем 1 карту
        String drawFirstCardResponse = fetch("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=1");
        String[] firstCardData = parseCard(drawFirstCardResponse);
        String drawSecondCardResponse = fetch("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=1");
        String[] secondCardData = parseCard(drawSecondCardResponse);

        int cardVal1 = getCardIntValue(firstCardData[0]);
        int cardVal2 = getCardIntValue(secondCardData[0]);

        // вывод результата
        System.out.println(String.format("Card 1: %s of %s", firstCardData[0], firstCardData[1]));
        System.out.println(String.format("Card 2: %s of %s", secondCardData[0], secondCardData[1]));
        if(cardVal1 > cardVal2){
            System.out.println("Winner: Card 1");
        }
        else if(cardVal2 > cardVal1){
            System.out.println("Winner: Card 2");
        }
        else{
            System.out.println("Tie!");
        }
        System.out.println("Cards remaining: " + secondCardData[2]);

    }catch(IOException|InterruptedException|NumberFormatException e){
        System.out.println(e.getMessage());
    }
}
public static void task0_5(){
    try{
        // Создаем новую колоду
        String newDeckResponse = fetch("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");

        // извлечение deck_id из fetchBody
        String deckId = getDataFromStr(newDeckResponse, "\"deck_id\": \"", 12, "\"");
        System.out.println("Your hand:");
        String cardVal="";
        do {
            // Вытягиваем карту
            String drawFirstCardResponse = fetch("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=1");
            String[] firstCardData = parseCard(drawFirstCardResponse);
            cardVal = firstCardData[0];
            System.out.println(cardVal + " of " + firstCardData[1]);
        }while (!cardVal.equals("ACE"));

    }catch(IOException|InterruptedException|NumberFormatException e){
        System.out.println(e.getMessage());
    }
}

public static String getDataFromStr(String str, String startVal, int offset, String endVal){
    int start = str.indexOf(startVal) + offset;
    int end = str.indexOf(endVal, start);

    String res = str.substring(start, end);

    return res;
}

public static String fetch(String url) throws IOException, InterruptedException{
    HttpRequest req = HttpRequest.newBuilder(URI.create(url)).GET().build();
    HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

    return res.body();
}

public static String[] parseCard(String str){
    // извлекаем value
    String value = getDataFromStr(str, "\"value\": \"", 10, "\"");

    // извлекаем suit
    String suit = getDataFromStr(str, "\"suit\": \"", 9, "\"");

    // извлекаем remaining
    String remaining = getDataFromStr(str, "\"remaining\":", 12, "}");
    return new String[]{value, suit, remaining};
}

public static int getCardIntValue(String cardValue){
    int res = switch (cardValue){
        case "JACK" -> 11;
        case "QUEEN" -> 12;
        case "KING" -> 13;
        case "ACE" -> 14;
        default -> Integer.parseInt(cardValue);
    };
    return res;
}

public static String getCardStringValue(int cardValue){
    String res = switch (cardValue){
        case 11 -> "JACK";
        case 12 -> "QUEEN";
        case 13 -> "KING";
        case 14 -> "ACE";
        default -> cardValue+"";
    };
    return res;
}




public static void main(String[] args)  {
//    task0_2();
//    task0_3();
    task0_5();













    }
