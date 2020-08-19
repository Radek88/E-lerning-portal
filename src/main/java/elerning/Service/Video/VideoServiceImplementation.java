package elerning.Service.Video;

import elerning.Model.Video;
import elerning.Repository.Videos.VideosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VideoServiceImplementation implements VideoService {

    private final int videoDescriptionMaxLength = 509;
    private final int videoTitleMaxLength = 254;

    @Autowired
    private VideosRepository videosRepository;


    @Override
    public Video findById(int videoId) {
        return videosRepository.findByVideoId(videoId);
    }

    @Override
    public List<Video> findAll(Pageable pageable ) {
        return videosRepository.findAll(pageable).getContent();
    }

    @Override
    public Video findByTitle(String title) {
        return videosRepository.findByTitle(title);
    }

    @Override
    public Video findByDescription(String description) {
        return videosRepository.findByDescription(description);
    }

    @Override
    public void saveVideoToDB(Video video) {
        if (video.getDescription().length() > videoDescriptionMaxLength) {
            video.setDescription(video.getDescription().substring(0, videoDescriptionMaxLength));
        }
        if (video.getTitle().length() > videoTitleMaxLength) {
            video.setTitle(video.getTitle().substring(0, videoTitleMaxLength));
        }
        videosRepository.saveAndFlush(video);
    }

    @Override
    public void deleteVideo(int videoId){
        videosRepository.deleteByVideoId(videoId);
    }
}
