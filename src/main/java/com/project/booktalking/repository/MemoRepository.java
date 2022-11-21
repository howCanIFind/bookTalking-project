package com.project.booktalking.repository;

import com.project.booktalking.domain.book.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
