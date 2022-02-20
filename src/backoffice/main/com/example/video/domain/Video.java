package com.example.video.domain;

import com.example.shared.domain.AggregateRoot;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Video{" +
                "title=" + title +
                ", description=" + description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return title.equals(video.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
