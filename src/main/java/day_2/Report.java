package day_2;

import lombok.Getter;

import java.util.ArrayList;

import static day_2.ReportLevels.*;
import static day_2.ReportStatus.NOT_SAFE;
import static day_2.ReportStatus.SAFE;

public class Report {

    private final ArrayList<Integer> numbers;
    @Getter
    private ReportStatus isSafe;

    public Report(ArrayList<Integer> numbers) {
        this.numbers = numbers;
        isSafe = checkIsSafeWithErrorTolerance();
    }

    private ReportStatus checkIsSafe(ArrayList<Integer> numbers) {
        ReportLevels level = null;
        for (int i = 0; i < numbers.size() - 1; i++) {
            int subtractScore = numbers.get(i) - numbers.get(i + 1);
            if (level == null) level = getReportLevel(subtractScore);
            if (Math.abs(subtractScore) > 3 || level == SAME || getReportLevel(subtractScore) != level) {
                return NOT_SAFE;
            }
        }
        return SAFE;
    }

    private ReportStatus checkIsSafeWithErrorTolerance() {
        ReportLevels level = null;
        ArrayList<Integer> slicedList = new ArrayList<>(numbers);
        for (int i = 0; i < numbers.size() - 1; i++) {
            int subtractScore = numbers.get(i) - numbers.get(i + 1);
            if (level == null) level = getReportLevel(subtractScore);
            if (Math.abs(subtractScore) > 3 || level == SAME || getReportLevel(subtractScore) != level) {
                slicedList.remove(i);
                return checkIsSafe(slicedList);
            }
        }
        return SAFE;
    }

    private ReportLevels getReportLevel(int i){
        if (i < 0) return INCREASING;
        else if (i > 0) return DECREASING;
        else return SAME;
    }


}
