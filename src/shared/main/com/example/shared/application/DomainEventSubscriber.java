package com.example.shared.application;

import com.example.shared.domain.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {
    Class<EventType> subscribedTo();

    void consume(EventType event);
}
