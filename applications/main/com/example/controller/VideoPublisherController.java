package com.example.controller;

import com.example.notification.application.create.SendPushToSubscribersOnVideoPublished;
import com.example.shared.application.DomainEventSubscriber;
import com.example.shared.domain.EventBus;
import com.example.shared.infrastructure.bus.ReactorEventBus;
import com.example.video.application.publish.VideoPublisher;
import com.example.video.application.save.SaveVideoOnVideoPublished;
import com.example.video.application.save.VideoCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public final class VideoPublisherController {

    private final VideoCreator videoCreator;

    @Autowired
    public VideoPublisherController(VideoCreator videoCreator) {
        this.videoCreator = videoCreator;
    }

    @PutMapping("/publish")
    public void publishVideo(@RequestParam(value = "title") String title,
                         @RequestParam(value = "description") String description) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
                new SendPushToSubscribersOnVideoPublished(),
                new SaveVideoOnVideoPublished(this.videoCreator)
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus);
        videoPublisher.publish(title, description);
    }
}
