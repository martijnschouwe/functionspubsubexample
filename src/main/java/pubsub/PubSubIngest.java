package pubsub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.function.Consumer;

@SpringBootApplication
public class PubSubIngest {
    private static final Log log = LogFactory.getLog(PubSubIngest.class);

    public static void main(String[] args) {
        SpringApplication.run(PubSubIngest.class, args);
    }

    @Bean
    public Consumer<PubSubMessage> ingest() {
        return message -> {
            // The PubSubMessage data field is base-64 encoded which must be decoded.
            String decodedMessage = new String(Base64.getDecoder().decode(message.getData()), StandardCharsets.UTF_8);
            System.out.println("Received Pub/Sub message with data: " + decodedMessage);
        };
    }
}