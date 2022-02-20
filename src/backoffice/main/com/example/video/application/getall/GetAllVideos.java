package com.example.video.application.getall;

import com.example.video.domain.Video;
import com.example.video.domain.VideoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class GetAllVideos {

    private final VideoRepository repository;

    public GetAllVideos(VideoRepository repository) {
        this.repository = repository;
    }

    public List<Video> getAll() {
        return this.repository.getAll();
    }

}
