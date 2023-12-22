package org.godDamnElves.dayTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartOne {

  public static void main(String[] args) throws IOException {
    System.out.println(fileHandler("src/main/resources/dayTwoPartOneData.txt"));
  }

  public static int fileHandler(String filePath) throws IOException {
    List<Integer> validSum = new ArrayList<>();

    try (BufferedReader reader = Files.newBufferedReader(
        Path.of(filePath)); Stream<String> lines = reader.lines()) {

      lines.forEach(line -> {
        var id = idExtractor(line.substring(0, line.indexOf(":")).trim());
        if (!validityChecker(gameParser(line))) {
          validSum.add(Integer.parseInt(id));
        }
      });
    } catch (IOException eIO) {
      eIO.printStackTrace();
      throw new IOException("File not found or something else, man", eIO);
    }
    return validSum.stream().reduce(0, Integer::sum);
  }

  public static List<List<String>> gameParser(String game) {

    String gameInfo = game.substring(game.indexOf(": ") + 1).trim();

    List<String> splitGames = Arrays.stream(gameInfo.split(";\\s")).toList();

    return splitGames.stream().map(g -> Arrays.stream(g.split(", ")).collect(Collectors.toList()))
        .toList();

  }

  public static String idExtractor(String part) {
    return part.split("\\s")[1];
  }

  public static boolean validityChecker(List<List<String>> games) {
    List<List<Boolean>> valid = new ArrayList<>();

    games.forEach(game -> {
      List<Boolean> collect = game.stream().map(blocks -> {
        var blockSplit = blocks.trim().split(" ");
        return switch (blockSplit[1].trim()) {
          case "red" -> Integer.parseInt(blockSplit[0].trim()) <= 12;
          case "green" -> Integer.parseInt(blockSplit[0].trim()) <= 13;
          case "blue" -> Integer.parseInt(blockSplit[0].trim()) <= 14;
          default -> false;
        };
      }).collect(Collectors.toList());
      valid.add(collect);
    });

    return valid.stream().flatMap(Collection::stream).toList().contains(false);
  }


}
