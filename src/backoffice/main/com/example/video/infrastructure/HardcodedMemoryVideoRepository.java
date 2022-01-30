package com.example.video.infrastructure;

import com.example.video.domain.VideoRepository;
import com.example.video.domain.Video;

import java.util.ArrayList;
import java.util.List;

public class HardcodedMemoryVideoRepository implements VideoRepository {

    private List<Video> videos = new ArrayList<>();

    @Override
    public void save(Video video) {
        System.out.println("Saving video hardcoded in memory");
        this.videos.add(video);
    }
}
