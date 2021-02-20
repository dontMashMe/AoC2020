package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThree {
    private static List<String> loadData() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\TurdNibbler\\IdeaProjects\\AdventOfCode2020\\src\\com\\company\\Inputs\\DayThreeInput.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("errrrrroorr" + e);
            e.printStackTrace();
        }
        return lines;
    }

    public static int PartOne() {
        List<String> grid = loadData();
        int trees = 0;
        int horizonPosition = 0;
        for (int i = 1; i < grid.size(); i++) {
            horizonPosition += 3; //krece se 3 desno 1 dolje
            if (horizonPosition > grid.get(i).length() - 1) { //provjeri jesi dosao do ruba input grida
                horizonPosition = horizonPosition - grid.get(i).length();
            }
            if (grid.get(i).charAt(horizonPosition) == '#') {
                trees++;
            }
        }
        return trees;
    }
    //part dva je zapravo part 1, ali sa razlicitim start pozicijama

    public static long PartTwo() {
        List<String> grid = loadData();
        long trees = calcTravel(grid, 1, 1);
        trees = trees * calcTravel(grid, 3, 1);
        trees = trees * calcTravel(grid, 5, 1);
        trees = trees * calcTravel(grid, 7, 1);
        trees = trees * calcTravel(grid, 1, 2);
        return trees;
    }

    //skoro ista metoda kao PartOne, osim sto je petlja izmjenjena
    public static int calcTravel(List<String> lines, int right, int down) {
        int trees = 0;
        int horizonPos = 0;
        for (int i = down; i < lines.size(); i += down) {
            horizonPos += right;
            if (horizonPos > lines.get(i).length() - 1) {
                horizonPos = horizonPos - lines.get(i).length();
            }
            if (lines.get(i).charAt(horizonPos) == '#') {
                trees++;
            }
        }
        return trees;
    }
}
