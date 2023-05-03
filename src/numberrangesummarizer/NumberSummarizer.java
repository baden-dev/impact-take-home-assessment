package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberSummarizer implements NumberRangeSummarizer{

    /**
     * Collects a comma-separated string of integers and returns a collection of integers.
     *
     * @param input the comma-separated string of integers
     * @return a collection of integers
     * @throws NumberFormatException if any of the integers in the input string is not a valid integer
     * or if an empty string is given as input
     */
    @Override
    public Collection<Integer> collect(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .distinct()
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("\"" + s + "\" is not a valid integer");
                    }
                }).collect(Collectors.toList());
    }

    /**
     * Given a collection of integers and returns a comma-delimited string of numbers,
     * grouping the numbers into a range when they are sequential.
     *
     * @param input the collection of integers to summarize
     * @return a comma-delimited string of numbers with sequential numbers grouped into ranges
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        ArrayList<Integer> sortedList = new ArrayList<>(input);
        StringBuilder result = new StringBuilder();

        if (input.isEmpty()) {
            return "";
        }

        int start = sortedList.get(0);
        int last = start;

        for (int i = 1; i < sortedList.size(); i++) {
            int current = sortedList.get(i);

            if (current != last + 1) {
                if (start != last) {
                    result.append(start).append("-").append(last).append(", ");
                } else {
                    result.append(start).append(", ");
                }
                start = current;
            }
            last = current;
        }
        if (start != last) {
            result.append(start).append("-").append(last);
        } else {
            result.append(start);
        }
        return result.toString();
    }
}
