package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairSums {

    int numberOfWays(int[] arr, int k) {

        if (arr.length <= 1) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i] + arr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    int[] answerQueries(ArrayList<Query> queries, int N) {
        List<Boolean> collect = Stream.of(false).limit(N).collect(Collectors.toList());

        int[] ret = new int[queries.size()];

        for (int j = 0; j < queries.size(); j++) {
            final Query query = queries.get(j);
            if (query.getType() == 2) {
                collect.set(query.getIndex(), true);
            }

            if (query.getType() == 1) {
                int i = collect.stream().skip(query.getIndex()).collect(Collectors.toList()).indexOf(true);
                ret[j] = i + query.getIndex();
            }
        }
        return ret;
    }

    private class Query {
        private int type;
        private int index;

        public int getType() {
            return type;
        }

        public Query setType(final int type) {
            this.type = type;
            return this;
        }

        public int getIndex() {
            return index;
        }

        public Query setIndex(final int index) {
            this.index = index - 1;
            return this;
        }
    }
}
