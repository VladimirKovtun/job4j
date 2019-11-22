package ru.job4j.io.finder;

import ru.job4j.io.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindUtil {
    private final Args args;

    public FindUtil(Args args) {
        this.args = args;
    }

    public void util() {
        List<File> resList;
        if (args.validateKey()) {
            List<File> files = new Search().allFiles(args.getFileNameDir());
            resList = seekByPredicate(files, getPredicat());
            write(resList, args.getFileNameSave(), args.getFileNameDir());
        }
    }

    private Predicate<File> getPredicat() {
        if ("-f".equals(args.getFlag())) {
            return x -> x.getName().equals(args.getCriteria());
        } else if ("-m".equals(args.getFlag())) {
            return x -> x.getName().endsWith(args.getCriteria().substring(1));
        } else if ("-r".equals(args.getFlag())) {
            return x -> Pattern.compile(args.getCriteria()).matcher(x.getName()).find();
        }
        return null;
    }

    private List<File> seekByPredicate(List<File> list, Predicate<File> predicate) {
        List<File> resList = new ArrayList<>();
        for (File file : list) {
            if (predicate.test(file)) {
                resList.add(file);
            }
        }
        return resList;
    }

    private void write(List<File> resList, String fileName, String directory) {
        if (resList.size() != 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/" + fileName))) {
                for (File file : resList) {
                    writer.write(file.getName() + System.lineSeparator());
                    writer.flush();
                }
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
