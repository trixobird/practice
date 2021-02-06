package mathematics.fundamentals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class SherlockAndDivisors {

    private SherlockAndDivisors() {
    }

    static int divisors(final int n) {

        if ((n % 2) != 0) {
            return 0;
        }

        final HashMap<Integer, Integer> divisorTimes = new HashMap<>();

        int div = n;
        for (int i = 2; i <= div; i++) {
            while (true) {
                if ((div % i) == 0) {
                    div /= i;
                    if (!divisorTimes.containsKey(i)) {
                        divisorTimes.put(i, 0);
                    }
                    divisorTimes.put(i, divisorTimes.get(i) + 1);
                } else {
                    break;
                }
            }
        }
        return getNumOfDivisors(divisorTimes.keySet().stream().filter(i -> i != 2).collect(Collectors.toList()), divisorTimes);
    }

    static int combinationUtil(int[] arr, int[] data, int start,
                                int end, int index, int r, final Map<Integer, Integer> divisors)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
            int numOfDivisors = 1;
            for (int j=0; j<r; j++) {
                numOfDivisors *= divisors.get(data[j]);
            }
            return numOfDivisors;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        int numOfDivisors = 0;
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            numOfDivisors += combinationUtil(arr, data, i+1, end, index+1, r, divisors);
        }
        return numOfDivisors;
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static int getCombination(int[] arr, int n, int r, Map<Integer, Integer> divisors)
    {
        // A temporary array to store all combination one by one
        int[] data =new int[r];

        // Get all combination using temporary array 'data[]'
        return combinationUtil(arr, data, 0, n-1, 0, r, divisors);
    }

    private static int getNumOfDivisors(final List<Integer> list, final Map<Integer, Integer> divisors) {

        int numOfDivisors = 0;
        for (int i = 1; i <= list.size() ; i++) {
            numOfDivisors += getCombination(list.stream().mapToInt(j->j).toArray(), list.size(), i, divisors);
        }
        return numOfDivisors * (divisors.get(2)) + divisors.get(2);
    }
}
