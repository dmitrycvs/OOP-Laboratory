package oop.practice.Assistant;

import oop.practice.ObjectIteration.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private final String name;
    private final List<Display> displays;

    public Assistant(String name) {
        this.name = name;
        this.displays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        this.displays.add(d);
    }

    public void assist() {
        if (displays.isEmpty()) {
            System.out.println("No displays available");
            return;
        }
        Display current = displays.getFirst();
        for (int i = 1; i < displays.size(); i++) {
            Display next = displays.get(i);

            current.compareWithMonitor(next);
            current = next;
        }
    }

    public Display buyDisplay(Display d) {
        if (displays.remove(d)) {
            return d;
        }
        return null;
    }
}
