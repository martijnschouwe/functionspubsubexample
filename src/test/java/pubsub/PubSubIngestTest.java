package pubsub;

import org.junit.Test;

import java.util.function.Consumer;

public class PubSubIngestTest {

    Consumer<PubSubMessage> function;

    @Test
    public void testFunction() throws Exception {
        PubSubMessage p = new PubSubMessage();
        p.setData("TEST");
        function = new PubSubIngest().ingest();
        this.function.accept(p);
    }
    
}
