package com.rackspace.papi.components.datastore.impl.replicated;

import com.rackspace.papi.components.datastore.impl.replicated.data.Operation;
import com.rackspace.papi.components.datastore.impl.replicated.data.Subscriber;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public interface Notifier {

    void startNotifications();
    void stopNotifications();
    void addSubscriber(Subscriber subscriber);
    void addSubscribers(Collection<Subscriber> subscribers);
    Set<Subscriber> getSubscribers();
    void notifyNode(Operation operation, Subscriber subscriber, String key, Serializable data, int ttl) throws IOException;
    void notifyNode(Operation[] operation, Subscriber subscriber, String[] keys, Serializable[] data, int[] ttl) throws IOException;
    void notifyAllNodes(Operation operation, String key, Serializable data, int ttl) throws IOException;
    void notifyAllNodes(Operation operation, String key, Serializable data) throws IOException;
    void notifyAllNodes(Operation operation, String key) throws IOException;
    void removeSubscriber(Subscriber subscriber);
}
