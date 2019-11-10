package ru.job4j.io;

import java.io.*;
import java.util.Random;

public class ConsoleChat {
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String OVER = "закончить";
    private final String logPath;
    private final String botPhraseFile;

    public ConsoleChat(String logPath, String botPhraseFile) {
        this.logPath = logPath;
        this.botPhraseFile = botPhraseFile;
    }

    public void init() {
        try (BufferedReader userRead = new BufferedReader(new InputStreamReader(System.in));
             BufferedInputStream fileAnswer = new BufferedInputStream(new FileInputStream(botPhraseFile));
             BufferedWriter logWrite = new BufferedWriter(new FileWriter(logPath, true))) {
            String[] listPhrase = new String(fileAnswer.readAllBytes()).split("\r\n");
            StringBuilder logText;
            String resStr = "";
            boolean botIsReady = true;
            while (!(resStr.equals(OVER))) {
                resStr = userRead.readLine();
                logText = new StringBuilder("I: " + resStr + "\n");
                botIsReady = !resStr.equals(STOP) && (resStr.equals(CONTINUE) || botIsReady);
                if (resStr.equals(OVER) || resStr.equals(STOP) || resStr.equals(CONTINUE)) {
                    logText = new StringBuilder("console command: " + resStr + "\n");
                } else if (botIsReady) {
                    int index = new Random().nextInt(listPhrase.length);
                    logText.append("Bot: ").append(listPhrase[index]).append("\n");
                    System.out.println("Bot: " + listPhrase[index]);
                } else {
                    logText.append("Bot: ...").append("\n");
                    System.out.println("Bot: ...");
                }
                logWrite.write(logText.toString());
                logWrite.flush();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConsoleChat("chapter_006/data/dialog.txt", "chapter_006/data/phrase.txt").init();
    }
}
