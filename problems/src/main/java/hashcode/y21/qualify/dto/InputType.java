package hashcode.y21.qualify.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InputType {

    EXAMPLE("a_example");

    private final String fileName;
}
