public class Book {
    private String bookId;
    private String title;
    private boolean available=true;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void markBorrowed(){
       this.available = false;
    }

    public void markAvailable(){
        this.available = true;
    }
}
