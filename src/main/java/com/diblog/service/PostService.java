package com.diblog.service;

import com.diblog.domain.Post;
import com.diblog.domain.PostEditor;
import com.diblog.exception.PostNotFound;
import com.diblog.repository.PostRepository;
import com.diblog.request.PostCreate;
import com.diblog.request.PostEdit;
import com.diblog.request.PostSearch;
import com.diblog.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(PostCreate postCreate){
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
        return postRepository.save(post);
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public List<PostResponse> getList(PostSearch postSearch){
        return postRepository.getList(postSearch).stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());

    }

    @Transactional
    public void edit(Long id, PostEdit postEdit){
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        PostEditor.PostEditorBuilder editorBuilder = post.toEditor();

        PostEditor postEditor = editorBuilder.title(postEdit.getTitle())
                .content(postEdit.getContent())
                .build();

        post.edit(postEditor);

    }

    public void delete(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFound::new);

        postRepository.delete(post);
    }
}
