package com.example.video.application.publish;

import com.example.video.domain.Video;
import com.example.video.domain.VideoDescription;
import com.example.video.domain.VideoRepository;
import com.example.video.domain.VideoTitle;
import com.example.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;

    public VideoPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final Video video = Video.publish(title, description);
        System.out.println("Publishing new video");
//        videoRepository.save(video);
        eventBus.publish(video.pullDomainEvents());
    }
}
