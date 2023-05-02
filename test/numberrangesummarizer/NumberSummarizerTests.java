package numberrangesummarizer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class NumberSummarizerTests {
    private NumberSummarizer numberSummarizer;

    @BeforeEach
    void setUp(){
        numberSummarizer = new NumberSummarizer();
    }

    @Test
    void collect_inputPositiveNumbersValid_returnPopulatedCollection() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expectedOutput =
                new ArrayList<>(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        Collection<Integer> actualOutput = numberSummarizer.collect(input);
        assertArrayEquals(expectedOutput.toArray(), actualOutput.toArray());
    }

    @Test
    void collect_inputNegativeNumbersValid_returnPopulatedCollection() {
        String input = "-7,-6,-4,-2,-1,0,1,2,5,7";
        Collection<Integer> expectedOutput =
                new ArrayList<>(Arrays.asList(-7,-6,-4,-2,-1,0,1,2,5,7));
        Collection<Integer> actualOutput = numberSummarizer.collect(input);

        assertArrayEquals(expectedOutput.toArray(), actualOutput.toArray());
    }

    @Test
    void collect_inputDoubleNumbersValid_returnPopulatedCollection() {
        String expectedOutput = "[1, 3, 4, 7, 8, 9]";
        Collection<Integer> actualOutput = numberSummarizer.collect("1, 3, 3, 4, 7, 8, 9");

        assertEquals(expectedOutput, actualOutput.toString());
        assertEquals(6, actualOutput.size());
        assertEquals(1, Arrays.stream(actualOutput.toArray()).filter(i -> i.equals(3)).count());
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "3, 3, 3"})
    void collect_inputSingleValue_returnCollectionSizeOne(String input) {
        Collection<Integer> actualOutput =  numberSummarizer.collect(input);
        assertEquals(1, actualOutput.size());
    }

    @Test
    void collect_inputEmptyString_throwException() {
        assertThrows(NumberFormatException.class,
                () -> numberSummarizer.collect(""),
                "This should have thrown a NumberFormatException");
    }

    @Test
    void collect_inputNonNumericValue_throwException() {
        assertThrows(NumberFormatException.class,
                () -> numberSummarizer.collect("1,b,6,7,8,12,13"),
                "This should have thrown a NumberFormatException");
    }
}