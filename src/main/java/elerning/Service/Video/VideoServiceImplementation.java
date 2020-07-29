package elerning.Service.Video;

import elerning.Model.Video;
import elerning.Repository.Videos.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImplementation implements VideoService {

    @Autowired
    private VideosRepository videosRepository;


    @Override
    public Video findById(int videoId) {
        return videosRepository.findByVideoId(videoId);
    }

    @Override
    public Video findByTitle(String title) {
        return videosRepository.findByTitle(title);
    }

    @Override
    public Video findByDescription(String description) {
        return videosRepository.findByDescription(description);
    }
}
