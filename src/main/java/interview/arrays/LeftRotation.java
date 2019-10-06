package interview.arrays;

class LeftRotation {

    private LeftRotation() {
    }

    static int[] rotLeft(int[] a, int d) {

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i - d >= 0) {
                res[i - d] = a[i];
            } else {
                res[a.length - (d - i)] = a[i];
            }
        }
        return res;
    }
}
