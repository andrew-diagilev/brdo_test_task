package com.brdo.testtask.util;

import com.brdo.testtask.model.JsonUserComment;
import com.brdo.testtask.model.UserComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserCommentMapper {

    UserCommentMapper INSTANCE = Mappers.getMapper(UserCommentMapper.class);

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "updatedAt", target = "updatedAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    UserComment jsonCommentToUserComment(JsonUserComment jsonComment);
    List<UserComment> jsonCommentsToUserComments(List<JsonUserComment> jsonComments);
}