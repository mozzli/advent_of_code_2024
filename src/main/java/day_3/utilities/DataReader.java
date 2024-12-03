package day_3.utilities;

import day_3.Multiplier;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {

    public ArrayList<Multiplier> getMultiplierList(String text, boolean switchEnabled) {
        ArrayList<Multiplier> multipliers = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;

        if (switchEnabled) {
            pattern = Pattern.compile("don't\\(\\)(?:(?!do\\(\\)).)*do\\(\\)");
            matcher = pattern.matcher(text);
            while (matcher.find()) text = text.replace(matcher.group(), "");
        }

        pattern = Pattern.compile("mul\\(([0-99]+),([0-99]+)\\)");
        matcher = pattern.matcher(text);
        while (matcher.find()) multipliers.add(new Multiplier(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
        return multipliers;
    }
}
