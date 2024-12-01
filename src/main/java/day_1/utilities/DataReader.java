package day_1.utilities;

import utilities.Utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {

    public IdPack getIdPack(){
        ArrayList<String> lines = Utility.getLines("src/main/java/day_1/input/input.txt");
        ArrayList<Integer> leftIds = new ArrayList<>();
        ArrayList<Integer> rightIds = new ArrayList<>();
        Pattern pattern = Pattern.compile("([10-99]+)\\s+([10-99]+)");
        for (String line:lines){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                leftIds.add(Integer.valueOf(matcher.group(1)));
                rightIds.add(Integer.valueOf(matcher.group(2)));
            }
        }
        return new IdPack(leftIds,rightIds);

    }
}
