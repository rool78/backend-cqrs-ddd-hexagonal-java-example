package com.example.video.application.getall;

import com.example.video.application.getall.response.VideoResponse;
import com.example.video.domain.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class GetAllVideos {

    private final VideoRepository repository;

    @Autowired
    public GetAllVideos(@Qualifier("hardcodedMemoryVideoRepository")
                                    VideoRepository repository) {
        this.repository = repository;
    }

    public List<VideoResponse> getAll() {
        List<VideoResponse> videoResponseList = new ArrayList<>();
        repository.getAll().forEach((video -> videoResponseList.add(new VideoResponse(
                video.getTitle().value(),
                video.getDescription().value()))));
        return videoResponseList;
    }
}
