package test;

import Java.Greedy;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GreedyTest {
    @Test
    void intervalScheduling1(){
        ArrayList<Pair<Float, Float>> intervals = new ArrayList<>();
        intervals.add(new Pair<>(0f, 6f));
        intervals.add(new Pair<>(1f, 4f));
        intervals.add(new Pair<>(3f, 5f));
        intervals.add(new Pair<>(3f, 8f));
        intervals.add(new Pair<>(4f, 7f));
        intervals.add(new Pair<>(5f, 9f));
        intervals.add(new Pair<>(6f, 10f));
        intervals.add(new Pair<>(8f, 11f));

        ArrayList<Pair<Float, Float>> optSchedule = new ArrayList<>();
        optSchedule.add(new Pair<>(1f, 4f));
        optSchedule.add(new Pair<>(4f, 7f));
        optSchedule.add(new Pair<>(8f, 11f));

        assertEquals(optSchedule, Greedy.scheduleInterval(intervals));
    }
}
