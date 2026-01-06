public class Main {
    public static void main(String[] args) {

        User user = new User("U1", "Alice");
        Book book = new Book("B1", "Clean Code");

        LibraryService libraryService = new LibraryService();

        libraryService.borrowBook(user, book);
        libraryService.returnBook(user, book);
    }
}
