package ru.job4j.io;


import java.io.*;

public class Analizy {

    public void unAvailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
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
                        resultString.append(";").append(line.split(" ")[1]).append(";").append("\n");
                        writer.write(resultString.toString());
                        writer.flush();
                        resultString = new StringBuilder();
                        sw = true;
                    }
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
