package com.gray.mkchromecastweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class BrowseController {
    private static final Logger LOGGER = Logger.getLogger( BrowseController.class.getName() );
    static final String LIST_BASE_URL = "/api/list/";

    @Autowired
    private VideoStore videoStore;

    @GetMapping(LIST_BASE_URL + "**")
    @CrossOrigin(origins = "http://localhost:3000")
    public String[] getVideos(HttpServletRequest request) {
        System.out.println("REQUEST");
        String fullPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String [] fileList = getFilesFromPath(fullPath);

        if (fileList == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Path not found"
            );
        }

        return fileList;
    }

    public String[] getFilesFromPath(String fullPath){
        return videoStore.getVideosAndDirectories(extractLocalPathFromURL(fullPath));
    }

    public static String[] extractLocalPathFromURL(String fullPath){
        return fullPath.substring(LIST_BASE_URL.length()).split("/");
    }
}
