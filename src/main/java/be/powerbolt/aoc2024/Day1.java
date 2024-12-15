package be.powerbolt.aoc2024;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Day1 {

    public Day1(){

    }

    public void run(){
        File inputFile = null;
        List<String> lines = null;

        List<Integer> leftColumn = new ArrayList<>();
        List<Integer> rightColumn = new ArrayList<>();

        try {
            inputFile = new File(getClass().getClassLoader().getResource("input/day1/input.txt").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        if(inputFile.isFile()){
            System.out.println("File read");
        }

        try {
            lines = Files.readAllLines(inputFile.getAbsoluteFile().toPath());
            System.out.println("Lines: " + lines.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String line : lines) {
            String[] splits = line.split(" {3}");
            int left = Integer.parseInt(splits[0]);
            int right = Integer.parseInt(splits[1]);

            leftColumn.add(left);
            rightColumn.add(right);
        }

        Collections.sort(leftColumn);
        Collections.sort(rightColumn);

        // calculate the space between
        int total= 0;
        for(int i = 0; i < leftColumn.size();i++) {
            int distance = Math.abs(rightColumn.get(i) - leftColumn.get(i));
            total += distance;
        }

        System.out.println("Total distance is: " + total);
    }
}
