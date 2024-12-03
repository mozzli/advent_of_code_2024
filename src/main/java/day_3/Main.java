package day_3;

import day_3.utilities.DataReader;

import static utilities.Utility.getStringFromText;

public class Main {

    public static void main(String[] args){
        System.out.println("First task solution: " + new Solution()
                .getMultiplierSum(new DataReader()
                        .getMultiplierList(getStringFromText("src/main/java/day_3/input/input.txt"),false)));

        System.out.println("Second task solution: " + new Solution()
                .getMultiplierSum(new DataReader()
                        .getMultiplierList(getStringFromText("src/main/java/day_3/input/input.txt"),true)));
    }
}
