/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Tarek
 */
// Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC28184b28107b76319599ecb5e674b8bb";
    public static final String AUTH_TOKEN =
            "760daad1fa00e6f96afc0b7cc1900217";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+21627213977"), // to
                        new PhoneNumber("+17742217169"), // from
                        "Where's Wallace?")
                .create();

        System.out.println(message.getSid());
    }
}