package elerning.Controller.VideoController;

import elerning.Model.Categories;
import elerning.Model.Video;
import elerning.Service.Quiz.CategoriesService;
import elerning.Service.Video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/list")
    private String showVideos(Model model) {
        model.addAttribute("videos", videoService.findAll());
        return "videoList";
    }

    @GetMapping("/addVideo")
    private String addVideo(Model model) {
        Video video = new Video();
        List<Categories> categoriesList = categoriesService.findAll();
        model.addAttribute("video", video);
        model.addAttribute("categoriesList", categoriesList);
        return "videoAdd";
    }

    @PostMapping("/saveVideo")
    private String saveVideo(@ModelAttribute("video") Video video) {
        videoService.saveVideoToDB(video);
        return "redirect:/video/list";
    }

    @RequestMapping("/deleteVideo/{id}")
    private String deleteVideo(@PathVariable (name="id") int videoId) {
        videoService.deleteVideo(videoId);
        return "redirect:/video/list";
    }


}
