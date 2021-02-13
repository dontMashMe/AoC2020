package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DayTwo {

    //input parser
    public static List<String[]> readInput() throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\TurdNibbler\\IdeaProjects\\AdventOfCode2020\\src\\com\\company\\Inputs\\DayTwoInpt.txt"));
        List<String[]> output = new ArrayList<>();
        while(input.hasNext()){
            String[] tokens = input.nextLine().split("\n");
            output.add(tokens);
        }
        return output;
    }
    public static int AnswerOneStar() throws FileNotFoundException {
        int validPasswordCounter = 0;
        List<String[]> input = readInput();
        for (String[] tokenAtArray : input) {
            String tokenAt = Arrays.toString(tokenAtArray);
            tokenAt = tokenAt.replaceAll("(^\\[|]$)", ""); //makni [] iz stringa
            int minNumbIndex = tokenAt.indexOf("-");
            int minNumber = Integer.parseInt(tokenAt.substring(0, minNumbIndex)); //znakovi do '-'

            int maxNumberIndex = tokenAt.indexOf(" ");       //prvi razmak nakon '-'
            int maxNumber = Integer.parseInt(tokenAt.substring(minNumbIndex+1, maxNumberIndex)); //znakovi od '-' do ' '
            //System.out.println(minNumber + ":" + maxNumber);

            String needleS = tokenAt.substring(maxNumberIndex+1, maxNumberIndex+2); //trazena znamenka
            char needle = needleS.charAt(0);
            //System.out.println(needle);
            int loopStart = tokenAt.indexOf(":") + 2; //od ':' preskoci jedno prazno mjesto, + 1 za nultu znamenku trazenog stringa (+2 offset sveukupno)
            int counter = 0;
            for(int i = loopStart; i < tokenAt.length(); i++){
                if(tokenAt.charAt(i) == needle) counter++;
            }
            if(counter >= minNumber && counter <= maxNumber) validPasswordCounter++;
        }

        return validPasswordCounter;
    }

    public static int AnswerTwoStar() throws FileNotFoundException{
        int validPasswordCounter = 0;
        List<String[]> input = readInput();
        for(String[] tokenAtArray : input){
            String tokenAt = Arrays.toString(tokenAtArray);
            tokenAt = tokenAt.replaceAll("(^\\[|]$)", "");
            int minNumbIndex = tokenAt.indexOf("-");
            int minNumber = Integer.parseInt(tokenAt.substring(0, minNumbIndex));

            int maxNumberIndex = tokenAt.indexOf(" ");
            int maxNumber = Integer.parseInt(tokenAt.substring(minNumbIndex+1, maxNumberIndex));
            String needleS = tokenAt.substring(maxNumberIndex+1, maxNumberIndex+2);
            char needle = needleS.charAt(0);
            int loopStart = tokenAt.indexOf(":") + 2;

            String searchSubstring = tokenAt.substring(loopStart);
            //-1 jer u zadatku se pozicije indeksiraju od 1
            if(searchSubstring.charAt(maxNumber-1) == needle && searchSubstring.charAt(minNumber-1) != needle) {
                validPasswordCounter++;
            }
            else if(searchSubstring.charAt(minNumber-1) == needle && searchSubstring.charAt(maxNumber-1) != needle){
                validPasswordCounter++;
            }

        }
        return validPasswordCounter;
    }

}
