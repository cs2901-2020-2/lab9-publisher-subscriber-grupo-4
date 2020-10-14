package cs.lab;

import java.util.logging.Logger;

public class Subscriber {

    MessageBroker messageBroker;

    Logger logger = Logger.getLogger(Subscriber.class.getName());
    
    public Subscriber(MessageBroker messageBroker, String channel) {
        this.messageBroker = messageBroker;
        this.subscribe(channel);
    }

    public void subscribe(String channel) {
        this.messageBroker.registerSubscriber(channel, this);
    }

    public void notify() {
        logger.info("Subscriber notified");
    }

}
