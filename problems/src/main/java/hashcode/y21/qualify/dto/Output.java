package hashcode.y21.qualify.dto;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class Output {
    Map<Integer, List<TrafficLight>> trafficLightsPerIntersection;
}
