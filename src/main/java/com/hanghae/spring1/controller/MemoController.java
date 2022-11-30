package com.hanghae.spring1.controller;

import com.hanghae.spring1.domain.*;
import com.hanghae.spring1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoService memoService;

    //메모 생성
    @PostMapping("/api/post")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.save(requestDto);
    }

    //전부 조회
    @GetMapping("/api/posts")
    public List<MemoResponseDto> getAllMemo() {
        return memoService.readAll();
    }

    //선택한 아이디 하나만 조회
    @GetMapping("/api/post/{id}")
    public MemoResponseDto getMemo(@PathVariable Long id) {
        return memoService.read(id);
    }

    @PutMapping("/api/post/{id}")
    public MemoResponseDto updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoPasswordRequestDto passwordRequestDto) {
        return memoService.delete(id, passwordRequestDto);
    }
}
