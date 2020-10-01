package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AboveAverageSubarrays {

    Subarray[] aboveAverageSubarrays(int[] A) {

        if (A.length == 1) {
            return new Subarray[]{new Subarray(1,1)};
        }

        List<Subarray> subarrays = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i; j < A.length; j++) {

                int[] before;
                if (i != 0) {
                    before = Arrays.copyOfRange(A, 0, i - 1);
                } else {
                    before = new int[0];
                }

                int[] after = j == A.length - 1 ? new int[0] : Arrays.copyOfRange(A, j + 1, A.length);

                double remAvg = 0;
                for (final int i1 : before) {
                    remAvg+=i1;
                }
                for (final int i1 : after) {
                    remAvg+=i1;
                }
                remAvg /= (before.length + after.length);

                int[] subarray = Arrays.copyOfRange(A, i , j);
                double avg = 0;
                for (final int i1 : subarray) {
                    avg+=i1;
                }
                avg /= subarray.length;

                if (avg > remAvg) {
                    subarrays.add(new Subarray(i,j));
                }
            }
        }
        return subarrays.toArray(Subarray[]::new);
    }

    private class Subarray {
        private int start;
        private int finish;

        public Subarray(final int start, final int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int getStart() {
            return start;
        }

        public Subarray setStart(final int start) {
            this.start = start;
            return this;
        }

        public int getFinish() {
            return finish;
        }

        public Subarray setFinish(final int finish) {
            this.finish = finish;
            return this;
        }
    }
}
