package com.hanghae.spring1.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemoRequestDto {
    private String title;
    private String name;
    private String password;
    private String contents;
}