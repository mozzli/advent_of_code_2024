package day_2;

import day_2.utilities.DataReader;

public class Main {
    public static void main(String[] args){
        System.out.println("Safe reports: " + new Solution().getSafeNumber(new DataReader().getReportList()));
        System.out.println("Safe reports with tolerance: " + new Solution().getSafeNumberTolerant(new DataReader().getReportList()));
    }
}
