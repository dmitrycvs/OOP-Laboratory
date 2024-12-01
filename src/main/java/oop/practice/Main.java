package oop.practice;

import oop.practice.Task4.Semaphore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String command = "python3";
        String scriptPath = "scripts/generator.py";
        LinkedList<String> output = new LinkedList<>();

        Thread pythonThread = new Thread(() -> {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(command, scriptPath);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        output.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pythonThread.start();

        Timer timer = new Timer();
        Semaphore semaphore = new Semaphore();
        timer.scheduleAtFixedRate(new CarReader(1, semaphore, timer), 0, 3000);

        pythonThread.join();
        semaphore.waitForAllThreads();

        semaphore.showStatistics();

        System.out.println("Expected statistics: ");
        System.out.println(output.getLast());
    }
}
