public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    class Page{
        private int number;

        public Page(int number) {
            this.number = number;
        }

        public void printPage(){
            System.out.println("Book: " + title + ", page: "+ this.number);
        }
    }
}
