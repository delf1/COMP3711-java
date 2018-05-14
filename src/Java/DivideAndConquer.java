package Java;

import java.util.ArrayList;

public class DivideAndConquer {

    public static int binarySearch(ArrayList A, int p, int r, Comparable x){
        if(p > r){
            return -1;
        }
        int q = (p + r)/2;
        if(A.get(q) == x){
            return q;
        }
        if(x.compareTo(A.get(q)) < 0){
            return binarySearch(A, p, q - 1, x);
        }
        else{
            return binarySearch(A, q + 1, r, x);
        }
    }

    private static void merge(ArrayList<Comparable> A, int p, int q, int r){
        int i = p;
        int j = q + 1;

        ArrayList<Comparable> merged = new ArrayList<>();

        while(i != q + 1 && j != r + 1){
            if(A.get(i).compareTo(A.get(j)) > 0){
                merged.add(A.get(j));
                j++;
            }
            else{
                merged.add(A.get(i));
                i++;
            }
        }

        if(i == q + 1 && j != r + 1){
            while(j != r + 1){
                merged.add(A.get(j));
                j++;
            }
        }

        if(i != q + 1 && j == r + 1){
            while(i != q + 1){
                merged.add(A.get(i));
                i++;
            }
        }

        for(int x = p; x < r + 1; x++){
            A.set(x, merged.get(x - p));
        }

    }

    public static void mergeSortInternal(ArrayList A, int p, int r){
        if(p == r){
            return;
        }
        int q = (p + r)/2;
        mergeSortInternal(A, p, q);
        mergeSortInternal(A, q + 1, r);
        merge(A, p, q, r);
    }

    public static void mergeSort(ArrayList numbers){
        mergeSortInternal(numbers, 0, numbers.size() - 1);
    }
}
