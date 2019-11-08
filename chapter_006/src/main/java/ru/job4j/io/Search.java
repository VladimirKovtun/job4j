package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {

    List<File> files(String parent, List<String> exts) {
        File rootDir = new File(parent);
        List<File> files = new ArrayList<>();
        Queue<File> fileTree = new LinkedList<>();
        Collections.addAll(fileTree, rootDir.listFiles());
        while (!fileTree.isEmpty()) {
            File file = fileTree.poll();
            if (file.isDirectory()) {
                Collections.addAll(fileTree, file.listFiles());
            } else if (file.isFile()) {
                String fileName = file.getName();
                for (String ext : exts) {
                    if (fileName.endsWith(ext)) {
                        files.add(file);
                    }
                }
            }
        }
        return files;
    }
}
