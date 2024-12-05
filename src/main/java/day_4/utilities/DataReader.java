package day_4.utilities;

import utilities.Utility;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DataReader {

    public HashMap<Point, String> getXmasMap() {
        HashMap<Point, String> xmasMap = new HashMap<>();
        ArrayList<String> lines = Utility.getLines("src/main/java/day_4/input/input.txt");
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                xmasMap.put(new Point(i, j), lines.get(i).substring(j, j + 1));
            }
        }
        return xmasMap;
    }
}
