package org.example.structural.proxy;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    @Override
    public HashMap<String, Video> populateVideo() {
        connectToServer("http://www.youtube.com");
        return getRandomVideo();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com");
        return getSomeVideo(videoId);
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.println("Connected!" + "\n");
    }

    private HashMap<String, Video> getRandomVideo() {
        System.out.println("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("catsssssssss", new Video("asdadadad", "Catssss.avi"));
        hmap.put("sdaadsadsada", new Video("asdasdsad", "Dog play with ball.mp4"));
        hmap.put("catssssssssd", new Video("adddddddd", "Dancing Video.mpq"));
        hmap.put("asdjkhjkkjhj", new Video("errrrrrrr", "Barcelona vs Real.mov"));
        hmap.put("awdijijllsds", new Video("kkkllllll", "Programming lessons.avi"));

        System.out.print("Done!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        System.out.println("Done!" + "\n");
        return video;
    }
}
