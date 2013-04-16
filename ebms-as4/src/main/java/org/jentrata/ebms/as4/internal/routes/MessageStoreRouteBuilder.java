package org.jentrata.ebms.as4.internal.routes;

import org.apache.camel.builder.RouteBuilder;
import org.jentrata.ebms.messaging.MessageStore;

/**
 * Proivdes support for persisting a message into a store and providing a
 * reference to the message in the store
 *
 * @author aaronwalker
 */
public class MessageStoreRouteBuilder extends RouteBuilder {

    private String messageStoreEndpoint = MessageStore.DEFAULT_MESSAGE_STORE_ENDPOINT;
    private MessageStore messageStore;

    @Override
    public void configure() throws Exception {
        from(messageStoreEndpoint)
            .bean(messageStore,"store")
        .routeId("_jentrataMessageStore");
    }

    public String getMessageStoreEndpoint() {
        return messageStoreEndpoint;
    }

    public void setMessageStoreEndpoint(String messageStoreEndpoint) {
        this.messageStoreEndpoint = messageStoreEndpoint;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
}