package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
