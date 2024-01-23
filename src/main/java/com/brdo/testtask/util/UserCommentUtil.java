package com.brdo.testtask.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import com.brdo.testtask.model.JsonUser;
import com.brdo.testtask.model.JsonUserComment;
import org.springframework.util.StringUtils;

public class UserCommentUtil {

    /*private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d-M-yyyy H:m:s");*/

    public static List<JsonUserComment> capitalizeUsernames(List<JsonUserComment> comments) {
        return comments.stream()
                .peek(comment -> Optional.ofNullable(comment.getUser())
                        .map(JsonUser::getUsername)
                        .map(StringUtils::capitalize)
                        .ifPresent(capitalizedName -> comment.getUser().setUsername(capitalizedName)))
                .collect(Collectors.toList());
    }

    public static void setCurrentTime(List<JsonUserComment> comments) {
        comments.forEach(comment -> {
            comment.setUpdatedAt(LocalDateTime.now());
        });
    }

}