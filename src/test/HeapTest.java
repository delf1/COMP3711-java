package test;

import Java.Heap;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    void heapTest1(){
        Heap<Integer> heap = new Heap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);

        assertEquals((Integer) 1, heap.extractMin());
        assertEquals((Integer) 3, heap.extractMin());
        assertEquals((Integer) 4, heap.extractMin());
        assertEquals((Integer) 5, heap.extractMin());
    }

    @Test
    void heapTest2(){
        Heap<Integer> heap = new Heap<>();
        heap.insert(9);
        heap.insert(8);
        heap.insert(7);
        heap.insert(6);
        heap.insert(5);
        heap.insert(4);
        heap.insert(3);
        heap.insert(2);
        heap.insert(1);
        heap.insert(0);


        assertEquals((Integer) 0, heap.extractMin());
        assertEquals((Integer) 1, heap.extractMin());
        assertEquals((Integer) 2, heap.extractMin());
        assertEquals((Integer) 3, heap.extractMin());
        assertEquals((Integer) 4, heap.extractMin());
        assertEquals((Integer) 5, heap.extractMin());
        assertEquals((Integer) 6, heap.extractMin());
        assertEquals((Integer) 7, heap.extractMin());
        assertEquals((Integer) 8, heap.extractMin());
        assertEquals((Integer) 9, heap.extractMin());
    }

    @Test
    void heapSortSmall() {
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(1, 7, 8, 3, 4, 5));

        Heap heap = new Heap();
        heap.heapSort(X);
        Collections.sort(Y);
        assertEquals(Y, X);

    }

    @Test
    void heapSortMedium(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(10000);
        ArrayList<Integer> Y = new ArrayList<>(10000);

        for(int i = 0; i < 10000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }

        Heap heap = new Heap();

        long startTime = System.nanoTime();
        heap.heapSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of HeapSort Medium: " + (endTime - startTime));

        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Medium: " + (endTime - startTime));


        assertEquals(Y, X);

    }

    @Test
    void heapSortLarge(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000000);
        ArrayList<Integer> Y = new ArrayList<>(1000000);

        for(int i = 0; i < 1000000; i++){
            Integer insert = random.nextInt();
            X.add(insert);
            Y.add(insert);
        }

        Heap heap = new Heap();

        long startTime = System.nanoTime();
        heap.heapSort(X);
        long endTime = System.nanoTime();
        System.out.println("Duration of HeapSort Large: " + (endTime - startTime));
        startTime = System.nanoTime();
        Collections.sort(Y);
        endTime = System.nanoTime();
        System.out.println("Duration of Collections.sort Large: " + (endTime - startTime));
        assertEquals(Y, X);

    }

    @RepeatedTest(30)
    void heapSortRepeated(){
        Random random = new Random();
        ArrayList<Integer> X = new ArrayList<>(1000);
        ArrayList<Integer> Y = new ArrayList<>(1000);

        for(int i = 0; i < 1000; i++){
            Integer insert = random.nextInt()/1000000;
            X.add(insert);
            Y.add(insert);
        }

        Heap heap = new Heap();

        heap.heapSort(X);
        Collections.sort(Y);

        assertEquals(Y, X);

    }
}
