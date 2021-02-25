package hashcode.y21.qualify.io;


import hashcode.y21.qualify.dto.Input;
import hashcode.y21.qualify.dto.InputType;
import hashcode.y21.qualify.dto.Output;
import lombok.SneakyThrows;
import lombok.val;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static util.StringUtils.stringBuilderToBytes;

public class IOHelper {
    public static final String FOLDER_PATH = "problems/src/main/resources/hashcode/y21/qualify/";

    @SneakyThrows
    public Input parse(final InputType inputType) {
        val path = FOLDER_PATH + "input/" + inputType.getFileName() + ".in";

        try (val br = new BufferedReader(new FileReader(path))) {


            return new Input();
        }
    }

    @SneakyThrows
    public void write(final Output output, final InputType inputType) {
        val path = FOLDER_PATH + "output/" + inputType.getFileName() + ".out";

        val sb = new StringBuilder();

        Files.write(Paths.get(path), stringBuilderToBytes(sb));
    }
}
