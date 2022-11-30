package com.hanghae.spring1.domain;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class MemoResponseDto {

    private Long id;
    private String title;
    private String name;
    private String password;
    private String contents;

    public MemoResponseDto(Memo memo1){
        this.id = memo1.getId();
        this.title = memo1.getTitle();
        this.name = memo1.getName();
        this.password = memo1.getPassword();
        this.contents = memo1.getContents();
    }
}
