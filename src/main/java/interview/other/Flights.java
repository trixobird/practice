package interview.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

class Flights {
  List<List<Integer>> optimalUtilization(int maxTravelDist,
    List<List<Integer>> forwardRouteList,
    List<List<Integer>> returnRouteList) {

    int max = 0;
    List<List<Integer>> res = new ArrayList<>();

    List<Route> fwRoutes = forwardRouteList
      .stream()
      .sorted(Comparator.comparing(o -> o.get(1)))
      .map(r -> new Route(r.get(0), r.get(1)))
      .collect(toList());

    List<Route> retRoutes = returnRouteList
      .stream()
      .sorted((o1, o2) -> o2.get(1).compareTo(o1.get(1)))
      .map(r -> new Route(r.get(0), r.get(1)))
      .collect(toList());

    int idxStart = 0;
    for (Route fwRoute : fwRoutes) {
      for (int i = idxStart; i < retRoutes.size(); i++) {
        Route retRoute = retRoutes.get(i);
        int distance = fwRoute.getDistance() + retRoute.getDistance();
        if (distance <= maxTravelDist) {
          if (distance > max) {
            res = new ArrayList<>();
            max = distance;
            res.add(Arrays.asList(fwRoute.getId(), retRoute.getId()));
          } else if (distance == max) {
            res.add(Arrays.asList(fwRoute.getId(), retRoute.getId()));
          }
          break;
        } else {
          idxStart = i;
        }
      }
    }

    return res;
  }
}

class Route {
  private int id;
  private int distance;

  Route(int id, int distance) {
    this.id = id;
    this.distance = distance;
  }

  int getId() {
    return id;
  }

  int getDistance() {
    return distance;
  }
}