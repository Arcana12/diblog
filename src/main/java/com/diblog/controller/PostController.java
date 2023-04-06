package com.diblog.controller;

// SSR -> jsp,  thymeleaf, mustache, freemarker
// -> html rendering
// SPA -> vue, react
//  -> jaavascript + <-> API (JSON)
// vue -> vue + SSR = nuxt
// react -> react + SSR = next

import com.diblog.domain.Post;
import com.diblog.request.PostCreate;
import com.diblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public void get(@RequestBody @Valid PostCreate request){
        // Case1. 저장한 데이터 Entity -> response로 응답하기
        // Case2. 저장한 데이터의 primary_id -> response로 응답하기
        //          Client에서는 수신한 id를 글 조회 API를 통해서 데이터를 수신받음
        // Case3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 context를 잘 관리함
        postService.write(request);
    }

}
