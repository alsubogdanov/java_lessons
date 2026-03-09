public static void task0_1(){
    LocalTime time = LocalTime.now();
    DateTimeFormatter tForm = DateTimeFormatter.ofPattern("HH:mm:ss");
    String timeStr = time.format(tForm);
    System.out.println(timeStr);
}

public static void task0_2(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the date in format: dd.MM.yyyy");
    String userInputDate = scan.nextLine();
    DateTimeFormatter fInput = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter fOutput = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(userInputDate, fInput);
    String dateStr = date.format(fOutput);
    System.out.println(dateStr);

}

public static void task0_3(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the date in format: dd.MM.yyyy");
    String userInputDate = scan.nextLine();
    DateTimeFormatter fInput = DateTimeFormatter.ofPattern("dd.MM.yyyy",new Locale("ru"));
    LocalDate date = LocalDate.parse(userInputDate, fInput);
    String dayValue = date.getDayOfWeek().toString();
    System.out.println("День недели: " + dayValue);



}

public static void task0_4(){
    String checkInDate = "10.07.2025";
    String checkOutDate = "18.07.2025";

    DateTimeFormatter fInput = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate checkIn = LocalDate.parse(checkInDate, fInput);
    LocalDate checkOut = LocalDate.parse(checkOutDate, fInput);
    long days = ChronoUnit.DAYS.between(checkIn, checkOut);
    System.out.println("Количество дней проживания: " + days);
}

public static void task0_5(){
    LocalDate date = LocalDate.of(2025, 06, 1);
    DateTimeFormatter fIn = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
    String dateStr = date.format(fIn);
    System.out.println(dateStr);
}
public static void main(String[] args)  {
    try{

//        task0_1();
//        task0_2();
//        task0_3();
//        task0_4();
        task0_5();
    }catch(DateTimeParseException e){
        System.out.println(e.getMessage());
    }










}
