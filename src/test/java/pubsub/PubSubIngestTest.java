package pubsub;

import org.junit.Test;

import java.util.function.Consumer;

public class PubSubIngestTest {

    Consumer<PubSubMessage> function;

    @Test
    public void testFunction() throws Exception {
        PubSubMessage p = new PubSubMessage();
        p.setData("VGhpcyBpcyB0aGUgbWVzc2FnZSBkYXRh");
        function = new PubSubIngest().ingest();
        this.function.accept(p);
    }

}
