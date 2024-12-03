package day_3;

import java.util.ArrayList;

public class Solution {

    public int getMultiplierSum(ArrayList<Multiplier> multipliers) {
        return (int) multipliers.stream().mapToLong(x -> x.result).sum();
    }
}
