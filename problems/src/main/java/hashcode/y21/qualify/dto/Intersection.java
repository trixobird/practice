package hashcode.y21.qualify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Intersection {
    long count;
    List<String> streets;
}
