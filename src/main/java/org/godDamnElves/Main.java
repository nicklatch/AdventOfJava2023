package org.godDamnElves;

import org.godDamnElves.dayOne.PartOne;
import org.godDamnElves.dayOne.PartTwo;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        PartTwo partTwo = new PartTwo();
        System.out.println(partTwo.updatedCalibrationSum("src/main/resources/dayOnePartOneData.txt"));
    }
}