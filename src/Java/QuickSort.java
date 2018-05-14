package Java;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {

    static Random rand = new Random();

    private static int partition(ArrayList<Comparable> list, int start, int end, boolean random){

        Comparable selected;

        if(random){
            int rand_index = rand.nextInt((end - start) + 1) + start;
            selected = list.get(rand_index);

            //swap last element and randomly selected element to simplify the rest of the quicksort code
            list.set(rand_index, list.get(end));
            list.set(end, selected);
        }
        else {
            selected = list.get(end);
        }

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

    private static void quickSortInternal(ArrayList list, int start, int end, boolean random){
        if(start >= end){
            return;
        }

        int q = partition(list, start, end, random);
        quickSortInternal(list, start, q -1, random);
        quickSortInternal(list, q + 1, end, random);
    }

    public static void quickSort(ArrayList list) {
        quickSortInternal(list, 0, list.size() - 1, false);
    }

    public static void quickSortRandom(ArrayList list){
        quickSortInternal(list, 0, list.size() - 1, true);
    }
}
