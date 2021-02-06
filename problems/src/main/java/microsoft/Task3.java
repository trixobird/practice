package microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Task3 {

    public static int solution(int[] blocks) {

        LinkedList<Integer> list = Arrays.stream(blocks).boxed().collect(Collectors.toCollection(LinkedList::new));

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            final int distances = getDistances(list, i);
            if (distances > max) {
                max = distances;
            }
        }
        return max;
    }

    private static int getDistances(LinkedList<Integer> list, int idx) {

        int left = 0;
        int right = 0;
        int it = idx;
        while (it + 1 != list.size()) {
            if (list.get(it + 1) >= list.get(it)) {
                right++;
                it++;
            } else {
                break;
            }
        }

        it = idx;
        while (it - 1 > 0) {
            if (list.get(it - 1) >= list.get(it)) {
                left++;
                it--;
            } else {
                break;
            }
        }

        return left + right + 1;
    }

    private static class Distance {
        private int left;
        private int right;

        public Distance(final int left, final int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public Distance setLeft(final int left) {
            this.left = left;
            return this;
        }

        public int getRight() {
            return right;
        }

        public Distance setRight(final int right) {
            this.right = right;
            return this;
        }
    }
}
