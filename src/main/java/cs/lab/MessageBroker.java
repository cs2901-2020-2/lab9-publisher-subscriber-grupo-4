package cs.lab;

import java.util.Stack;
import java.util.HashMap;

public class MessageBroker {

    Subscriber s;
    private HashMap<String, Stack<Subscriber>> subscribers = new HashMap<>();

    public void registerSubscriber(String channel, Subscriber s) {
        this.subscribers.get(channel).push(s);
    }

    public Subscriber getFirstSubscriberOnChannel(String channel) {
        return this.subscribers.get(channel).firstElement();
    }

    public void removeSubscriber(String channel, Subscriber s) {
        this.subscribers.get(channel).remove(s);
    }

    public void notifySubscribers(String channel) {
        this.subscribers.get(channel).forEach(suscriber -> suscriber.notify());
    }
}
