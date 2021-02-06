package interview.arrays;

class Rotation {

    private Rotation() {
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

    static int[] rotRight(int[] a, int d) {

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i - d >= 0) {
                res[i] = a[i - d];
            } else {
                res[i] = a[a.length - (d - i)];
            }
        }
        return res;
    }
}
