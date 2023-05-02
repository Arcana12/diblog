package com.diblog.request;

import com.diblog.response.PostResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PostSearch {

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 5;

    private Long count;

    private List<PostResponse> postResponseList;

    public long getOffset(){
        return (long) (Math.max(1 , page) - 1) * size;
    }

}
