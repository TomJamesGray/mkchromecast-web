package com.gray.mkchromecastweb;

import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class VideoStore {
    private static final String FILE_LOCATION = "/home/tom/Videos";

    public String[] getVideosAndDirectories(String[] directories){
        Path path = resolvePathFromArray(directories);
        File file = path.toFile();
        return file.list();
    }

    public static Path resolvePathFromArray(String[] directories){
        Path path = Paths.get(FILE_LOCATION);
        if (directories != null) {
            for (String dir : directories) {
                path = path.resolve(dir);
            }
        }
        return path;
    }
}
