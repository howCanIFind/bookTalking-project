package com.project.booktalking.service;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.repository.BookRepository;
import com.project.booktalking.web.dto.BookReqDto;
import com.project.booktalking.web.dto.BookRespDto;
import com.project.booktalking.web.dto.BookRespListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 저장
    @Transactional
    public BookRespDto saveBook(BookReqDto bookReqDto) {
        Book book = bookReqDto.toBook();
        bookRepository.save(book);

        return book.toDto();
    }

    // 수정
    @Transactional
    public BookRespDto updateBook(Long id, BookReqDto bookReqDto) {
        Optional<Book> bookOp = bookRepository.findById(id);
        if (bookOp.isPresent()) {
            Book book = bookOp.get();
            book.update(bookReqDto);
            return book.toDto();
        } else {
            throw new RuntimeException("해당 책이 존재하지 않습니다.");
        }
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    // 조회
    public BookRespDto getBook(Long id) {
        Optional<Book> bookOp = bookRepository.findById(id);

        if (bookOp == null) {
            throw new RuntimeException("해당 책이 존재하지 않습니다.");
        }

        return bookOp.get().toDto();
    }

    // 모두 조회
    // 페이징 필요
    public BookRespListDto getAllBook() {
        List<BookRespDto> bookRespDtos = bookRepository.findAll().stream()
                .map(Book::toDto)
                .collect(Collectors.toList());
        return BookRespListDto.builder().bookRespDtoList(bookRespDtos).build();
    }

}
