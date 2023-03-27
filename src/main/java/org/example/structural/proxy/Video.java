package org.example.structural.proxy;

public class Video {
    public String id;
    public String title;
    public String data;
    public Video(String videoId, String title) {
        this.id = videoId;
        this.title = title;
        this.data = "Random video.";
    }
}
