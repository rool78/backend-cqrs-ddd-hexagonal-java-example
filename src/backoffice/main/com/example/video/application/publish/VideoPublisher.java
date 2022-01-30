package com.example.video.application.publish;

import com.example.video.domain.Video;
import com.example.video.domain.VideoDescription;
import com.example.video.domain.VideoRepository;
import com.example.video.domain.VideoTitle;
import com.example.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;
    private final VideoRepository videoRepository;

    public VideoPublisher(EventBus eventBus, VideoRepository videoRepository) {
        this.eventBus = eventBus;
        this.videoRepository = videoRepository;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);
        System.out.println("Publishing new video");
        videoRepository.save(video);
        eventBus.publish(video.pullDomainEvents());
    }
}
