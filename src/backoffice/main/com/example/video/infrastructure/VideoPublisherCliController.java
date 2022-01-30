package com.example.video.infrastructure;

import com.example.notification.application.create.SendPushToSubscribersOnVideoPublished;
import com.example.video.application.publish.VideoPublisher;
import com.example.shared.application.DomainEventSubscriber;
import com.example.shared.domain.EventBus;
import com.example.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final var videoRepository = new HardcodedMemoryVideoRepository();
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus, videoRepository);

        final String videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final String videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);
    }
}
