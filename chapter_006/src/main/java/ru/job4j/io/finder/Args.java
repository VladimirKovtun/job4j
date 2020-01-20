package ru.job4j.io.finder;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Args {
    private final String arg;
    private String fileNameDir;
    private String criteria;
    private String flag;
    private String fileNameSave;

    public Args(String[] arg) {
        this.arg = Arrays.toString(arg).replaceAll(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    public boolean validateKey() {
        boolean result = false;
        if (parseFileNameSave() && parseCriteria()
           && parseFlag() && parseFileNameDir()) {
            result = true;
        }
        return result;
    }

    private boolean parseFileNameDir() {
        boolean result = false;
        if (arg != null && arg.contains("-d")) {
            fileNameDir = arg.split("-d")[1].trim().split(" ")[0];
            result = true;
        } else {
            System.out.println("Input name directory and restart for start search.");
        }
        return result;
    }

    private boolean parseCriteria() {
        boolean result = false;
        if (arg != null && arg.contains("-n")) {
            criteria = arg.split("-n")[1].trim().split(" ")[0];
            result = true;
        } else {
            System.out.println("You forget type criteria for search.");
        }
        return result;
    }

    private boolean parseFlag() {
        boolean result = false;
        Pattern pattern = Pattern.compile("-[frm]");
        if (arg != null) {
            Matcher matcher = pattern.matcher(arg);
            if (matcher.find()) {
                flag = matcher.group();
                result = true;
            } else {
                System.out.println("You forget type flag.");
            }
        }
        return result;
    }

    private boolean parseFileNameSave() {
        boolean result = false;
        if (arg != null && arg.contains("-o")) {
            fileNameSave = arg.split("-o")[1].trim();
            result = true;
        } else {
            System.out.println("Input fileName for save result search.");
        }
        return result;
    }

    public String getFileNameDir() {
        return fileNameDir;
    }
    public String getCriteria() {
        return criteria;
    }

    public String getFlag() {
        return flag;
    }

    public String getFileNameSave() {
        return fileNameSave;
    }
}
