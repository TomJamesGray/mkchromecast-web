package com.gray.mkchromecastweb;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VideoStore {
    private static final String FILE_LOCATION = "/home/tom/Videos";

    public static String[] getVideosAndDirectories(String path){
        File f = new File(FILE_LOCATION);
        String[] fileNames = f.list();
        if (fileNames == null){
            return new String[1];
        }
        else{
            return fileNames;
        }
    }
}
