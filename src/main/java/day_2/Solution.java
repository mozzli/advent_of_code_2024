package day_2;

import java.util.ArrayList;

class Solution {

    public int getSafeNumber(ArrayList<Report> reports){
        return (int) reports.stream().filter(x -> x.getIsSafe() == ReportStatus.SAFE).count();
    }

    public int getSafeNumberTolerant(ArrayList<Report> reports){
        return (int) reports.stream().filter(x -> x.getIsSafeTolerant() == ReportStatus.SAFE).count();
    }
}
