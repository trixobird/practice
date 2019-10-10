package interview.other;

import java.util.List;
import org.junit.Test;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class FlightsTest {

  @Test
  public void optimalUtilization() {

    List<List<Integer>> forwardRouteList = asList(asList(1, 10), asList(2, 12), asList(3, 8), asList(4, 4), asList(5, 7), asList(6, 13));
    List<List<Integer>> returnRouteList = asList(asList(1, 7), asList(2, 11), asList(3, 9), asList(4, 4), asList(5, 6), asList(6, 2), asList(7, 12));

    List<List<Integer>> routes = new Flights().optimalUtilization(20, forwardRouteList, returnRouteList);
    assertEquals(2, routes.size());
    assertEquals(3, (int)routes.get(0).get(0));
    assertEquals(7, (int)routes.get(0).get(1));
    assertEquals(6, (int)routes.get(1).get(0));
    assertEquals(1, (int)routes.get(1).get(1));
  }
}