package day_2.utilities;

import day_2.Report;
import utilities.Utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {

    public ArrayList<Report> getReportList(){
        ArrayList<String> lines = Utility.getLines("src/main/java/day_2/input/sampleInput.txt");
        ArrayList<Report> reports = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-99]+");
        for (String line: lines){
            Matcher matcher = pattern.matcher(line);
            ArrayList<Integer> numbers = new ArrayList<>();
            while(matcher.find()){
                numbers.add(Integer.valueOf(matcher.group()));
            }
            reports.add(new Report(numbers));
        }
        return reports;
    }
}
