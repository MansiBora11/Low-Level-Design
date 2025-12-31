public class PushNotification implements Notification{
    @Override
    public void send(String recipient, String message) {
        System.out.println("Sending PUSH notification to " + recipient + ": " + message);
    }
}
