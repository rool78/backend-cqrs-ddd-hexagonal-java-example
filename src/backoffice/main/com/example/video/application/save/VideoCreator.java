package com.example.video.application.save;

import com.example.shared.domain.EventBus;
import com.example.video.domain.Video;
import com.example.video.domain.VideoDescription;
import com.example.video.domain.VideoRepository;
import com.example.video.domain.VideoTitle;

public class VideoCreator {

    private final VideoRepository videoRepository;

    public VideoCreator(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public void create(VideoTitle title, VideoDescription description) {
        videoRepository.save(new Video(title, description));
    }
}
