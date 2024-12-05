package day_5;

import day_5.utilities.DataReader;

public class Main {
    public static void main(String[] args){
        System.out.println("Correctly ordered updates: " + new Solution(new DataReader().getRulebook())
                .getCentralSum(new DataReader().getNumberList(), true));
        System.out.println("Incorrectly ordered updates: " + new Solution(new DataReader().getRulebook())
                .getCentralSum(new DataReader().getNumberList(), false));
    }
}
