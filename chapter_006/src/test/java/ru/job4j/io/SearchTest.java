package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void whenFindTxtFiles() {
        List<File> listFiles;
        String root = System.getProperty("java.io.tmpdir") + "main";
        File parentDir = new File(root);
        parentDir.mkdir();
        File subDir1 = new File(parentDir.getAbsolutePath() + "/sub1");
        subDir1.mkdir();
        File subDir2 = new File(subDir1.getAbsolutePath() + "/sub2");
        subDir2.mkdir();
        File subDir3 = new File(subDir2.getAbsolutePath() + "/sub3");
        subDir3.mkdir();
        File subDir4 = new File(parentDir.getAbsolutePath() + "/sub4");
        subDir4.mkdir();
        listFiles = new ArrayList<>(Arrays.asList(new File(parentDir, "textFile1.txt"),
                new File(parentDir, "docFile1.doc"),
                new File(subDir1, "textFile2.txt"),
                new File(subDir2, "textFile3.txt"),
                new File(subDir2, "picFile1.jpg"),
                new File(subDir3, "docFile2.doc"),
                new File(subDir4, "textFile4.txt")));
        listFiles.forEach(file -> {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        List<File> files = new Search().files(root, new ArrayList<>(Arrays.asList(".txt")));
        Iterator<File> iterator = files.iterator();
        assertThat(iterator.next().getName(), is("textFile1.txt"));
        assertThat(iterator.next().getName(), is("textFile2.txt"));
        assertThat(iterator.next().getName(), is("textFile4.txt"));
        assertThat(iterator.next().getName(), is("textFile3.txt"));
    }

    @Test
    public void whenFindDocAndJpgFiles() {
        List<File> listFiles;
        String root = System.getProperty("java.io.tmpdir") + "main";
        File parentDir = new File(root);
        parentDir.mkdir();
        File subDir1 = new File(parentDir.getAbsolutePath() + "/sub1");
        subDir1.mkdir();
        File subDir2 = new File(subDir1.getAbsolutePath() + "/sub2");
        subDir2.mkdir();
        File subDir3 = new File(subDir2.getAbsolutePath() + "/sub3");
        subDir3.mkdir();
        File subDir4 = new File(parentDir.getAbsolutePath() + "/sub4");
        subDir4.mkdir();
        listFiles = new ArrayList<>(Arrays.asList(new File(parentDir, "textFile1.txt"),
                new File(parentDir, "docFile1.doc"),
                new File(subDir1, "textFile2.txt"),
                new File(subDir2, "textFile3.txt"),
                new File(subDir2, "picFile1.jpg"),
                new File(subDir3, "docFile2.doc"),
                new File(subDir4, "textFile4.txt")));
        listFiles.forEach(file -> {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        List<File> files = new Search().files(root, new ArrayList<>(Arrays.asList(".doc", ".jpg")));
        Iterator<File> iterator = files.iterator();
        assertThat(iterator.next().getName(), is("docFile1.doc"));
        assertThat(iterator.next().getName(), is("picFile1.jpg"));
        assertThat(iterator.next().getName(), is("docFile2.doc"));
    }
}