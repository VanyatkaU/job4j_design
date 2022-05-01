package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean server = true;
        String statusBar = "";
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            while (in.ready()) {
                String line = in.readLine();
                if (line.startsWith("400") || line.startsWith("500")) {
                    if (server) {
                        statusBar = line.split(" ")[1];
                        server = false;
                    }
                } else if (!server) {
                    if (line.startsWith("200") || line.startsWith("300")) {
                        statusBar = statusBar + ";" + line.split(" ")[1];
                        out.println(statusBar);
                        server = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", "unavailable.csv");
    }
}
