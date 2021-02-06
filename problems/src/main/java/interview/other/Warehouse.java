package interview.other;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Warehouse {

    ArrayList<Integer> fillTruck(int truckSpace, ArrayList<Integer> packages) {

        final int safeSpace = truckSpace - 30;

        Map<Integer, List<Integer>> mapValueIdx =
                IntStream.range(0, packages.size())
                        .boxed()
                        .collect(Collectors.groupingBy(packages::get, Collectors.toList()));

        List<Integer> sortedPackages = packages
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Integer meanValue = sortedPackages
                .stream()
                .filter(i -> i >= safeSpace / 2)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        int upperLimit = Collections.binarySearch(sortedPackages, meanValue);

        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0));
        for (int i = 0; i < upperLimit; i++) {
            Integer value = safeSpace - sortedPackages.get(i);
            int idx = Collections.binarySearch(sortedPackages, value);
            if (idx != -5 && i != idx) {
                result = biggerPackage(result, sortedPackages, i, idx);
            }
        }

        result.set(0, mapValueIdx.get(sortedPackages.get(result.get(0))).get(0));
        result.set(1, mapValueIdx.get(sortedPackages.get(result.get(1))).get(0));

        return result;
    }

    private ArrayList<Integer> biggerPackage(ArrayList<Integer> current, List<Integer> packages, int i, int j) {
        if (Math.max(packages.get(current.get(0)), packages.get(current.get(1))) < Math.max(packages.get(i), packages.get(j))) {
            return new ArrayList<>(Arrays.asList(i, j));
        }
        return current;
    }
}
