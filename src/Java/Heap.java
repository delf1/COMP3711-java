package Java;

import java.util.ArrayList;

public class Heap<T extends Comparable> {

    private ArrayList<T> heapArray;

    public Heap() {
        heapArray = new ArrayList<>();
    }

    public void insert(T obj){
        int j = heapArray.size();
        heapArray.add(obj);

        while (heapArray.get(j).compareTo(heapArray.get(j/2)) < 0 && j > 0){
            T tmp = heapArray.get(j);
            heapArray.set(j, heapArray.get(j/2));
            heapArray.set(j/2, tmp);
            j = j/2;
        }
    }

    private T min(T l, T r){
        return l.compareTo(r) < 0 ? l : r;
    }

    public T extractMin(){
        if(heapArray.size() == 0){
            throw new RuntimeException("Extract min called on empty heap.");
        }
        else{
            T ret = heapArray.get(0);

            heapArray.set(0, heapArray.get(heapArray.size() - 1));
            heapArray.remove(heapArray.size() - 1);

            int j = 0;
            int leftIndex = 2 * j + 1;
            int rightIndex = 2 * j + 2;

            //make sure the right child exists before comparing both children
            while(rightIndex < heapArray.size() && heapArray.get(j).compareTo(min(heapArray.get(leftIndex), heapArray.get(rightIndex))) > 0){
                T left = heapArray.get(leftIndex);
                T right = heapArray.get(rightIndex);

                if(left.compareTo(right) < 0){
                    heapArray.set(2 * j + 1, heapArray.get(j));
                    heapArray.set(j, left);
                    j = 2 * j + 1;
                }
                else {
                    heapArray.set(2 * j + 2, heapArray.get(j));
                    heapArray.set(j, right);
                    j = 2 * j + 2;
                }

                leftIndex = 2 * j + 1;
                rightIndex = 2 * j + 2;

            }

            //if there is a node with a left child and no right child then this will be executed
            if(leftIndex < heapArray.size() && heapArray.get(leftIndex).compareTo(heapArray.get(j)) < 0){
                T left = heapArray.get(leftIndex);
                heapArray.set(2 * j + 1, heapArray.get(j));
                heapArray.set(j, left);
                j = 2 * j + 1;
            }

            return ret;
        }
    }

    @Override
    public String toString() {
        return heapArray.toString();
    }
}
