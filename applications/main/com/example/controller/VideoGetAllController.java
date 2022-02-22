package com.example.controller;

import com.example.video.application.getall.GetAllVideos;
import com.example.video.application.getall.response.VideoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public final class VideoGetAllController {

    private final GetAllVideos getAllVideos;

    @Autowired
    public VideoGetAllController(GetAllVideos getAllVideos) {
        this.getAllVideos = getAllVideos;
    }

    @GetMapping("/getVideos")
    public List<VideoResponse> getAllVideos() {
        return getAllVideos.getAll();
    }

}
