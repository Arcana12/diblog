package com.diblog.controller;

// SSR -> jsp,  thymeleaf, mustache, freemarker
// -> html rendering
// SPA -> vue, react
//  -> jaavascript + <-> API (JSON)
// vue -> vue + SSR = nuxt
// react -> react + SSR = next

import com.diblog.request.PostCreate;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PostController {

    @GetMapping("/posts")
    public Map<String, String> get(@RequestBody @Valid PostCreate params){
        log.info("params={}", params.toString());


        return Map.of();
    }

}
