package day_5.utilities;

import utilities.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DataReader {

    private final ArrayList<String> lines = Utility.getLines("src/main/java/day_5/input/input.txt");

    public HashMap<Integer, ArrayList<Integer>> getRulebook() {
        Pattern pattern = Pattern.compile("(\\d+)\\|(\\d+)");
        HashMap<Integer, ArrayList<Integer>> rulebook = new HashMap<>();
        for (String line : lines) {
            Matcher matcher =pattern.matcher(line);
            while (matcher.find()){
                if (!rulebook.containsKey(parseInt(matcher.group(2)))) rulebook.put(parseInt(matcher.group(2)), new ArrayList<>(List.of(parseInt(matcher.group(1)))));
                else rulebook.get(parseInt(matcher.group(2))).add(parseInt(matcher.group(1)));
            }
        }
        return rulebook;
    }

    public ArrayList<ArrayList<Integer>> getNumberList(){
        ArrayList<ArrayList<Integer>> numbersList = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\d+,.*\\d+$");
        for (String line : lines){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                ArrayList<Integer> numbers = new ArrayList<>();
                String match = matcher.group();
                while(!match.isEmpty()){
                    numbers.add(parseInt(match.substring(0,2)));
                    if (match.contains(",")){
                        match = match.substring(3);
                    }else break;
                }
                numbersList.add(numbers);
            }
        }
        return numbersList;
    }
}
