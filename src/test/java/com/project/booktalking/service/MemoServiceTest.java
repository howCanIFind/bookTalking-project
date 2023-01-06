package com.project.booktalking.service;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.repository.BookRepository;
import com.project.booktalking.repository.MemoRepository;
import com.project.booktalking.web.dto.BookReqDto;
import com.project.booktalking.web.dto.MemoReqDto;
import com.project.booktalking.web.dto.MemoRespDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemoServiceTest {

    @InjectMocks
    private MemoService memoService;

    @Mock
    private MemoRepository memoRepository;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    public void 데이터_준비() {
        String name = "bookName";
        String author = "author";
        String summary = "summary";
        String companyName = "companyName";
        Book book = Book.builder()
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();
        bookRepository.save(book);
    }

    // 메모 등록
    @Test
    public void 메모등록_테스트() {
        // given
        BookReqDto bookReqDto = new BookReqDto("name", "author", "summary", "companyName");
        MemoReqDto memoReqDto = new MemoReqDto("content");
        Book book = Book.builder()
                .name("name")
                .companyName("companyName")
                .author("author")
                .summary("summary")
                .build();

        // stub
        Object mock = when(bookRepository.save(any())).thenReturn(bookReqDto.toBook()).getMock();
        System.out.println(mock.getClass().getName());
        when(memoRepository.save(any())).thenReturn(memoReqDto.toEntity(book));

        // when
        MemoRespDto memoRespDto = memoService.saveMemo(1L, memoReqDto);


        // then
        assertThat(memoRespDto.getContent()).isEqualTo(memoReqDto.getContent());
    }

    // 메모 목록 조회

    // 메모 삭제

    // 메모 수정
}