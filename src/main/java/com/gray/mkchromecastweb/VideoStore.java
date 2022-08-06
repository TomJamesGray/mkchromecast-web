package com.gray.mkchromecastweb;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VideoStore {
    private static final String FILE_LOCATION = "/home/tom/Desktop";

    public static Map<String, Object> getAllVideos(){
        File f = new File(FILE_LOCATION);
        String[] fileNames = f.list();
        return Map.of("/",fileNames);
    }
}
