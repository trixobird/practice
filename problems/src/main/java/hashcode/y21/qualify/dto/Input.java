package hashcode.y21.qualify.dto;

import lombok.Value;

import java.util.Set;

@Value
public class Input {
    int simulationDuration;
    int numberOfIntersection;
    int numberOfCars;
    int bonusPoints;
    Set<Street> streets;
    Set<Path> paths;
}
