package day_4;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public long getXmasAmount(HashMap<Point, String> map) {
        return map.keySet().stream().mapToLong(point -> lookForXmas(map, point)).sum();
    }

    public long getMasAmount(HashMap<Point, String> map) {
        return map.keySet().stream().filter(point -> map.get(point).equals("A") && checkIsMas(map, point)).count();
    }

    private boolean findNextLetter(Directions dir, HashMap<Point, String> map, Point point, StringBuilder string) {
        String xmas = "XMAS";
        if (string.length() >= 4) return string.toString().equals("XMAS");
        String currentString = string.substring(string.length() - 1);
        String currentXmas = xmas.substring(string.length() - 1, string.length());
        Point newPoint;
        if (currentString.equals(currentXmas)) {
            switch (dir) {
                case UP -> newPoint = new Point(point.x + 1, point.y);
                case DOWN -> newPoint = new Point(point.x - 1, point.y);
                case LEFT -> newPoint = new Point(point.x, point.y - 1);
                case RIGHT -> newPoint = new Point(point.x, point.y + 1);
                case UP_LEFT -> newPoint = new Point(point.x + 1, point.y - 1);
                case UP_RIGHT -> newPoint = new Point(point.x + 1, point.y + 1);
                case DOWN_LEFT -> newPoint = new Point(point.x - 1, point.y - 1);
                case DOWN_RIGHT -> newPoint = new Point(point.x - 1, point.y + 1);
                default -> throw new RuntimeException("Error. Wrong direction");
            }
            string.append(map.get(newPoint));
            return findNextLetter(dir, map, newPoint, string);
        }
        return false;
    }

    private boolean checkIsMas(HashMap<Point, String> map, Point point) {
        ArrayList<String> diagonal1 = new ArrayList<>(Arrays.asList(map.get(new Point(point.x - 1, point.y - 1)), map.get(new Point(point.x + 1, point.y + 1))));
        ArrayList<String> diagonal2 = new ArrayList<>(Arrays.asList(map.get(new Point(point.x - 1, point.y + 1)), map.get(new Point(point.x + 1, point.y - 1))));
        return diagonal1.containsAll(new ArrayList<>(Arrays.asList("S", "M"))) && diagonal2.containsAll(new ArrayList<>(Arrays.asList("S", "M")));
    }

    private long lookForXmas(HashMap<Point, String> map, Point point) {
        if (!map.get(point).equals("X")) return 0;
        return Arrays.stream(Directions.values()).filter(dir -> findNextLetter(dir, map, point, new StringBuilder(map.get(point)))).count();
    }

    private enum Directions {
        UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;
    }
}
