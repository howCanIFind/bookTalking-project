package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

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
    }

    // 책 등록
    @Test
    public void 책등록_테스트() {
        // given
        String name = "이펙티브 자바";
        String author = "조슈아 블로크";
        String summary = "이펙티브 자바 요약";
        String companyName = "프로그래밍 인사이트";
        Book book = Book.builder()
                .name(name)
                .author(author)
                .summary(summary)
                .companyName(companyName)
                .build();

        // when
        Book bookPS = bookRepository.save(book);

        // then
        assertThat(name).isEqualTo(bookPS.getName());
        assertThat(author).isEqualTo(bookPS.getAuthor());
        assertThat(summary).isEqualTo(bookPS.getSummary());
        assertThat(companyName).isEqualTo(bookPS.getCompanyName());
    }

    // 책 한건 보기
//    @Sql("classpath:db/tableInit.sql")
    @Test
    public void 책한건보기_테스트() {
        // given
        Long id = 1L;

        String name = "bookName";
        String author = "author";
        String summary = "summary";
        String companyName = "companyName";
        System.out.println("f : " + bookRepository.findById(1L).isPresent());

        // when
        Book book = bookRepository.findById(1L).get();


        // then
        assertThat(name).isEqualTo(book.getName());
        assertThat(author).isEqualTo(book.getAuthor());
        assertThat(summary).isEqualTo(book.getSummary());
        assertThat(companyName).isEqualTo(book.getCompanyName());
    }

    // 책 목록 보기
    @Test
    public void 책목록보기_테스트() {
        // given
        String name = "bookName";
        String author = "author";
        String summary = "summary";
        String companyName = "companyName";

        // when
        List<Book> bookList = bookRepository.findAll();

        // then
        assertThat(name).isEqualTo(bookList.get(0).getName());
        assertThat(author).isEqualTo(bookList.get(0).getAuthor());
        assertThat(summary).isEqualTo(bookList.get(0).getSummary());
        assertThat(companyName).isEqualTo(bookList.get(0).getCompanyName());

    }

//    // 책 수정
//    @Test
//    public void 책수정_테스트() {
//        // given
//        Long id = 1L;
//
//        String name = "bookName 수정";
//        String author = "author 수정";
//        String summary = "summary 수정";
//        String companyName = "companyName 수정";
//        Book book = bookRepository.findById(id).get();
//
//        // when
//        book.update();
//
//        // then
//    }

    // 책 삭제
    @Sql("classpath:db/tableInit.sql")
    @Test
    public void 책삭제_테스트() {
        // given
        Long id = 1L;

        // when
        bookRepository.deleteById(id);

        // then
        assertFalse(bookRepository.findById(id).isPresent());
    }

}