package hashcode.y21.qualify.dto;

import lombok.Value;

@Value
public class Street {
    int start;
    int finish;
    String name;
    int distanceInSeconds;
}
