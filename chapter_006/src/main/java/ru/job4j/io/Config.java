package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] read;
            while (reader.ready()) {
                String str = reader.readLine();
                read = str.split("=");
                if (!str.startsWith("//") && !read[0].trim().isEmpty()) {
                    values.put(read[0], read[1]);
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.lines().forEach(out::add);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return out.toString();
    }
}
