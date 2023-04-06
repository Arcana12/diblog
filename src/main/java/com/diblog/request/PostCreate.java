package com.diblog.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@ToString
public class PostCreate {

    @NotBlank(message = "타이틀을 입력하세요.")
    private String title;
    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    @Builder
    public PostCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void changeTitle(String title, String content) {
        PostCreate.builder()
                .title(title)
                .content(content)
                .build();
    }

    // 빌더의 장점
    // - 가독성에 좋다. (값 생성에 대한 유연함)
    // - 필요한 값만 받을 수 있다.
    // - 객체의 불변성성
}
