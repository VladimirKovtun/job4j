package ru.job4j.io.finder;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindUtilTest {
    private String root = System.getProperty("java.io.tmpdir") + "/main/";

    @Before
    public void prepareToTest() {
        File parentDir = new File(root);
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
                if (!file.exists()) {
                    if (!file.mkdir()) {
                        throw new FileNotFoundException();
                    }
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
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        throw new FileNotFoundException();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void whenFindTxtFileWhithFlagF() {
        List<String> list = new ArrayList<>();
        Args args = new Args(new String[]{"-d", root
                , "-n", "textFile4.txt", "-f", "-o", "log.txt"});
        new FindUtil(args).util();

        try {
            list = Files.readAllLines(Paths.get(root + args.getFileNameSave()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(list.toString(), is(Arrays.asList("textFile4.txt").toString()));
    }

    @Test
    public void whenFindTxtFileWhithFlagM() {
        List<String> list = new ArrayList<>();
        Args args = new Args(new String[]{"-d", root
                , "-n", "*.doc", "-m", "-o", "log.txt"});
        new FindUtil(args).util();

        try {
            list = Files.readAllLines(Paths.get(root + args.getFileNameSave()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(list.toString(), is(Arrays.asList("docFile1.doc", "docFile2.doc").toString()));
    }
}