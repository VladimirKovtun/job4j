package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZipTest {
    private String root = System.getProperty("java.io.tmpdir") + "/main/";

    @Before
    public void prepareToTest() {
        File parentDir = new File(root);
        if (parentDir.exists()) {
            deleteFile(parentDir);
        }
        List<File> listFolder;
        List<File> listFiles;
        listFolder = new ArrayList<>();
        File subDir1 = new File(parentDir.getAbsolutePath() + "/sub1");
        File subDir2 = new File(subDir1.getAbsolutePath() + "/sub2");
        File subDir3 = new File(subDir2.getAbsolutePath() + "/sub3");
        File subDir4 = new File(parentDir.getAbsolutePath() + "/sub4");
        listFolder.add(parentDir);
        listFolder.add(subDir1);
        listFolder.add(subDir2);
        listFolder.add(subDir3);
        listFolder.add(subDir4);
        listFolder.forEach(file -> {
            try {
                if (!file.mkdir()) {
                    throw new FileNotFoundException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        listFiles = new ArrayList<>(Arrays.asList(new File(parentDir, "textFile1.txt"),
                new File(parentDir, "docFile1.doc"),
                new File(subDir1, "textFile2.txt"),
                new File(subDir2, "textFile3.txt"),
                new File(subDir2, "picFile1.jpg"),
                new File(subDir3, "docFile2.doc"),
                new File(subDir4, "textFile4.txt")));
        listFiles.forEach(file -> {
            try {
                if (!file.createNewFile()) {
                    throw new FileNotFoundException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void whenUnzip3Files() throws IOException {
        String property = System.getProperty("java.io.tmpdir");
        String fixProp = property + "/main/";
        Arg arg = new Arg("java -jar pack.jar -d C:/Users/User/AppData/Local/Temp/main"
                + " -e *.txt -o example.zip");
        Zip zip = new Zip(arg);
        List<File> files = zip.seekBy(fixProp, arg.exclude());
        zip.pack(files, new File(fixProp +  arg.output()));

        List<String> list = new LinkedList<>();
        ZipFile zipFile = new ZipFile(fixProp + arg.output());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String[] zipArray = entries.nextElement().getName().split("\\\\");
            list.add(zipArray[zipArray.length - 1]);
        }
        List<String> collect = files.stream().map(File::getName).collect(Collectors.toList());
        File newFile = new File(fixProp + arg.output());
        assertThat(newFile.exists(), is(true));
        assertThat(collect.toString(), is(list.toString()));
    }

    private void deleteFile(File path) {
        if (path.isDirectory()) {
            for (File file : path.listFiles()) {
                if (file.isDirectory()) {
                    deleteFile(file);
                } else {
                    file.delete();
                }
            }
        }
        path.delete();
    }

}