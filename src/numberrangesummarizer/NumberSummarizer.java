package numberrangesummarizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberSummarizer implements NumberRangeSummarizer{

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

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return null;
    }
}
