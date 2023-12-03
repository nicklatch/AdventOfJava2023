package org.godDamnElves.dayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

//INCOMPLETE

public class PartTwo {

    private static final Map<String, Integer> intMap = Map.of("one", 1, "two", 2, "three", 3, "four", 4, "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9);

    private static final List<Integer> intList = new ArrayList<>();

    public int updatedCalibrationSum(String filePath) throws IOException {
        try (BufferedReader buffReader = Files.newBufferedReader(Path.of(filePath)); Stream<String> lines = buffReader.lines()) {
            lines.forEach(line -> {
                String swappedLine = swapNameWithNum(line);
                var cleanedLine = swappedLine.replaceAll("\\D", "").split("");
                intList.add(Integer.parseInt(cleanedLine[0] + cleanedLine[cleanedLine.length - 1]));
            });
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
        System.out.println(intList.toString());
        return intList.stream().reduce(0, Integer::sum);
    }

    public String swapNameWithNum(String input) {
        Set<Map.Entry<String, Integer>> entrySet = intMap.entrySet();
        String updatedInput = "";

        for (final Map.Entry<String, Integer> entry : entrySet) {
            if (input.contains(entry.getKey())) {
                updatedInput = input.replaceAll(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return updatedInput;
    }
}