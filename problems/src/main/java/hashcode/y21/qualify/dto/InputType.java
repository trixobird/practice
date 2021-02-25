package hashcode.y21.qualify.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InputType {

    EXAMPLE("a_example"),
    BY_THE_OCEAN("b_by_the_ocean"),
    CHECKMATE("c_checkmate"),
    DAILY_COMMUTE("d_daily_commute"),
    ETOILE("e_etoile"),
    FOREVER_JAMMED("f_forever_jammed");

    private final String fileName;
}
