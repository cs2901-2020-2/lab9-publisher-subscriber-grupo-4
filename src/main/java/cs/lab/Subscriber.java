package cs.lab;

import java.util.logging.Logger;

public class Subscriber {

    Logger logger = Logger.getLogger(Subscriber.class.getName());

    public Subscriber(String channel) {
        this.subscribe(channel);
    }

    public void subscribe(String channel) {
        MessageBroker.getInstance().registerSubscriber(channel, this);
    }

    public void notifySubscriber(String message) {
        String m = "Subscriber notified: " + message;
        logger.info(m);
    }

}
