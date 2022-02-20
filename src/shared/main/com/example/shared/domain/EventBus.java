package com.example.shared.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventBus {
    void publish(final List<DomainEvent> events);
}
