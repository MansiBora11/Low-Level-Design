public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.notifyUser("EMAIL", "abc@gmail.com", "Welcome!");
    }
}
