package hashcode.y21.practice.dto;

import lombok.Value;

import java.util.Set;

@Value
public class Pizza {
    Long id;
    Set<String> ingredients;
}
