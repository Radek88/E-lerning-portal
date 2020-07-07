package elerning.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Course1Controller {
    @RequestMapping({"/course1"})
    private String about(){
        return "course1";
    }


}
