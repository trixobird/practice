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
                int tmpIdx = i;
                while (tmpIdx < q.length - 1 && q[tmpIdx] > q[tmpIdx + 1]) {
                    swap(q, tmpIdx, tmpIdx + 1);
                    bribes++;
                    tmpIdx++;
                }
            }

            if (i > 0 && q[i] - q[i - 1] < 1) {
                int tmpIdx = i;
                while (tmpIdx > 0 && q[tmpIdx] < q[tmpIdx - 1]) {
                   swap(q, tmpIdx, tmpIdx - 1);
                    bribes++;
                    tmpIdx--;
                }
            }
        }
        return bribes;
    }

    private static void swap(int[] q, int a, int b) {
        int tmp = q[b];
        q[b] = q[a];
        q[a] = tmp;
    }
}
