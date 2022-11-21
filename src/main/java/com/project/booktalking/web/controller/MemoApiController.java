package com.project.booktalking.web.controller;

import com.project.booktalking.service.MemoService;
import com.project.booktalking.web.dto.MemoListRespDto;
import com.project.booktalking.web.dto.MemoReqDto;
import com.project.booktalking.web.dto.MemoRespDto;
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
public class MemoApiController {

    private final MemoService memoService;

    // 생성
    @PostMapping("/api/memo/{id}")
    public ResponseEntity<?> saveMemo(@PathVariable Long id, @RequestBody MemoReqDto memoReqDto, BindingResult bindingResult) {
        MemoRespDto memoRespDto = memoService.saveMemo(id, memoReqDto);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }
        return new ResponseEntity<>(memoRespDto, HttpStatus.CREATED);
    }

    // 조회
    @GetMapping("/api/memo/{id}")
    public ResponseEntity<?> getAllMemo(@PathVariable Long id) {
        MemoListRespDto memoListRespDto = memoService.getAllMemo(id);
        return new ResponseEntity<>(memoListRespDto, HttpStatus.OK);
    }

    // 삭제
    @DeleteMapping("/api/memo/{id}")
    public ResponseEntity<?> deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // 수정
    @PutMapping("/api/memo/{id}")
    public ResponseEntity<?> updateMemo(@PathVariable Long id, MemoReqDto memoReqDto, BindingResult bindingResult) {
        MemoRespDto memoRespDto = memoService.updateMemo(id, memoReqDto);

        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fe : bindingResult.getFieldErrors()) {
                errorMap.put(fe.getField(), fe.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }

        return new ResponseEntity<>(memoRespDto, HttpStatus.OK);
    }



}
