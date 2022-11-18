package com.project.booktalking.web.controller;

import com.project.booktalking.service.BookService;
import com.project.booktalking.web.dto.BookReqDto;
import com.project.booktalking.web.dto.BookRespDto;
import com.project.booktalking.web.dto.BookRespListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    // 책 등록
    @PostMapping("/api/book")
    public ResponseEntity<?> saveBook(@RequestBody BookReqDto bookReqDto, BindingResult bindingResult) {
        BookRespDto bookRespDto = bookService.saveBook(bookReqDto);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }
        return new ResponseEntity<>(bookRespDto, HttpStatus.CREATED);
    }

    // 책 한건 보기
    @GetMapping("/api/book/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id) {
        BookRespDto bookRespDto = bookService.getBook(id);
        return new ResponseEntity<>(bookRespDto, HttpStatus.OK);
    }

    // 책 목록 보기
    @GetMapping("/api/book")
    public ResponseEntity<?> getAllBook() {
        BookRespListDto bookRespListDto = bookService.getAllBook();
        return new ResponseEntity<>(bookRespListDto, HttpStatus.OK);
    }

    // 책 삭제하기
    @DeleteMapping("/api/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // 책 수정하기
    @PutMapping("/api/book/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookReqDto bookReqDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }

        BookRespDto bookRespDto = bookService.updateBook(id, bookReqDto);
        return new ResponseEntity<>(bookRespDto, HttpStatus.OK);
    }
}
