package wallethub;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class GasStation {

    private GasStation() {
    }

    static String gasStation(String[] strArr) {

        LinkedList<Integer> diff = Arrays.stream(strArr)
                .skip(1)
                .map(s -> {
                    String[] gallons = s.split(":");
                    return Integer.parseInt(gallons[0]) - Integer.parseInt(gallons[1]);
                })
                .collect(Collectors.toCollection(LinkedList::new));


        int counter = 1;
        while (counter <= diff.size()) {
            int sum = 0;
            for (int i = 0; i < diff.size(); i++) {
                sum += diff.get(i);
                if (sum < 0) {
                    diff.addLast(diff.getFirst());
                    diff.removeFirst();
                    break;
                }
            }
            if (sum >= 0) {
                return counter + "";
            }
            counter++;
        }

        return "impossible";
    }
}
