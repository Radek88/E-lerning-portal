package elerning.Service.Video;

import elerning.Model.Video;

public interface VideoService {

    Video findById(int id);

    Video findByTitle(String name);

    Video findByDescription(String description);



}
