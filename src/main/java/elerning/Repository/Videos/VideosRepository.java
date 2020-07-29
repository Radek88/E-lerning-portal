package elerning.Repository.Videos;

import elerning.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends JpaRepository<Video, Integer> {

    Video findByVideoId(int videoId);

    Video findByTitle(String title);

    Video findByDescription(String description);




}
