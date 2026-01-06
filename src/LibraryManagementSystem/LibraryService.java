import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
    public void borrowBook(User user, Book book){
        if(!book.isAvailable()){
            System.out.println("Book already borrowed!");
            return;
        }
        book.markBorrowed();
        BorrowRecord borrowRecord = new BorrowRecord(user, book, LocalDate.now());
        borrowRecords.add(borrowRecord);
        System.out.println("Book borrowed successfully by " + user.getName());
    }

    public void returnBook(User user, Book book){
        BorrowRecord record = findRecord(user, book);
        if(book.isAvailable()){
            System.out.println("Book was not borrowed");
            return;
        }
        book.markAvailable();
        borrowRecords.remove(record);
        System.out.println("Book returned by " + user.getName());
    }

    private BorrowRecord findRecord(User user, Book book){
        for(BorrowRecord record: borrowRecords){
            if(record.getUser().equals(user) && record.getBook().equals(book)){
                return record;
            }
        }
        return null;
    }
}
