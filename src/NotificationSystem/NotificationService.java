public class NotificationService {
    public void notifyUser(String type,String recipient, String message){
        Notification notification = NotificationFactory.getNotification(type);
        notification.send(recipient, message);
    }
}
