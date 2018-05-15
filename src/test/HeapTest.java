package test;

import Java.Heap;
import org.junit.jupiter.api.Test;

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
}
