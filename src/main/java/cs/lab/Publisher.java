package cs.lab;

public class Publisher {

    String channel;
    
    public Publisher(String message, String channel) {
        this.channel = channel;
        this.publish(message, this.channel);
    }

    public void publish(String message, String channel){
        MessageBroker.getInstance().notifySubscribers(message, channel);
    }

}
