package cs.lab;

import java.util.Stack;
import java.util.HashMap;

public class MessageBroker {

    Subscriber s;
    private HashMap<String, Stack<Subscriber>> subscribers;

    private static MessageBroker messageBrokerInstance = null;

    public static synchronized MessageBroker getInstance() {
        if (messageBrokerInstance == null) {
            messageBrokerInstance = new MessageBroker();
        }
        return messageBrokerInstance;
    }

    private MessageBroker() {
        this.subscribers = new HashMap<>();
    }

    public synchronized void registerSubscriber(String channel, Subscriber s) {
        if (this.subscribers.get(channel) == null) {
            Stack<Subscriber> subscribersStack = new Stack<>();
            subscribersStack.push(s);
            this.subscribers.put(channel, subscribersStack);
        } else {
            this.subscribers.get(channel).push(s);
        }
    }

    public Subscriber getFirstSubscriberOnChannel(String channel){
        return this.subscribers.get(channel).firstElement();
    }

    public synchronized void removeSubscriber(String channel, Subscriber s) {
        this.subscribers.get(channel).remove(s);
    }

    public synchronized void notifySubscribers(String message, String channel) {
        Stack<Subscriber> subscribersStack = this.subscribers.get(channel);
        for(Subscriber subscriber : subscribersStack)
            subscriber.notifySubscriber(message);
    }
}
