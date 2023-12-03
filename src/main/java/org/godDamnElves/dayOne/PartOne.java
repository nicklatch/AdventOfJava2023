package org.godDamnElves.dayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PartOne {

    private static final List<Integer> intList = new ArrayList<>();

    public int calibrationSum(String filePath) throws IOException {
        try (BufferedReader buffReader = Files.newBufferedReader(Path.of(filePath)); Stream<String> lines = buffReader.lines()) {
            lines.forEach(line -> {
                var cleanedLine = line.replaceAll("\\D", "").split("");
                intList.add(Integer.parseInt(cleanedLine[0] + cleanedLine[cleanedLine.length - 1]));
            });
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }

        return intList.stream().reduce(0, Integer::sum);
    }
}
