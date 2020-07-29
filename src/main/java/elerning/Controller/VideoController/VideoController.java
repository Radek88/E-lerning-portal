package elerning.Controller.VideoController;

import elerning.Service.Video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {

    @Autowired
    private VideoService videoService;



    @GetMapping("/videos")
    private String showVideos(Model model){
        model.addAttribute("video", videoService.findById(2));


        return "Videos";
    }
}
