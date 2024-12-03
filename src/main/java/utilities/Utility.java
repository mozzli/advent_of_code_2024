package utilities;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Utility {
    @SneakyThrows
    public static ArrayList<String> getLines(String textSource){
        String line;
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader(textSource));
        while ((line = text.readLine()) != null) lines.add(line);
        return lines;
    }

    @SneakyThrows
    public static String getStringFromText(String textSource){
        String line;
        StringBuilder fullText = new StringBuilder();
        BufferedReader text = new BufferedReader(new FileReader("src/main/java/day_3/input/input.txt"));
        while ((line = text.readLine()) != null) fullText.append(line);
        return fullText.toString();
    }
}
