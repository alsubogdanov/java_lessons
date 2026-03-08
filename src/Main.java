public static void task0_1() throws IOException{
    String dateStr = Files.readString(Path.of("birthday.txt"));
    System.out.println(dateStr);
    LocalDate date = LocalDate.parse(dateStr);
    System.out.println(date);
    System.out.println(date.getDayOfWeek());
}
public static void task0_2() throws IOException{
    String filename = "current_time.txt";
    LocalTime time = LocalTime.now();
    System.out.println(time);
    Files.writeString(Path.of(filename), time.toString());

    String timeStr = Files.readString(Path.of(filename));
    LocalTime time2 = LocalTime.parse(timeStr);
    System.out.println(time2);
}
public static void task0_3() throws  IOException, DateTimeParseException{
    String filename = "meeting_times.txt";
    //1
    String times = Files.readString(Path.of(filename));
    String[] arr = times.split("\\R");
    LocalTime time1 = LocalTime.parse(arr[0]);
    LocalTime time2 = LocalTime.parse(arr[1]);

    //2
//    List<String> times = Files.readAllLines(Path.of(filename));
//    LocalTime time1 = LocalTime.parse(times.get(0));
//    LocalTime time2 = LocalTime.parse(times.get(1));
//
    if(time1.isAfter(time2))
        System.out.println(time1);
    else
        System.out.println(time2);
}
public static void task0_5() throws IOException, DateTimeParseException, IllegalArgumentException{
    String startDatesFilename = "start_dates.txt";
    String endDatesFilename = "end_dates.txt";
    List<String> startDates = Files.readAllLines(Path.of(startDatesFilename));
    List<String> endDates = Files.readAllLines(Path.of(endDatesFilename));
    if(startDates.size()!= endDates.size()) {
        throw new IllegalArgumentException("not correct data in files");
    }
    for(int i=0; i<startDates.size(); i++){
        LocalDate d1 = LocalDate.parse(startDates.get(i).trim());
        LocalDate d2 = LocalDate.parse(endDates.get(i).trim());
        if(d2.isBefore(d1)){
            throw new IllegalArgumentException("End date before start date for event "+(i+1));
        }
        long days = ChronoUnit.DAYS.between(d1,d2);
        System.out.println("Event# " + (i+1)+" lasts "+ days+ " days");
    }
}

public static void task0_6(LocalDate date) throws IOException, DateTimeParseException, IllegalArgumentException {
    String event_datesFilename = "event_dates.txt";
    String event_namesFilename = "event_names.txt";
    List<String> event_dates = Files.readAllLines(Path.of(event_datesFilename));
    List<String> event_names = Files.readAllLines(Path.of(event_namesFilename));
    if (event_names.size() != event_dates.size())
        throw new IllegalArgumentException("not correct data in files");

    //1
//    for (int i = 0; i < event_dates.size(); i++) {
//        LocalDate currentDate = LocalDate.parse(event_dates.get(i).trim());
//        if (currentDate.equals(date)) {
//            System.out.println(currentDate + " -> " + event_names.get(i));
//            return;
//        }
//    }
//    System.out.println("No event on this date");

    //2
    HashMap<LocalDate, String> events = new HashMap<>();
    for(int i=0; i<event_dates.size(); i++){
        events.put(LocalDate.parse(event_dates.get(i).trim()),event_names.get(i).trim());
    }
    if (events.containsKey(date)){
        System.out.println(date + " -> " + events.get(date));
    }else {
        System.out.println("No event on this date");
    }
}

public static void main(String[] args)  {

    try {
//        task0_1();
//        task0_2();
//        task0_3();
//        task0_5();
        LocalDate d = LocalDate.parse("2026-06-15");
        task0_6(d);
    }catch (IOException|DateTimeParseException e){
        System.out.println(e.getMessage());
    }







}
