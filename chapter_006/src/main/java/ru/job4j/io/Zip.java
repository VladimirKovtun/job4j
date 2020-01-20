package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private final Arg arg;

    public Zip(Arg arg) {
        this.arg = arg;
    }

    public List<File> seekBy(String root, String ext) {
        List<File> files = new Search().allFiles(root);
        List<File> resultList = new LinkedList<>();
        for (File file : files) {
            if (!file.getName().endsWith(ext.substring(1))) {
                resultList.add(file);
            }
        }
        return resultList;
    }

    public void pack(List<File> sources, File target) {
        Path folder = Paths.get(target.getAbsolutePath());
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                Path filePath = Paths.get(file.getAbsolutePath());
                Path relativePath = folder.relativize(filePath);
                zip.putNextEntry(new ZipEntry(relativePath.toString()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
