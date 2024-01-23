package com.brdo.testtask.model;

import java.util.List;

public class JsonCommentData {
    private List<JsonUserComment> comments;
    private Integer total;
    private Integer skip;
    private Integer limit;

    public List<JsonUserComment> getComments() {
        return comments;
    }

    public void setComments(List<JsonUserComment> comments) {
        this.comments = comments;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}