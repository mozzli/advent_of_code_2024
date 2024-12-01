package day_1;

import day_1.utilities.DataReader;
import day_1.utilities.IdPack;

public class Main {
    public static void main(String[] args){
        IdPack idPack = new DataReader().getIdPack();
        Solution solution = new Solution();
        System.out.println("Cumulated distance is: " + solution.getCumulatedDistance(idPack));
        System.out.println("Similarity score is: " + solution.getSimilarityScore(idPack));
    }
}
