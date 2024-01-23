package com.brdo.testtask.util;

import com.brdo.testtask.model.JsonCommentData;
import com.brdo.testtask.model.JsonUserComment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DataFetcher {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${comments.url}")
    private String url;

    public List<JsonUserComment> fetchData() {
        JsonCommentData commentData = restTemplate.getForObject(url, JsonCommentData.class);
        return commentData.getComments();
    }
}
