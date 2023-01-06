package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;
import com.project.booktalking.web.dto.MemoReqDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
class MemoRepositoryTest {
//
//    @Autowired
//    private MemoRepository memoRepository;
//    @Autowired
//    private BookRepository bookRepository;
//
//    // 데이터 준비
//    @BeforeEach
//    public void 데이터준비() {
//        String name = "bookName";
//        String author = "author";
//        String summary = "summary";
//        String companyName = "companyName";
//        Book book = Book.builder()
//                .name(name)
//                .author(author)
//                .summary(summary)
//                .companyName(companyName)
//                .build();
//        bookRepository.save(book);
//
//        String content = "content";
//        Memo memo = Memo.builder()
//                .content(content)
//                .book(book)
//                .build();
//        memoRepository.save(memo);
//
//    }
//
//    // 저장
//    @Test
//    public void 메모등록_테스트() {
//        // given
//        String name = "bookName2";
//        String author = "author2";
//        String summary = "summary2";
//        String companyName = "companyName2";
//        Book book = Book.builder()
//                .name(name)
//                .author(author)
//                .summary(summary)
//                .companyName(companyName)
//                .build();
//        bookRepository.save(book);
//
//        String content = "content2";
//        Memo memo = Memo.builder()
//                .content(content)
//                .book(book)
//                .build();
//
//        // when
//        Memo memoPs = memoRepository.save(memo);
//
//        // then
//        assertThat(content).isEqualTo(memoPs.getContent());
//        assertThat(book).isEqualTo(memoPs.getBook());
//    }
//
//    // 조회
//    @Test
//    public void 메모조회_테스트() {
//        // given
//        Long memoId = 2L;
//
//        String content = "content";
//
//        String name = "bookName";
//        String author = "author";
//        String summary = "summary";
//        String companyName = "companyName";
//
//        // when
//        Memo memoPs = memoRepository.findById(memoId).get();
//
//        // then
//        assertThat(content).isEqualTo(memoPs.getContent());
//        assertThat(name).isEqualTo(memoPs.getBook().getName());
//        assertThat(author).isEqualTo(memoPs.getBook().getAuthor());
//        assertThat(summary).isEqualTo(memoPs.getBook().getSummary());
//        assertThat(companyName).isEqualTo(memoPs.getBook().getCompanyName());
//    }
//
//
//    @Test
//    public void 메모목록조회byBook_테스트() {
//        // given
//        String content = "content";
//
//        String name = "bookName";
//        String author = "author";
//        String summary = "summary";
//        String companyName = "companyName";
//
//        Book book = bookRepository.findAll().get(0);
//
//        // when
//        List<Memo> memoList = memoRepository.findAllByBook(book);
//
//        // then
//        assertThat(content).isEqualTo(memoList.get(0).getContent());
//        assertThat(name).isEqualTo(memoList.get(0).getBook().getName());
//        assertThat(author).isEqualTo(memoList.get(0).getBook().getAuthor());
//        assertThat(summary).isEqualTo(memoList.get(0).getBook().getSummary());
//        assertThat(companyName).isEqualTo(memoList.get(0).getBook().getCompanyName());
//    }
//
//    // 삭제
//    @Test
//    public void 메모삭제_테스트() {
//        // given
//        Long id = memoRepository.findAll().get(0).getId();
//
//        // when
//        memoRepository.deleteById(id);
//
//        // then
//        assertFalse(bookRepository.findById(id).isPresent());
//    }
//
//    // 수정
//    @Test
//    public void 메모수정_테스트() {
//        // given
//        Long memoId = memoRepository.findAll().get(0).getId();
//
//        String content = "content 수정";
//        MemoReqDto memoReqDto = new MemoReqDto(content);
//
//        // when
//        Memo memo = memoRepository.findById(memoId).get();
//        memo.update(memoReqDto);
//
//        // then
//        assertThat(content).isEqualTo(memo.getContent());
//
//    }
}