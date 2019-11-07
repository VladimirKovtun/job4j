package ru.job4j.io;


import java.io.*;

public class Analizy {

    public void unAvailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String line;
            String[] str;
            StringBuilder resultString;
            while (reader.ready()) {
                line = reader.readLine();
                if (!line.trim().isEmpty()) {
                    str = line.split(" ");
                    int type = Integer.parseInt(str[0]);
                    if (type == 400 || type == 500) {
                        resultString = new StringBuilder(str[1]);
                        while (reader.ready()) {
                            line = reader.readLine();
                            if (!line.trim().isEmpty()) {
                                str = line.split(" ");
                                type = Integer.parseInt(str[0]);
                                if (type == 200 || type == 300) {
                                    resultString.append(";").append(str[1]).append(";").append("\n");
                                    writer.write(resultString.toString());
                                    writer.flush();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
