package com.tarequlrobin.bookmarker_api.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookmarksDTO {
    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    private boolean isLastPage;
    private boolean isFirstPage;
    private boolean hasNextPage;
    private boolean hasPreviousPage;

    public BookmarksDTO(Page<BookmarkDTO> bookmarksPage) {
        this.setData(bookmarksPage.getContent());
        this.setTotalElements(bookmarksPage.getTotalElements());
        this.setTotalPages(bookmarksPage.getTotalPages());
        this.setCurrentPage(bookmarksPage.getNumber() + 1);
        this.setFirstPage(bookmarksPage.isFirst());
        this.setLastPage(bookmarksPage.isLast());
        this.setHasNextPage(bookmarksPage.hasNext());
        this.setHasPreviousPage(bookmarksPage.hasPrevious());
    }
}
