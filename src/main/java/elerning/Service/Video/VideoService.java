package elerning.Service.Video;

import elerning.Model.Video;

import java.util.List;

public interface VideoService {

    Video findById(int id);

    List<Video> findAll();

    Video findByTitle(String name);

    Video findByDescription(String description);

    void saveVideoToDB(Video video);

    void deleteVideo(int videoId);

}
