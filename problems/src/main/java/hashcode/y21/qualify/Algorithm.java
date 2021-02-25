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
import java.util.function.Function;
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

        final Map<String, Long> carsPerStreet = input.getPaths().stream()
                .map(p -> new LinkedList<>(p.getStreets()))
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Integer, List<TrafficLight>> trafficLightsPerIntersection = new HashMap<>();
        integerIntersectionMap.forEach((k, v) -> {
            List<TrafficLight> trafficLights = new LinkedList<>();
            final List<String> streetsWithCars = v.getStreets().stream().filter(carsPerStreet::containsKey).collect(Collectors.toList());
            if (streetsWithCars.size() > 1) {
                final long totalCarsInIntersection = streetsWithCars.stream().mapToLong(carsPerStreet::get).sum();
                for (final String street : streetsWithCars) {
                    final int secondsGreen = (int)Math.ceil((carsPerStreet.get(street) / (double) totalCarsInIntersection) * 10);
                    trafficLights.add(new TrafficLight(street, secondsGreen));
                }
            } else {
                trafficLights = v.getStreets().stream().map(s -> new TrafficLight(s, 1)).collect(Collectors.toList());
            }

            trafficLightsPerIntersection.put(k, trafficLights);
        });
        return new Output(trafficLightsPerIntersection);
    }
}
