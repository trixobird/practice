package hashcode.y21.practice.io;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InputType {

    EXAMPLE("a_example"),
    LITTLE_BIT_OF_EVERYTHING("b_little_bit_of_everything.in"),
    MANY_INGREDIENTS("c_many_ingredients.in"),
    MANY_PIZZAS("d_many_pizzas.in"),
    MANY_TEAMS("e_many_teams.in");

    private final String fileName;
}
