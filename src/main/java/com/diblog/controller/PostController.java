package com.diblog.controller;

// SSR -> jsp,  thymeleaf, mustache, freemarker
// -> html rendering
// SPA -> vue, react
//  -> jaavascript + <-> API (JSON)
// vue -> vue + SSR = nuxt
// react -> react + SSR = next

import com.diblog.exception.InvalidRequest;
import com.diblog.request.PostCreate;
import com.diblog.request.PostEdit;
import com.diblog.request.PostSearch;
import com.diblog.response.PostResponse;
import com.diblog.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request){
        // Case1. 저장한 데이터 Entity -> response로 응답하기
        // Case2. 저장한 데이터의 primary_id -> response로 응답하기
        //          Client에서는 수신한 id를 글 조회 API를 통해서 데이터를 수신받음
        // Case3. 응답 필요 없음 -> 클라이언트에서 모든 POST(글) 데이터 context를 잘 관리함
        request.validate();
        postService.write(request);

    }

    // 단건 조회
    @GetMapping("/posts/{postId}")
    public PostResponse get(@PathVariable(name = "postId") Long id){
        return postService.get(id);
    }

    // 여러개의 글을 조회
    @GetMapping("/posts")
    public PostSearch getList(@ModelAttribute PostSearch postSearch){
        return postService.getList(postSearch);
    }

    @PatchMapping("/posts/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEdit postEdit){
        postService.edit(postId, postEdit);
    }

    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable Long postId){
        postService.delete(postId);
    }

}
