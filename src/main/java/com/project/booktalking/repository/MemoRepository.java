package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByBook(Book book);
}
