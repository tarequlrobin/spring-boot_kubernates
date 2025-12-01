package com.tarequlrobin.bookmark_api.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateBookmarkRequest {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "URL cannot be empty")
    private String url;
}
