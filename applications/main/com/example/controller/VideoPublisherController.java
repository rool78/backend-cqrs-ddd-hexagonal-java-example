package com.example.controller;

import com.example.notification.application.create.SendPushToSubscribersOnVideoPublished;
import com.example.video.application.publish.VideoPublisher;
import com.example.shared.application.DomainEventSubscriber;
import com.example.shared.domain.EventBus;
import com.example.shared.infrastructure.bus.ReactorEventBus;
import com.example.video.application.save.SaveVideoOnVideoPublished;
import com.example.video.application.save.VideoCreator;
import com.example.video.domain.VideoRepository;
import com.example.video.infrastructure.HardcodedMemoryVideoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class VideoPublisherController {

    @PutMapping("/publish")
    public void greeting(@RequestParam(value = "title") String title,
                         @RequestParam(value = "description") String description) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
                new SendPushToSubscribersOnVideoPublished(),
                new SaveVideoOnVideoPublished(new VideoCreator(new HardcodedMemoryVideoRepository()))
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus);
        videoPublisher.publish(title, description);
    }
}
