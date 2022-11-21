package com.project.booktalking.service;

import com.project.booktalking.domain.book.Book;
import com.project.booktalking.domain.book.Memo;
import com.project.booktalking.repository.BookRepository;
import com.project.booktalking.repository.MemoRepository;
import com.project.booktalking.web.dto.MemoListRespDto;
import com.project.booktalking.web.dto.MemoReqDto;
import com.project.booktalking.web.dto.MemoRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final BookRepository bookRepository;
    private final MemoRepository memoRepository;

    // 메모 저장하기
    public MemoRespDto saveMemo(Long id, MemoReqDto memoReqDto) {

        Optional<Book> bookOp = bookRepository.findById(id);

        if (bookOp.isPresent()) {
            Book book = bookOp.get();
            Memo memo = memoReqDto.toEntity(book);
            Memo memoPs = memoRepository.save(memo);
            return memoPs.toRespDto();
        } else {
            throw new RuntimeException("해당 책이 존재하지 않습니다.");
        }
    }

    // 메모 모두 조회하기
    public MemoListRespDto getAllMemo(Long id) {
        Optional<Book> bookOp = bookRepository.findById(id);

        if (bookOp.isPresent()) {
            Book book = bookOp.get();
            List<MemoRespDto> memoRespDtoList = memoRepository.findAllByBook(book).stream()
                    .map(Memo::toRespDto)
                    .collect(Collectors.toList());

            return MemoListRespDto.builder()
                    .memoList(memoRespDtoList)
                    .build();
        } else {
            throw new RuntimeException("해당 책이 존재하지 않습니다.");
        }
    }

    // 메모 삭제하기

    // 메모 수정하기
}
