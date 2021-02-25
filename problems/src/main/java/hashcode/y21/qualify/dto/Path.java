package hashcode.y21.qualify.dto;

import lombok.Value;

import java.util.List;

@Value
public class Path {
    int start;
    List<String> streets;
}
