package org.example.structural.proxy;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> populateVideo();
    Video getVideo(String videoId);
}
