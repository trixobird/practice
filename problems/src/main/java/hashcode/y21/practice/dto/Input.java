package hashcode.y21.practice.dto;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class Input {
    Map<Integer, Integer> teams; // key: people in team, value: count
    List<Pizza> pizzas;
}
