package test;

import Java.Subarray;
import javafx.util.Pair;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SubarrayTest {

    @Test
    void divideAndConquer1(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(3, 2, 1, -7, 5, 2, -1, 3, -1));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(4, 7), indices);
    }

    @Test
    void divideAndConquer2(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(2, 6), indices);
    }

    @Test
    void divideAndConquer3(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(5));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(0, 0), indices);
    }

    @Test
    void divideAndConquer4(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, -100));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(0, 5), indices);
    }


    @Test
    void divideAndConquer5(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-100, 5, 5, 5, 5, 5, 5, -100));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(1, 6), indices);
    }

    @Test
    void divideAndConquer6(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-100, -5, -4, -2, -3, -4, -5, -100));
        Pair indices = Subarray.divideAndConquer(profit);
        assertEquals(new Pair(3, 3), indices);
    }

    @Test
    void linear1(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(3, 2, 1, -7, 5, 2, -1, 3, -1));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(4, 7), indices);
    }

    @Test
    void linear2(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(2, 6), indices);
    }

    @Test
    void linear3(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(5));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(0, 0), indices);
    }

    @Test
    void linear4(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, 5, -100));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(0, 5), indices);
    }


    @Test
    void linear5(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-100, 5, 5, 5, 5, 5, 5, -100));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(1, 6), indices);
    }

    @Test
    void linear6(){
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(-100, -5, -4, -2, -3, -4, -5, -100));
        Pair indices = Subarray.linear(profit);
        assertEquals(new Pair(3, 3), indices);
    }

    @RepeatedTest(30)
    void crossCheck(){
        Random random = new Random();
        ArrayList<Integer> profit = new ArrayList<>(1000);

        for(int i = 0; i < 1000; i++){
            Integer insert = random.nextInt();
            profit.add(insert);
        }

        Pair indicesDC = Subarray.divideAndConquer(profit);
        Pair indicesLinear = Subarray.linear(profit);

        assertEquals(indicesDC, indicesLinear);
    }

}
