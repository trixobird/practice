package hashcode.y21.qualify;

import hashcode.y21.qualify.dto.Input;
import hashcode.y21.qualify.dto.Intersection;
import hashcode.y21.qualify.dto.Output;
import hashcode.y21.qualify.dto.TrafficLight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class Algorithm {
    public Output compute(final Input input) {
        final Map<Integer, Intersection> integerIntersectionMap = new HashMap<>();
        input.getStreets().forEach(s -> {
            if (integerIntersectionMap.containsKey(s.getFinish())) {
                final Intersection intersection = integerIntersectionMap.get(s.getFinish());
                intersection.setCount(intersection.getCount() + 1);
                intersection.getStreets().add(s.getName());
            } else {
                List<String> streets = new LinkedList<>();
                streets.add(s.getName());
                integerIntersectionMap.put(s.getFinish(), new Intersection(1, streets));
            }
        });

        Map<Integer, List<TrafficLight>> trafficLightsPerIntersection = new HashMap<>();
        integerIntersectionMap.forEach((k, v) -> {
            final List<TrafficLight> trafficLights = v.getStreets().stream().map(s -> new TrafficLight(s, 1)).collect(Collectors.toList());
            trafficLightsPerIntersection.put(k, trafficLights);
        });
        return new Output(trafficLightsPerIntersection);
    }
}
