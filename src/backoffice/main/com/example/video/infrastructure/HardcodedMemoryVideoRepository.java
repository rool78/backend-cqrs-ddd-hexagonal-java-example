package com.example.video.infrastructure;

import com.example.video.domain.VideoRepository;
import com.example.video.domain.Video;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public final class HardcodedMemoryVideoRepository implements VideoRepository {

    private List<Video> videos = new ArrayList<>();

    @Override
    public void save(Video video) {
        System.out.println("Saving video hardcoded in memory");
        this.videos.add(video);
    }

    @Override
    public void update(Video video) {
        for (int i = 0; i < videos.size(); i++) {
          if (this.videos.get(i).equals(video)) {
              this.videos.add(i, video);
          }
        }
    }

    @Override
    public List<Video> getAll() {
        return videos;
    }

}
