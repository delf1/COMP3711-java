package Java;

import javafx.util.Pair;

import java.util.ArrayList;

public class Subarray {

    private static Number getTotal(ArrayList<? extends Number> A, int start, int end){
        if(start == end){
            return A.get(start);
        }


        Number total = 0;
        for(int i = start; i <= end; i++){
            total = total.floatValue() + A.get(i).floatValue();
        }

        return total;
    }

    private static Pair<Integer, Integer> getMaxMiddlePair(ArrayList<? extends Number> A, int start, int middle, int end){
        Number totalLeft = 0;
        Number leftMax = 0;
        Number totalRight = 0;
        Number rightMax = 0;

        int left = middle;
        int right = middle;

        for(int i = middle; i >= start; i--){
            totalLeft = totalLeft.floatValue() + A.get(i).floatValue();
            if(totalLeft.floatValue() > leftMax.floatValue()){
                leftMax = totalLeft;
                left = i;
            }
        }

        for(int i = middle; i <= end; i++){
            totalRight = totalRight.floatValue() + A.get(i).floatValue();
            if(totalRight.floatValue() > rightMax.floatValue()){
                rightMax = totalRight;
                right = i;
            }
        }

        return new Pair<>(left, right);
    }

    private static Pair<Integer, Integer> divideAndConquerInternal(ArrayList<? extends Number> numbers, int start, int end){
        if(start == end){
            return new Pair<>(start, end);
        }

        int middle = (start + end)/2;

        Pair<Integer, Integer> left = divideAndConquerInternal(numbers, start, middle);
        Pair<Integer, Integer> right = divideAndConquerInternal(numbers, middle + 1, end);
        Pair<Integer, Integer> middlePair = getMaxMiddlePair(numbers, start, middle, end);

        float leftValue = getTotal(numbers, left.getKey(), left.getValue()).floatValue();
        float rightValue  = getTotal(numbers, right.getKey(), right.getValue()).floatValue();
        float middleValue = getTotal(numbers, middlePair.getKey(), middlePair.getValue()).floatValue();

        if(leftValue > rightValue){
            return leftValue > middleValue ? left : middlePair;
        }
        else{
            return rightValue > middleValue ? right : middlePair;
        }

    }

    public static Pair divideAndConquer(ArrayList<? extends Number> numbers) {
        return divideAndConquerInternal(numbers, 0, numbers.size() - 1);
    }

    public static Pair linear(ArrayList<? extends Number> numbers){
        Number v_max = numbers.get(0);
        Number v = 0;
        int start = 0;
        int end = 0;
        int start_max = 0;

        for(int i = 0; i < numbers.size(); i++){
            v = v.floatValue() + numbers.get(i).floatValue();
            if(v.floatValue() > v_max.floatValue()){
                v_max = v;
                end = i;
                start = start_max;
            }
            if(v.floatValue() < 0){
                v = 0;
                start_max = i + 1;
            }
        }

        return new Pair<>(start, end);
    }
}
