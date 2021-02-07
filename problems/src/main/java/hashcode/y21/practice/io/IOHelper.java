package hashcode.y21.practice.io;

import hashcode.y21.practice.dto.Input;
import hashcode.y21.practice.dto.Output;
import hashcode.y21.practice.dto.Pizza;
import lombok.SneakyThrows;
import lombok.val;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IOHelper {
    public static final String FOLDER_PATH = "problems/src/main/resources/hashcode/y21/practice/";

    @SneakyThrows
    public Input parse(final InputType inputType) {
        val path = FOLDER_PATH + "input/" + inputType.getFileName();

        try (val br = new BufferedReader(new FileReader(path))) {

            final Map<Integer, Integer> teams = new HashMap<>();
            final String[] teamCounts = br.readLine().split(" ");
            for (int i = 1; i < teamCounts.length; i++) {
                teams.put(i + 1, Integer.parseInt(teamCounts[i]));
            }

            val pizzas = new ArrayList<Pizza>();
            String line;
            var id = 0L;
            while ((line = br.readLine()) != null) {
                val ingredients = Arrays.stream(line.split(" "))
                        .skip(1)
                        .collect(Collectors.toSet());
                pizzas.add(new Pizza(id, ingredients));
                id++;
            }

            return new Input(teams, pizzas);
        }
    }

    @SneakyThrows
    public void write(final Output output, final InputType inputType) {
        val path = FOLDER_PATH + "output/" + inputType.getFileName();

        val sb = new StringBuilder();
        sb.append(output.getDeliveries().size()).append("\n");
        output.getDeliveries().forEach(d -> {
            sb.append(d.getNumberOfTeamMembers());
            d.getPizzas().forEach(p -> sb.append(" ").append(p));
            sb.append("\n");
        });


        Files.write(Paths.get(path), stringBuilderToBytes(sb));
    }

    @SneakyThrows
    public byte[] stringBuilderToBytes(final StringBuilder sb) {
        Charset charset = StandardCharsets.US_ASCII;
        CharsetEncoder encoder = charset.newEncoder();
        CharBuffer buffer = CharBuffer.wrap(sb);
        ByteBuffer byteBuffer = encoder.encode(buffer);

        byte[] array;
        int arrayLen = byteBuffer.limit();
        if (arrayLen == byteBuffer.capacity()) {
            array = byteBuffer.array();
        } else {
            // This will place two copies of the byte sequence in memory,
            // until byteBuffer gets garbage-collected (which should happen
            // pretty quickly once the reference to it is null'd).

            array = new byte[arrayLen];
            byteBuffer.get(array);
        }
        return array;
    }
}
