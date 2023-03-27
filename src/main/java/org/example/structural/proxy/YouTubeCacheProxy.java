package org.example.structural.proxy;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib{
    private ThirdPartyYouTubeLib youTubeService;
    private HashMap<String, Video> cachePopulator = new HashMap<>();
    private HashMap<String, Video> cacheAll = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youTubeService = new ThirdPartyYouTubeClass();
    }
    @Override
    public HashMap<String, Video> populateVideo() {
        if (cachePopulator.isEmpty()) {
            cachePopulator = youTubeService.populateVideo();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopulator;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeService.getVideo(videoId);
            cacheAll.put("videoId", video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopulator.clear();
        cacheAll.clear();
    }
}
