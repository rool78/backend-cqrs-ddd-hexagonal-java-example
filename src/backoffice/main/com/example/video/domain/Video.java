package com.example.video.domain;

import com.example.shared.domain.AggregateRoot;

public final class Video extends AggregateRoot {
    private final VideoTitle title;
    private final VideoDescription description;

    public Video(VideoTitle title, VideoDescription description) {
        this.title = title;
        this.description = description;
    }

    public static Video publish(VideoTitle title, VideoDescription description) {
        Video video = new Video(title, description);

        VideoPublished videoCreated = new VideoPublished(title.value(), description.value());

        video.record(videoCreated);

        return video;
    }
}
