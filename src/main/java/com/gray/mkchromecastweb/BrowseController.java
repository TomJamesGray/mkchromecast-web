package com.gray.mkchromecastweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BrowseController {
    @GetMapping("/list")
    public Map<String, Object> getVideos(){
        return VideoStore.getAllVideos();
    }
}
