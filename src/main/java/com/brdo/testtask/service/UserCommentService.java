package com.brdo.testtask.service;

import com.brdo.testtask.model.UserComment;
import com.brdo.testtask.repository.UserCommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentService {
    private UserCommentRepository repository;

    public UserCommentService(UserCommentRepository repository) {
        this.repository = repository;
    }

    public void saveAll(List<UserComment> entities) {
        repository.saveAll(entities);
    }

    public List<UserComment> getAll() {
        return repository.findAll();
    }
}
