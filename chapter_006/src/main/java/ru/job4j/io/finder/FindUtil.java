package ru.job4j.io.finder;

import ru.job4j.io.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
            resList = seekByCriteria(files, args.getFlag(), args.getCriteria());
            write(resList, args.getFileNameSave(), args.getFileNameDir());
        }
    }

    private List<File> seekByCriteria(List<File> list, String flag, String criteria) {
        List<File> resList = new ArrayList<>();
        if (list.size() != 0) {
            if ("-f".equals(flag)) {
                for (File file : list) {
                    if (file.getName().equals(criteria)) {
                        resList.add(file);
                        break;
                    }
                }
            } else if ("-m".equals(flag)) {
                for (File file : list) {
                    String fileName = file.getName();
                    String criteriaExt = criteria.substring(1);
                    if (fileName.endsWith(criteriaExt)) {
                        resList.add(file);
                    }
                }
            } else if ("-r".equals(flag)) {
                Pattern pattern = Pattern.compile(criteria);
                list.stream()
                        .filter(x -> pattern.matcher(x.getName()).find())
                        .forEach(resList::add);
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
