package com.example.video.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoRepository {

    void save(Video video);

    void update(Video video);

    List<Video> getAll();

}
