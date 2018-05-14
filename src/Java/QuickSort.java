package Java;

import java.util.ArrayList;

public class QuickSort {

    private static int partition(ArrayList<Comparable> list, int start, int end){
        Object selected = list.get(end);
        int i = start - 1;
        for(int j = start; j < end; j++){
            if(list.get(j).compareTo(selected) < 0){
                i++;
                Comparable tmp = list.get(j);
                list.set(j, list.get(i));
                list.set(i, tmp);
            }
        }
        Comparable tmp = list.get(end);
        list.set(end, list.get(i + 1));
        list.set(i + 1, tmp);

        return i + 1;

    }

    private static void quickSortInternal(ArrayList list, int start, int end){
        if(start >= end){
            return;
        }
        int q = partition(list, start, end);
        quickSortInternal(list, start, q -1);
        quickSortInternal(list, q + 1, end);
    }

    public static void quickSort(ArrayList list) {
        quickSortInternal(list, 0, list.size() - 1);
    }
}
