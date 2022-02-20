package com.example.controller;

import com.example.video.application.getall.GetAllVideos;
import com.example.video.domain.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class VideoGetAllController {

    private final GetAllVideos getAllVideos;

    @Autowired
    public VideoGetAllController(GetAllVideos getAllVideos) {
        this.getAllVideos = getAllVideos;
    }

    @GetMapping("/getVideos")
    public void getAllVideos() {
        System.out.println("#### getAll videos");
        for (Video video : getAllVideos.getAll()) {
            System.out.println("#### video ->" + video);
        }
    }

}
