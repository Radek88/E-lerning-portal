package elerning.Controller.QuizController;

import elerning.Service.Email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contact")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("showForm")
    private String getContactPage(){
        return "contact";

    }

    @PostMapping("/sendEmail")
    private String sendEmail(@RequestParam("name") String senderName,
                             @RequestParam("email") String senderEmail,
                             @RequestParam("subject") String subject,
                             @RequestParam("message") String message) {
        emailService.sendEmail(senderName,senderEmail,subject,message );
        return "home";
    }


}
