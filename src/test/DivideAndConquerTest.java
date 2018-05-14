package test;

import Java.DivideAndConquer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DivideAndConquerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void binarySearch() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 10, 23, 109, 222, 363, 1000));
        assertEquals(5, DivideAndConquer.binarySearch(A, 0, A.size(), 23));
    }

    @Test
    void binarySearchNotFound() {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 10, 23, 109, 222, 363, 1000));
        assertEquals(-1, DivideAndConquer.binarySearch(A, 0, A.size(), 100));
    }

    @Test
    void mergeSortSmall() {
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));
        DivideAndConquer.mergeSort(X);
        Collections.sort(Y);
        assertEquals(Y, X);
    }

    @Test
    void mergeSortMedium(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(10000);
        ArrayList<Integer> Y = new ArrayList<>(10000);

        for(int i = 0; i < 10000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }


        long startTime = System.nanoTime();
        DivideAndConquer.mergeSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of MergeSort Medium: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Medium: " + (endTime - startTime));


        assertEquals(Y, X);

    }

    @Test
    void mergeSortLarge(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000000);
        ArrayList<Integer> Y = new ArrayList<>(1000000);

        for(int i = 0; i < 1000000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }

        long startTime = System.nanoTime();
        DivideAndConquer.mergeSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of MergeSort Large: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Large: " + (endTime - startTime));
        assertEquals(Y, X);

    }

    @RepeatedTest(30)
    void mergeSortRepeated(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000);
        ArrayList<Integer> Y = new ArrayList<>(1000);

        for(int i = 0; i < 1000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }
        DivideAndConquer.mergeSort(X);
        Collections.sort(Y);

        assertEquals(Y, X);

    }
}