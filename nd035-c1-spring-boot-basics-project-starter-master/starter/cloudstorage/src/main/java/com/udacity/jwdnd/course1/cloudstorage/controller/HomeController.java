package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private FileService fileService;
    private NotesService notesService;
    private UserService userService;

    public HomeController(FileService fileService, NotesService notesService, UserService userService) {
        this.fileService = fileService;
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping
    public String homeView() {

        return "home";
    }

}
