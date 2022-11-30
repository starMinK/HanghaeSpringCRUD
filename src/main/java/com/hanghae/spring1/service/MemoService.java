package com.hanghae.spring1.service;

import com.hanghae.spring1.domain.*;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {
//    @PathVariable
//    @RequestBody
//    Optional

    private final MemoRepository memoRepository;

    //Create
    @Transactional
    public MemoResponseDto save(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return new MemoResponseDto(memo);
    }


    //Update
    @Transactional
    public MemoResponseDto update(Long id, MemoRequestDto requestDto) {
        Memo memo1 = memoRepository.findByIdAndPassword(id, requestDto.getPassword()).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.")
        );

        memo1.update(requestDto);
        MemoResponseDto responseDto = new MemoResponseDto(memo1);
        return responseDto;
    }

    //ReadAll
    @Transactional
    public List<MemoResponseDto> readAll() {
        List<Memo> all = memoRepository.findAll();

        List<MemoResponseDto> memoResponseDtoList = new ArrayList<>();

        for (Memo memos : all) {
            MemoResponseDto dto = MemoResponseDto.builder()
                    .id(memos.getId())
                    .title(memos.getTitle())
                    .name(memos.getName())
                    .password(memos.getPassword())
                    .contents(memos.getContents())
                    .build();
            memoResponseDtoList.add(dto);
        }
        return memoResponseDtoList;
    }


    //Read
    @Transactional
    public MemoResponseDto read(Long id) {
        Optional<Memo> a = memoRepository.findById(id);
        Memo v = a.get();
        MemoResponseDto responseDto = new MemoResponseDto(v);
        return responseDto;
    }

    @Transactional
    public Long delete(Long id, MemoPasswordRequestDto passwordRequestDto) {
        Memo memo1 = memoRepository.findByIdAndPassword(id, passwordRequestDto.getPassword()).orElseThrow(
                () -> new IllegalIdentifierException("해당 아이디가 존재하지 않거나 비밀번호가 일치하지 않습니다.")
        );

        memoRepository.deleteById(id);
        return id;
    }
}
