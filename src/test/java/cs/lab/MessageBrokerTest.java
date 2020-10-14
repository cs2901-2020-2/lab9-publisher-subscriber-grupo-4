package cs.lab;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MessageBrokerTest {
    static final Logger logger = Logger.getLogger(MessageBrokerTest.class.getName());

    private MessageBrokerTest() {
    }

    @Test //ADD
    public void testCase0() {
        MessageBroker messageBroker = MessageBroker.getInstance(); 
        Subscriber subscriber = new Subscriber("Channel 1");
        assertEquals(subscriber, messageBroker.getFirstSubscriberOnChannel("Channel 1"));
    }

    @Test(expectedExceptions = NoSuchElementException.class) //REMOVE
    public void testCase1() throws NoSuchElementException {
        String channel = "Channel 2";
        MessageBroker messageBroker = MessageBroker.getInstance(); 
        Subscriber subscriber = new Subscriber(channel);
        messageBroker.removeSubscriber(channel, subscriber);
        messageBroker.getFirstSubscriberOnChannel(channel);
    }

    
    @Test(invocationCount = 100, threadPoolSize = 100) //THREADS
    public void testCase2() {
        MessageBroker messageBroker = MessageBroker.getInstance();
        Subscriber subscriber = new Subscriber("Channel 1");
        messageBroker.registerSubscriber("Channel 1", subscriber);
        Publisher publisher = new Publisher("Mensaje para Channel 1", "Channel 1");
    }
    
    //mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar

}