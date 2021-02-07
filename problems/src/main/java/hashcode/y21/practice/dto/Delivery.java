package hashcode.y21.practice.dto;

import lombok.Value;

import java.util.List;

@Value
public class Delivery {
    int numberOfTeamMembers;
    List<Long> pizzas;
}
