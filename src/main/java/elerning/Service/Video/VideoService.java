package elerning.Service.Video;

import elerning.Model.Video;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface VideoService {

    Video findById(int id);

    List<Video> findAll(Pageable pageable);

    Video findByTitle(String name);

    Video findByDescription(String description);

    void saveVideoToDB(Video video);

    void deleteVideo(int videoId);

}
