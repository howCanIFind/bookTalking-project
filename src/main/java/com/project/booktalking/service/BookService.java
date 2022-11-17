package com.project.booktalking.service;

import com.project.booktalking.repository.BookRepository;
import com.project.booktalking.web.dto.NovelReqDto;
import com.project.booktalking.web.dto.NovelRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // Novel
    public NovelRespDto saveNovel(NovelReqDto novelReqDto) {

    }
}
