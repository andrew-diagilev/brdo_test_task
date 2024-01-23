package com.brdo.testtask.util;

import com.brdo.testtask.model.JsonCommentData;
import com.brdo.testtask.model.JsonUserComment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class WebClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "https://dummyjson.com/comments";

    public List<JsonUserComment> getData() {
        JsonCommentData commentData = restTemplate.getForObject(URL, JsonCommentData.class);
        return commentData.getComments();
    }
}
