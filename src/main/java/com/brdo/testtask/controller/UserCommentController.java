package com.brdo.testtask.controller;

import com.brdo.testtask.model.UserComment;
import com.brdo.testtask.service.UserCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserCommentController {

    private UserCommentService userCommentService;

    public UserCommentController(UserCommentService userCommentService) {
        this.userCommentService = userCommentService;
    }

    @GetMapping("/users")
    public String showUserComments(Model model) {
        List<UserComment> comments = userCommentService.getAll();
        model.addAttribute("comments", comments);
        return "users";
    }
}
