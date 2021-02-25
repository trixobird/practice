package hashcode.y21.qualify.io;


import hashcode.y21.practice.dto.Pizza;
import hashcode.y21.qualify.dto.*;
import lombok.SneakyThrows;
import lombok.val;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static util.StringUtils.stringBuilderToBytes;

public class IOHelper {
    public static final String FOLDER_PATH = "problems/src/main/resources/hashcode/y21/qualify/";

    @SneakyThrows
    public Input parse(final InputType inputType) {
        val path = FOLDER_PATH + "input/" + inputType.getFileName() + ".in";

        try (val br = new BufferedReader(new FileReader(path))) {
            final String[] initial = br.readLine().split(" ");
            final int simulationDuration = Integer.parseInt(initial[0]);
            final int numberOfIntersection = Integer.parseInt(initial[1]);
            final int numberOfStreets = Integer.parseInt(initial[2]);
            final int numberOfCars = Integer.parseInt(initial[3]);
            final int bonusPoints = Integer.parseInt(initial[4]);

            Set<Street> streets = new HashSet<>();
            for (int i = 0; i < numberOfStreets; i++) {
                final String[] street = br.readLine().split(" ");
                streets.add(new Street(Integer.parseInt(street[0]), Integer.parseInt(street[1]), street[2], Integer.parseInt(street[3])));
            }

            Set<Path> paths = new HashSet<>();
            for (int i = 0; i < numberOfCars; i++) {
                final String[] street = br.readLine().split(" ");
                val streetsInPath = Arrays.stream(street)
                        .skip(1)
                        .collect(Collectors.toList());
                paths.add(new Path(Integer.parseInt(street[0]), streetsInPath));
            }
            return new Input(simulationDuration, numberOfIntersection, numberOfCars, bonusPoints, streets, paths);
        }
    }

    @SneakyThrows
    public void write(final Output output, final InputType inputType) {
        val path = FOLDER_PATH + "output/" + inputType.getFileName() + ".out";

        val sb = new StringBuilder();
        sb.append(output.getTrafficLightsPerIntersection().size()).append("\n");
        output.getTrafficLightsPerIntersection().forEach((k, v) -> {
            sb.append(k).append("\n");
            sb.append(v.size()).append("\n");
            for (final TrafficLight trafficLight : v) {
                sb.append(trafficLight.getStreet()).append(" ");
                sb.append(trafficLight.getDurationInSeconds()).append("\n");
            }
        });

        Files.write(Paths.get(path), stringBuilderToBytes(sb));
    }
}
