package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botPhrases = readPhrases();
        List<String> entryDialog = new ArrayList<>();
        boolean dialog = true;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
        String userPhrases = in.readLine();
        entryDialog.add(userPhrases);
        while (!OUT.equals(userPhrases)) {
            if (dialog) {
                String botAnswer = getPhrase(botPhrases);
                System.out.println(botAnswer);
                entryDialog.add(botAnswer);
            }
            userPhrases = in.readLine();
            entryDialog.add(userPhrases);
            if (STOP.equals(userPhrases)) {
                dialog = false;
            } else if (CONTINUE.equals(userPhrases)) {
                dialog = true;
            }
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
        saveLog(entryDialog);
    }

    private String getPhrase(List<String> phrases) {
        Random random = new Random();
        return phrases.get(random.nextInt(phrases.size()));
    }

    private List<String> readPhrases() {
        List<String> botPhrases = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(
                botAnswers, StandardCharsets.UTF_8))) {
            in.lines().forEach(botPhrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return botPhrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter out = new PrintWriter(new FileWriter(
                path, StandardCharsets.UTF_8))) {
            log.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("ConsoleChat.txt", "botAnswers.txt");
        cc.run();
    }
}
