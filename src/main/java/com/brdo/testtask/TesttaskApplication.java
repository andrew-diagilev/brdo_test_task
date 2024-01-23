package com.brdo.testtask;

import com.brdo.testtask.model.JsonUserComment;
import com.brdo.testtask.model.UserComment;
import com.brdo.testtask.service.UserCommentService;
import com.brdo.testtask.util.UserCommentMapper;
import com.brdo.testtask.util.UserCommentUtil;
import com.brdo.testtask.util.WebClient;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TesttaskApplication {
    private final WebClient webClient;

    private final UserCommentService userCommentService;

    public TesttaskApplication(WebClient webClient, UserCommentService userCommentService) {
        this.webClient = webClient;
        this.userCommentService = userCommentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TesttaskApplication.class, args);
    }
    @PostConstruct
    public void init() {
        List<JsonUserComment> jsonUserComments = webClient.getData();
        UserCommentUtil.capitalizeUsernames(jsonUserComments);
        UserCommentUtil.setCurrentTimeAsUpdatedAt(jsonUserComments);
        List<UserComment> userComments = UserCommentMapper.INSTANCE.jsonCommentsToUserComments(jsonUserComments);
        userCommentService.saveAll(userComments);
    }
}
