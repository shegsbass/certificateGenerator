package dev.shegs.certificateGenerator.controllers;

import com.lowagie.text.*;
import dev.shegs.certificateGenerator.entity.User;
import dev.shegs.certificateGenerator.service.UserService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private PDFService pdfService;



    @GetMapping("/")
    public String fetchHome(){
        return "home";
    }

    @PostMapping("/")
    public String validateEmail (@RequestParam("email") String email, Model model, HttpServletResponse response) throws IOException {
        User user = userService.findUserByEmail(email);
        boolean emailExists = userService.emailExist(email);
        if (emailExists) {
            String fullName = user.getFullName();
            ServletOutputStream outputStream = response.getOutputStream();
            pdfService.PDFGenerator(outputStream, fullName);

        } else {
            model.addAttribute("message", "Error: " + email + " does not exist in our database.");
        }
        return "home";
    }


}
