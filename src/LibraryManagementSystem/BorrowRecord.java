import java.time.LocalDate;

public class BorrowRecord {
    User user;
    Book book;
    LocalDate borrowDate;

    public BorrowRecord(User user, Book book, LocalDate borrowDate) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}
