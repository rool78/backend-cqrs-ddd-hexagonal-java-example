package com.example.video.application.save;

import com.example.shared.application.DomainEventSubscriber;
import com.example.shared.domain.EventBus;
import com.example.video.domain.*;

public final class SaveVideoOnVideoPublished implements DomainEventSubscriber<VideoPublished> {

    private final VideoCreator videoCreator;

    public SaveVideoOnVideoPublished(VideoCreator videoCreator) {
        this.videoCreator = videoCreator;
    }

    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        System.out.println("Save video on event published");
        VideoTitle videoTitle = new VideoTitle(event.title());
        VideoDescription videoDescription = new VideoDescription(event.description());
        videoCreator.create(videoTitle, videoDescription);
    }
}
