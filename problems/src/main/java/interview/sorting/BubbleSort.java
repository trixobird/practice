package interview.sorting;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Objects;

class BubbleSort {

    private BubbleSort() {
    }

    static void countSwaps(int[] a) {

        Triple<Integer, Integer, Integer> stats = internalCountSwaps(a);
        System.out.printf("Array is sorted in %d swaps.%n", Objects.requireNonNull(stats).getLeft());
        System.out.printf("First Element: %d%n", stats.getMiddle());
        System.out.printf("Last Element: %d%n", stats.getRight());
    }

    static Triple<Integer, Integer, Integer> internalCountSwaps(int[] a) {

        int count = sort(a);
        return new ImmutableTriple<>(count, a[0], a[a.length - 1]);
    }

    private static int sort(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    count++;
                }
            }
        }
        return count;
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}