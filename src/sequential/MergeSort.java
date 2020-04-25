package sequential;

import model.Result;

import java.util.ArrayList;

/**
 * Class dat een merge sort kan uitvoeren
 * @author michaelkuijpers, dennisparagusha, abdulahouali
 */
public class MergeSort {

    // Class variabel
    private ArrayList<Result> list;

    // Constructor
    protected MergeSort(ArrayList<Result> list) {
        this.list = list;
    }

    /**
     * De sort methode
     */
    protected void sortTemperaturen() {
        list = mergeSort(list);
    }

    /**
     * Toon de sorted list methode
     */
    protected void toonSort() {
        System.out.println("Merge sort temperaturen:");
        for (int i = 0; i < list.size(); i++) {
            Result result = list.get(i);
            System.out.println(result.getYear() + ": " + result.getTemperature());
        }
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
