package org.godDamnElves.dayOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//INCOMPLETE

public class PartTwo {

    private static final List<Integer> intList = new ArrayList<>();

    public int updatedCalibrationSum(String filePath) throws IOException {
        try (BufferedReader buffReader = Files.newBufferedReader(Path.of(filePath)); Stream<String> lines = buffReader.lines()) {
            lines.forEach(line -> {
                String[] swappedAndCleanedLine = swapNameWithNum(line).replaceAll("\\D", "").split("");
                intList.add(Integer.parseInt(swappedAndCleanedLine[0] + swappedAndCleanedLine[swappedAndCleanedLine.length - 1]));
            });
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
        return intList.stream().reduce(0, Integer::sum);
    }

    public String swapNameWithNum(String input) {
        return input
                .replaceAll("one", "one1one")
                .replaceAll("two", "two2two")
                .replaceAll("three", "three3three")
                .replaceAll("four", "four4four")
                .replaceAll("five", "five5five")
                .replaceAll("six", "six6six")
                .replaceAll("seven", "seven7seven")
                .replaceAll("eight", "eight8eight")
                .replaceAll("nine", "nine9nine");
    }
}