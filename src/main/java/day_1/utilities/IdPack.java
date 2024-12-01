package day_1.utilities;

import java.util.ArrayList;
import java.util.Collections;

public record IdPack(ArrayList<Integer> leftIds, ArrayList<Integer> rightIds) {

    public IdPack sortLeftIds() {
        Collections.sort(leftIds);
        return this;
    }

    public IdPack sortRightIds() {
        Collections.sort(rightIds);
        return this;
    }

}
