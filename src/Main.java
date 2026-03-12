public static void task0_1(){

}

public static void task0_2(){


}

public static void task0_4(){

}

public static void task0_3(){



}

public static void task0_5(){

}
public static void main(String[] args)  {
    //Task1
//    Computer comp = new Computer();
//    Computer.CPU cc = comp.new CPU();
//    cc.print();

    //Task2
//    Book b1 = new Book("Java Basics");
//    Book.Page bp = b1.new Page(10);
//    bp.printPage();

    //Task3
//    Team t1 = new Team("Barcelona");
//    Team.Player tp1 = t1.new Player("Messi");
//    tp1.printInfo();

    //Task5
    String[] songs = {"Imagine", "Yesterday", "Let it be"};

    Playlist playlist = new Playlist(songs);

    Playlist.Player player = playlist.new Player();

    while (player.hasNext()) {
        System.out.println("Song: " + player.nextSong());
    }














}
