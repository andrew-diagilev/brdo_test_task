package com.brdo.testtask.repository;

import com.brdo.testtask.model.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepository extends JpaRepository<UserComment, Long> {
}