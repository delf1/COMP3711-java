package Java;

import javafx.util.Pair;

import java.util.ArrayList;

public class Greedy {
    public static ArrayList<Pair<Float,Float>> scheduleInterval(ArrayList<Pair<Float,Float>> intervals) {
        ArrayList<Pair<Float, Float>> tmp = new ArrayList<>();
        for(Pair p : intervals){
            tmp.add(p);
        }

        tmp.sort((Pair<Float,Float> a, Pair<Float,Float> b) -> (int) (a.getValue() - b.getValue()));
        ArrayList<Pair<Float, Float>> schedule = new ArrayList<>();

        float lastStartTime = 0f;
        for(int i = 0; i < tmp.size(); i++){
            if(tmp.get(i).getKey() >= lastStartTime){
                schedule.add(tmp.get(i));
                lastStartTime = tmp.get(i).getValue();
            }
        }

        return schedule;
    }
}
