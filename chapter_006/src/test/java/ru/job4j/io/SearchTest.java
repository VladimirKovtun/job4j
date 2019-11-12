package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {
    private String root = System.getProperty("java.io.tmpdir") + "main";

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
    public void whenFindTxtFiles() {
        List<File> files = new Search().files(root, new ArrayList<>(Arrays.asList(".txt")));
        Iterator<File> iterator = files.iterator();
        assertThat(iterator.next().getName(), is("textFile1.txt"));
        assertThat(iterator.next().getName(), is("textFile2.txt"));
        assertThat(iterator.next().getName(), is("textFile4.txt"));
        assertThat(iterator.next().getName(), is("textFile3.txt"));
    }

    @Test
    public void whenFindDocAndJpgFiles() {
        List<File> files = new Search().files(root, new ArrayList<>(Arrays.asList(".doc", ".jpg")));
        Iterator<File> iterator = files.iterator();
        assertThat(iterator.next().getName(), is("docFile1.doc"));
        assertThat(iterator.next().getName(), is("docFile2.doc"));
        assertThat(iterator.next().getName(), is("picFile1.jpg"));
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