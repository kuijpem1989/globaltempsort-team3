package sequential;

import model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Class dat een merge sort kan uitvoeren
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class MergeSort {

    // Class variabel
    private ArrayList<Result> list;
    private List<Result> topTenTemps;

    // Constructor
    public MergeSort(ArrayList<Result> list) {
        this.list = list;
    }

    /**
     * De sort methode
     */
    public void sortTemperaturen() {
        list = mergeSort(list);
    }

    /**
     * Toon de sorted list methode
     * @return
     */
    public List<Result> toonSort() {
        return topTenTemps = list.subList(Math.max(list.size() - 10, 0), list.size());
    }

    protected ArrayList<Result> mergeSort(ArrayList<Result> entire) {
        ArrayList<Result> left = new ArrayList<>();
        ArrayList<Result> right = new ArrayList<>();
        int center;

        if (entire.size() == 1) {
            return entire;
        } else {
            center = entire.size()/2;
            // kopieer linker in een nieuwe arraylist
            for (int i = 0; i < center; i++) {
                left.add(entire.get(i));
            }

            // kopieer rechter in een nieuwe arraylist
            for (int i = center; i < entire.size(); i++) {
                right.add(entire.get(i));
            }

            // Sort de linker en rechter helft
            left  = mergeSort(left);
            right = mergeSort(right);

            // merge de resultaten bij elkaar
            merge(left, right, entire);
        }
        return entire;
    }

    private void merge(ArrayList<Result> left, ArrayList<Result> right, ArrayList<Result> entire) {
        int leftIndex = 0, rightIndex = 0, entireIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( (left.get(leftIndex).compareTo(right.get(rightIndex))) < 0) {
                entire.set(entireIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                entire.set(entireIndex, right.get(rightIndex));
                rightIndex++;
            }
            entireIndex++;
        }
        ArrayList<Result> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // links is klaar
            rest = right;
            restIndex = rightIndex;
        } else {
            // rechts is klaar
            rest = left;
            restIndex = leftIndex;
        }

        // Kopieer de overige elementen die nog niet gebruikt zijn
        for (int i=restIndex; i<rest.size(); i++) {
            entire.set(entireIndex, rest.get(i));
            entireIndex++;
        }
    }


}
