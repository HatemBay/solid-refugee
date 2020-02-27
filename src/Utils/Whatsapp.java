package Utils;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Whatsapp {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "AC6461ce64d5f1655bf7ea007214db222f";
    public static final String AUTH_TOKEN = "8c7d2e8d7fabaf63626a558fa4bf5a59";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+21654122834"),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "pc oussama 💖 !")
           .create();

        System.out.println(message.getSid());
    }
}
