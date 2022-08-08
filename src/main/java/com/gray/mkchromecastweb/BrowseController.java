package com.gray.mkchromecastweb;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BrowseController {
    private static final String LIST_BASE_URL = "/list/";
    @GetMapping("/list/**")
    public Map<String, Object> getVideos(HttpServletRequest request){
        String fullPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        System.out.println(Arrays.toString(extractLocalPathFromURL(fullPath)));

        return Collections.emptyMap();
    }

    public String[] extractLocalPathFromURL(String fullPath){
        return fullPath.substring(LIST_BASE_URL.length()).split("//");
    }
}
