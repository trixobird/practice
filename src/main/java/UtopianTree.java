/**
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 */
class UtopianTree {

    private UtopianTree() {}

    static int utopianTree(int n) {

        int height = 1;

        if (n == 0) {
            return height;
        }

        for (int i = 1; i <= n; i++) {
            height = increase(height, i);
        }
        return height;
    }

    private static int increase(int height, int cycle) {
        return cycle % 2 == 0 ? height + 1 :2 * height;
    }
}
