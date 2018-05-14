package test;

import Java.QuickSort;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    void quickSortSmall(){
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));

        QuickSort.quickSort(X);
        Collections.sort(Y);

        assertEquals(Y, X);
    }

    @Test
    void quickSortMedium(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(10000);
        ArrayList<Integer> Y = new ArrayList<>(10000);

        for(int i = 0; i < 10000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }


        long startTime = System.nanoTime();
        QuickSort.quickSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of QuickSort Medium: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Medium: " + (endTime - startTime));


        assertEquals(Y, X);

    }

    @Test
    void quickSortLarge(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000000);
        ArrayList<Integer> Y = new ArrayList<>(1000000);

        for(int i = 0; i < 1000000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }

        long startTime = System.nanoTime();
        QuickSort.quickSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of QuickSort Large: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Large: " + (endTime - startTime));
        assertEquals(Y, X);

    }

    @RepeatedTest(30)
    void quickSortRepeated(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000);
        ArrayList<Integer> Y = new ArrayList<>(1000);

        for(int i = 0; i < 1000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }

        QuickSort.quickSort(X);
        Collections.sort(Y);

        assertEquals(Y, X);

    }
}
