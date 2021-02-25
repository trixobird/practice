package hashcode.y21.qualify;

import hashcode.y21.qualify.dto.Input;
import hashcode.y21.qualify.dto.InputType;
import hashcode.y21.qualify.dto.Output;
import hashcode.y21.qualify.io.IOHelper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public final class App {
    public static void main(final String[] args) {

        final IOHelper ioHelper = new IOHelper();
        final Algorithm algorithm = new Algorithm();

        runOne(ioHelper, algorithm, InputType.EXAMPLE);
//        runAll(ioHelper, algorithm);
    }

    private static void runOne(final IOHelper ioHelper, final Algorithm algorithm, final InputType inputType) {
        final Input input = ioHelper.parse(inputType);
        final Output output = algorithm.compute(input);
        ioHelper.write(output, InputType.EXAMPLE);
    }

    private static void runAll(final IOHelper ioHelper, final Algorithm algorithm) {
        Arrays.stream(InputType.values()).forEach(inputType -> {
            log.debug("Running {}", inputType);
            final Input input = ioHelper.parse(inputType);
            final Output output = algorithm.compute(input);
            ioHelper.write(output, inputType);
        });

    }
}
