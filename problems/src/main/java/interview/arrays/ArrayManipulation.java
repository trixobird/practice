package interview.arrays;

class ArrayManipulation {

    private ArrayManipulation() {
    }

    static long arrayManipulation(int n, int[][] queries) {

        long max = 0;
        int[] arr = new int[n];
        for (int[] query : queries) {
            int colA = query[0] - 1;
            int colB = query[1] - 1;

            arr[colA] += query[2];
            if (colB + 1 < n) {
                arr[colB + 1] -= query[2];
            }
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
