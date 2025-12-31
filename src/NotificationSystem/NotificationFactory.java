public class NotificationFactory {
    public static Notification getNotification(String type){
        if(type == null || type.isEmpty()){
            throw new IllegalArgumentException("No notification type.");
        }

        switch (type.toLowerCase()){
            case "Email":
                return new EmailNotification();
            case "SMS":
                return new SmsNotification();
            case "Push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Invalid notification type.");
        }
    }
}
