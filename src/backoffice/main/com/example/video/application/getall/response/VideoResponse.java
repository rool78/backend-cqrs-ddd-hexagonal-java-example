package com.example.video.application.getall.response;

public final class VideoResponse {

    private final String title;
    private final String description;

    public VideoResponse(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
