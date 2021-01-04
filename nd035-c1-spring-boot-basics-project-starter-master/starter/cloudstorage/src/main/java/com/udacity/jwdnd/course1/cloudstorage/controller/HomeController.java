package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.FilesService;
import com.udacity.jwdnd.course1.cloudstorage.services.NotesService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private FilesService filesService;
    private NotesService notesService;
    private UserService userService;

    public HomeController(FilesService filesService, NotesService notesService, UserService userService) {
        this.filesService = filesService;
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping(value={"/","/home"})
    public String homeView(Authentication authentication, Model model) throws Exception {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if (authentication instanceof User){
            String username = ((User)authentication).getUsername();
            User user = userService.getUser(username);
            model.addAttribute("files", fileService.getFiles(user.getUserId()));
            model.addAttribute("notes", notesService.getNotes(user.getUserId()));
            model.addAttribute("credentials", credentialService.getCredentails(user.getUserId()));
        } else {

        }
        return "home";
    }

}
