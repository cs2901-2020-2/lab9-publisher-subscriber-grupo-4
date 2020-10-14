package cs.lab;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessageBrokerTest {
    static final Logger logger = Logger.getLogger(MessageBrokerTest.class.getName());

    private MessageBrokerTest() {
    }

    @Test
    public void testCase0() {
        MessageBroker messageBroker = new MessageBroker();
        Subscriber subsriber = new Subscriber(messageBroker, "Channel 1");
        messageBroker.registerSubscriber(subsriber);
        assertEquals(subsriber, messageBroker.getFirstSubscriberOnChannel("Channel 1");
    }

    @Test
    public void testCase1() {

    }

}