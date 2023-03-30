package velykyi.vladyslav.codeWars.level2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

@SuppressWarnings("unused")
public class KataApp {

    /**
     * Method to test KATA tasks
     * @param args ignored
     */
    public static void main(String[] args) {

    }

    /**
     * In this little assignment you are given a string of space separated numbers,
     * and have to return the highest and lowest number.
     */
    public static String highAndLow(String numbers) {
        String space = " ";
        IntSummaryStatistics statistics =
                Arrays.stream(numbers.split(space)).mapToInt(Integer::parseInt).summaryStatistics();

        return statistics.getMax() + space + statistics.getMin();
    }
}
