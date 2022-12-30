package com.example.tiktokclone;

public class Reel {
    String videoUrl;
    String name;
    int profileImage;

    public Reel(String videoUrl, String name, int profileImage) {
        this.videoUrl = videoUrl;
        this.name = name;
        this.profileImage = profileImage;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }
}
