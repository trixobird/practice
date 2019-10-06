package interview.arrays;

class NewYearChaos {

    private NewYearChaos() {
    }

    static void minimumBribes(int[] q) {

        int bribes = minimumBribesInternal(q);
        if (bribes >= 0) {
            System.out.println(bribes);
        } else {
            System.out.println("Too chaotic");
        }
    }

    static int minimumBribesInternal(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - i > 3) {
                return -1;
            }

            if (i < q.length - 1 && q[i] - q[i + 1] > 1) {
                bribes = swap(q, i, i + 1, bribes);
            }

            if (i > 0 && q[i] - q[i - 1] < 1) {
               bribes = swap(q, i, i - 1, bribes);
            }
        }
        return bribes;
    }

    private static int swap(int[] q, int a, int b, int bribes) {
        bribes++;

        int tmp = q[b];
        q[b] = q[a];
        q[a] = tmp;

        if (b < q.length - 1 && q[b] > q[b + 1]) {
            bribes = swap(q, b, b + 1, bribes);
        }

        if (a > 0 && q[a] < q[a - 1]) {
            bribes = swap(q, a - 1, a, bribes);
        }
        return bribes;
    }
}
