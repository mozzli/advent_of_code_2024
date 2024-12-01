package day_1;

import day_1.utilities.DataReader;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("Cumulated distance is: " + new Solution().getCumulatedDistance(new DataReader().getIdPack()));
        System.out.println("Similarity score is: " + new Solution().getSimilarityScore(new DataReader().getIdPack()));
        long endTime = System.nanoTime();
        System.out.println("time: " + ((endTime - startTime) / 1000000) + " ms");
    }
}
