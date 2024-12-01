package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import oop.practice.Task4.Semaphore;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class CarReader extends TimerTask {
    private int index;
    private final Semaphore sp;
    private final Timer timer;

    public CarReader(int startIndex, Semaphore sp, Timer timer) {
        this.index = startIndex;
        this.sp = sp;
        this.timer = timer;
    }

    @Override
    public void run() {
        File file = new File("src/main/resources/queue/Car" + index + ".json");
        if (!file.exists()) {
            timer.cancel();
            return;
        }

        try {
            JsonNode carData = new ObjectMapper().readTree(file);
            Car car = new Car(
                    carData.get("id").asText(),
                    carData.get("type").asText(),
                    carData.get("passengers").asText(),
                    carData.get("isDining").asBoolean(),
                    carData.get("consumption").asInt()
            );
            sp.navigateCars(car);
        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + file.getName(), e);
        }

        index++;
    }
}
