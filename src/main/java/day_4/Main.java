package day_4;

import day_4.utilities.DataReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("\"xmas\" amount is: " + new Solution().getXmasAmount(new DataReader().getXmasMap()));
        System.out.println("\"x-mas\" amount is: " + new Solution().getMasAmount(new DataReader().getXmasMap()));
    }
}
