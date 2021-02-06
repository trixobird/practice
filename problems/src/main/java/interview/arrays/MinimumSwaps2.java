package interview.arrays;

class MinimumSwaps2 {

    private MinimumSwaps2() {
    }

    static int minimumSwaps(int[] arr) {

        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i + 1) {
                swap(arr, i, arr[i] - 1);
                swaps++;
            }
        }
        return swaps;
    }

    private static void swap(int[] q, int a, int b) {
        int tmp = q[b];
        q[b] = q[a];
        q[a] = tmp;
    }
}
