package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unAvailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            List<String> logLine = new ArrayList<>();
            String line;
            StringBuilder resultString = new StringBuilder();
            boolean sw = true;
            while (reader.ready()) {
                line = reader.readLine();
                if (!line.trim().isEmpty()) {
                    if ((line.startsWith("400") || line.startsWith("500")) && sw) {
                        resultString.append(line.split(" ")[1]);
                        sw = false;
                    } else if ((line.startsWith("200") || line.startsWith("300")) && !sw) {
                        resultString.append(";").append(line.split(" ")[1]).append(";");
                        logLine.add(resultString.toString());
                        resultString = new StringBuilder();
                        sw = true;
                    }
                }
            }
            writeOn(logLine, target);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private void writeOn(List<String> logList, String target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String line : logList) {
                writer.write(line + "\n");
                writer.flush();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
