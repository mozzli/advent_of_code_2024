package day_2;

import lombok.Getter;

import java.util.ArrayList;

import static day_2.ReportLevels.*;
import static day_2.ReportStatus.NOT_SAFE;
import static day_2.ReportStatus.SAFE;

public class Report {

    private final ArrayList<Integer> numbers;
    @Getter
    private final ReportStatus isSafe;
    @Getter
    private final ReportStatus isSafeTolerant;

    public Report(ArrayList<Integer> numbers) {
        this.numbers = numbers;
        isSafe = checkIsSafe(numbers);
        isSafeTolerant = checkIsSafeWithErrorTolerance();
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
        if (checkIsSafe(numbers) == NOT_SAFE) {
            for (int i = 0; i < numbers.size(); i++) {
                ArrayList<Integer> slicedArray = new ArrayList<>(numbers);
                slicedArray.remove(i);
                if (checkIsSafe(slicedArray) == NOT_SAFE) {
                    if (i == numbers.size() - 1) {
                        return NOT_SAFE;
                    }
                } else return SAFE;
            }
        }
        return SAFE;
    }

    private ReportLevels getReportLevel(int i) {
        if (i < 0) return INCREASING;
        else if (i > 0) return DECREASING;
        else return SAME;
    }
}
