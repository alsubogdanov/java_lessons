public static void task0_1(){
    //0
//    ZonedDateTime jerusalemTime = ZonedDateTime.now(ZoneId.of("Asia/Jerusalem"));

    //1
//    ZoneId jerusalem = ZoneId.of("Asia/Jerusalem");
//    ZoneId london = ZoneId.of("Europe/London");
//    ZoneId tokyo = ZoneId.of("Asia/Tokyo");
//
//    System.out.println("Jerusalem: " + ZonedDateTime.now(jerusalem));
//    System.out.println("London: " + ZonedDateTime.now(london));
//    System.out.println("Tokyo: " + ZonedDateTime.now(tokyo));

    //2
    String[] zones = {
            "Asia/Jerusalem",
            "Europe/London",
            "Asia/Tokyo"
    };

    for(String zone : zones){
        System.out.println(zone + ": " +
                ZonedDateTime.now(ZoneId.of(zone)));
    }
}

public static void task0_2(){
    ZoneId laZone = ZoneId.of("America/Los_Angeles");
    ZonedDateTime laTime = ZonedDateTime.now(laZone);

    LocalTime currentTime = laTime.toLocalTime();

    LocalTime start = LocalTime.of(9,0);
    LocalTime end = LocalTime.of(17,0);

    boolean isOpen =
            !currentTime.isBefore(start) &&
                    !currentTime.isAfter(end);

    System.out.println("LA time: " + currentTime);
    System.out.println("Support open: " + isOpen);
}

public static void task0_3(){
    LocalDateTime meeting = LocalDateTime.of(2025, 6, 1, 19,00);
    ZoneId jerusalem = ZoneId.of("Asia/Jerusalem");
    ZoneId london = ZoneId.of("Europe/London");
    ZoneId la = ZoneId.of("America/Los_Angeles");

    ZonedDateTime jerusalemMeeting = meeting.atZone(jerusalem);
    ZonedDateTime londonMeeting = jerusalemMeeting.withZoneSameInstant(london);
    ZonedDateTime laMeeting = jerusalemMeeting.withZoneSameInstant(la);

    System.out.println("Meeting in Jerusalem: " + jerusalemMeeting + "\n" +
            "Meeting in London: "+ londonMeeting+ "\n" +
            "Meeting in Los Angeles: "+ laMeeting);

}

public static void task0_4() throws InterruptedException{
    HashMap<String, Instant> events = new HashMap<>();
    events.put("Server started", Instant.now());
    Thread.sleep(1000);
    events.put("User login", Instant.now());
    Thread.sleep(1000);
    events.put("Data backup", Instant.now());
    Thread.sleep(1000);
//    System.out.println(events);

    ZoneId userZone = ZoneId.of("Asia/Tokyo");
    for(var item: events.entrySet()){
        System.out.println(item.getKey() + " -> " + item.getValue().atZone(userZone));
    }
}

public static void task0_5(){
    HashMap<String, Instant> flights = new HashMap<>();
    ZonedDateTime SU100 = ZonedDateTime.of(LocalDateTime.of(2025, 06,01,10,0), ZoneId.of("Europe/Moscow"));
    flights.put("SU100", SU100.toInstant());

    ZonedDateTime BA200 = ZonedDateTime.of(LocalDateTime.of(2025, 06,01,14,30), ZoneId.of("Europe/London"));
    flights.put("BA200", BA200.toInstant());

    ZonedDateTime JL300 = ZonedDateTime.of(LocalDateTime.of(2025, 06,01,18,0), ZoneId.of("Asia/Tokyo"));
    flights.put("JL300", JL300.toInstant());

    for(var item: flights.entrySet()){
        System.out.println(item.getKey()+" -> "+item.getValue());
    }
    Instant earliestTime = null;
    String earliestFlight = null;

    for (var entry : flights.entrySet()) {
        if (earliestTime == null || entry.getValue().isBefore(earliestTime)) {
            earliestTime = entry.getValue();
            earliestFlight = entry.getKey();
        }
    }
    System.out.println("earliestFlight: " + earliestFlight + "-> " + earliestTime);
}
public static void main(String[] args)  {
//    task0_1();
//    task0_2();
//    task0_3();
//    try{
//        task0_4();
//    }catch(InterruptedException e){
//        System.out.println(e.getMessage());
//    }
    task0_5();








}
