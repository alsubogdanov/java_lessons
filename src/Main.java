public static void task0_1(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the date in format: yyyy-MM-d");
    String dateStr = scan.nextLine();
    DateTimeFormatter fIn = DateTimeFormatter.ofPattern("yyyy-MM-d");
    LocalDate date = LocalDate.parse(dateStr, fIn);
    LocalDate reminderDate = date.minusDays(7);
    System.out.println("Event date: " + date.format(fIn));
    System.out.println("Reminder date: " + reminderDate.format(fIn));
}

public static void task0_2(){
    String dateStr = "2025-05-20"; //строка уже в ISO формате

    LocalDate taskDate = LocalDate.parse(dateStr);
    LocalDate today = LocalDate.now();
    long days = ChronoUnit.DAYS.between(taskDate, today);
    System.out.println("Задача создана " + days + " дней назад");
}

public static void task0_4(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter your birthday in format \"dd.MM.yyyy\": ");
    String birthdayStr = scan.nextLine();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate birthday = LocalDate.parse(birthdayStr,f);
    LocalDate now = LocalDate.now();
    if (birthday.isAfter(now)) {
        System.out.println("Дата рождения не может быть в будущем");
        return;
    }else {
        Period p = Period.between(birthday, now);
        System.out.println(String.format("Возраст: %d года %d месяца %d дней", p.getYears(), p.getMonths(), p.getDays()));
    }
}

public static void task0_3(){
    LocalDate deadline = LocalDate.parse("2026-04-11");
    LocalDate now = LocalDate.now();
    long days = ChronoUnit.DAYS.between(now, deadline);

    if (days > 0) {
        System.out.println("До дедлайна осталось " + days + " дней");
    }
    else if (days == 0) {
        System.out.println("Сегодня дедлайн!");
    }
    else {
        System.out.println("Дедлайн прошёл " + Math.abs(days) + " дней назад");
    }
//    System.out.println(deadline);



}

public static void task0_5(){
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime t1 = LocalDateTime.parse("2025-06-01 09:30", f);
    LocalDateTime t2 = LocalDateTime.parse("2025-06-01 17:45", f);
    Duration time = Duration.between(t1,t2);
    System.out.println(time);
    System.out.println("Рабочее время: "+time.toHours()+" часов "+time.toMinutes()%60+" минут" );
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
