package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.FilesService;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
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
    private CredentialService credentialService;

    public HomeController(FilesService filesService, NotesService notesService, UserService userService) {
        this.filesService = filesService;
        this.notesService = notesService;
        this.userService = userService;
    }

    @GetMapping(value={"/","/home"})
    public String homeView(Authentication authentication, Model model) throws Exception {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String currentPrincipalName = authentication.getName();
        if (principal instanceof User){
            String username = ((User)principal).getUsername();
            User user = userService.getUser(username);
            model.addAttribute("files", filesService.getFiles(user.getUserid()));
            model.addAttribute("notes", notesService.getNotes(user.getUserid()));
            model.addAttribute("credentials", credentialService.getCredentials(user.getUserid()));
        } else {
            String username = principal.toString();
            User user = userService.getUser(username);
            if (user==null) {
                return "login";
            } else if (filesService.getFiles(user.getUserid()) != null {
                model.addAttribute("files", filesService.getFiles(user.getUserid()));
                model.addAttribute("notes", notesService.getNotes(user.getUserid()));
                model.addAttribute("credentials", credentialService.getCredentials(user.getUserid()));
            }
            model.addAttribute("user", user);
        }
        return "home";
    }
}
