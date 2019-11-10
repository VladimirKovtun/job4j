package ru.job4j.io;

import java.io.File;
import java.util.*;

public class Search {

    List<File> allFiles(String parent) {
        File rootDir = new File(parent);
        List<File> files = new ArrayList<>();
        Queue<File> fileTree = new LinkedList<>();
        Collections.addAll(fileTree, rootDir.listFiles());
        while (!fileTree.isEmpty()) {
            File file = fileTree.poll();
            if (file.isDirectory()) {
                Collections.addAll(fileTree, file.listFiles());
            } else if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }

    List<File> files(String parent, List<String> exts) {
        List<File> extFile = new ArrayList<>();
        for (String ext : exts) {
            for (File file : allFiles(parent)) {
                if (file.getName().endsWith(ext)) {
                    extFile.add(file);
                }
            }
        }
        return extFile;
    }
}