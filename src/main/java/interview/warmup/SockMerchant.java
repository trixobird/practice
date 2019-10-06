package interview.warmup;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class SockMerchant {

    private SockMerchant() {
    }

    static int sockMerchant(int n, int[] ar) {

        return (int) Arrays
                .stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .map(aLong -> aLong / 2)
                .mapToLong(Long::intValue)
                .sum();
    }
}
