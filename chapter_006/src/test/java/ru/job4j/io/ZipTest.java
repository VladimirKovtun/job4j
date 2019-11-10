package ru.job4j.io;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ZipTest {

    @Before
    public void prepareToTest() {
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
    }

    @Test
    public void whenUnzip3Files() throws IOException {
        String property = System.getProperty("java.io.tmpdir");
        String fixProp = property + "main";
        Arg arg = new Arg("java -jar pack.jar -d C:/Users/User/AppData/Local/Temp/main"
                + " -e *.txt -o example.zip");
        Zip zip = new Zip(arg);
        List<File> files = zip.seekBy(fixProp, arg.exclude());
        zip.pack(files, new File(property + arg.output()));
        List<String> list = new LinkedList<>();
        ZipFile zipFile = new ZipFile(property + arg.output());
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String[] zipArray = entries.nextElement().getName().split("\\\\");
            list.add(zipArray[zipArray.length - 1]);
        }
        List<String> collect = files.stream().map(File::getName).collect(Collectors.toList());
        assertThat(collect.toString(), is(list.toString()));
    }

}