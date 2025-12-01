package com.tarequlrobin.bookmark_api.domain;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository repository;
    private final BookmarkMapper mapper;

    @Transactional
    public BookmarksDTO getBookmarks(Integer page) {
        int pageNumber = page < 0 ? 1 : page-1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = repository.findBookmarks(pageable);
        return new BookmarksDTO(bookmarkPage);
    }

    @Transactional
    public BookmarksDTO searchBookmarks(Integer page, String query) {
        int pageNumber = page < 0 ? 1 : page-1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = repository.searchBookmarks(pageable, query);
        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarkDTO createBookmark(@Valid CreateBookmarkRequest createBookmarkRequest) {
        Bookmark bookmark = new Bookmark(null, createBookmarkRequest.getTitle(), createBookmarkRequest.getUrl(), Instant.now());
        Bookmark savedBookmark = repository.save(bookmark);
        return mapper.toDTO(savedBookmark);
    }
}
