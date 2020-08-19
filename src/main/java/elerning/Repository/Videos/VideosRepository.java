package elerning.Repository.Videos;

import elerning.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface VideosRepository extends JpaRepository<Video, Integer> {

    List<Video> findAll();

    Video findByVideoId(int videoId);

    Video findByTitle(String title);

    Video findByDescription(String description);

    void deleteByVideoId(int id);



}
