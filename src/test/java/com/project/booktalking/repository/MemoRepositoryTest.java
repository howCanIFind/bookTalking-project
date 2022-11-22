package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;
    @Autowired
    private BookRepository bookRepository;

    // 데이터 준비
    @BeforeEach
    public void 데이터준비() {
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

        String content = "content";
        Memo memo = Memo.builder()
                .content(content)
                .book(book)
                .build();
        memoRepository.save(memo);

    }

    // 저장
    @Test
    public void 메모등록_테스트() {
        // given
        String name = "bookName2";
        String author = "author2";
        String summary = "summary2";
        String companyName = "companyName2";
        Book book = Book.builder()
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();
        bookRepository.save(book);

        String content = "content2";
        Memo memo = Memo.builder()
                .content(content)
                .book(book)
                .build();

        // when
        Memo memoPs = memoRepository.save(memo);

        // then
        assertThat(content).isEqualTo(memoPs.getContent());
        assertThat(book).isEqualTo(memoPs.getBook());
    }

    // 조회
    @Test
    public void 메모목록조회_테스트() {

    }

    // 삭제

    // 수정


}