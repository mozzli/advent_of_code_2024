package day_1;

import day_1.utilities.IdPack;

public class Solution {

    public int getCumulatedDistance(IdPack pack) {
        int cumulatedDistance = 0;
        pack.sortRightIds().sortLeftIds();
        for (int i = 0; i < pack.leftIds().size(); i++) {
            int leftId = pack.leftIds().get(i);
            int rightId = pack.rightIds().get(i);
            if (leftId > rightId) {
                cumulatedDistance += leftId - rightId;
            } else if (leftId < rightId) {
                cumulatedDistance += rightId - leftId;
            }
        }
        return cumulatedDistance;
    }

    public int getSimilarityScore(IdPack pack) {
        int similarityScore = 0;
        for (int id : pack.leftIds()) {
            int numberOfOccurrences = 0;
            for (int i = 0; i < pack.rightIds().size(); i++) {
                if (id == pack.rightIds().get(i)) {
                    numberOfOccurrences++;
                }
            }
            similarityScore += id * numberOfOccurrences;
        }
        return similarityScore;
    }
}
