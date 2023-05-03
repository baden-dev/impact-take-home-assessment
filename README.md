# Comma Delimited List of Numbers
______
This is a Java program that produces a comma delimited list of numbers, grouping the numbers into a range when they are sequential.

## Usage
To use the NumberSummarizer class, you can create an instance of it and call its collect and summarizeCollection methods.

**Example usage:**
```java
import java.util.Collection;
import numberrangesummarizer.NumberSummarizer;

public class Main {
    public static void main(String[] args) {
        NumberSummarizer summarizer = new NumberSummarizer();

        Collection<Integer> numbers = summarizer.collect("1,2,3,4,5,7,8,9,10,11");

        String summary = summarizer.summarizeCollection(numbers);

        System.out.println(summary); // "1-5, 7-11"
    }
}
```

## Implementation
The \`**NumberSummarizer**\` class implements the \`**NumberRangeSummarizer**\` interface, which defines two methods:
* \`**collect(String input)**\`: Collects a comma-separated string of integers and returns a collection of integers.
* \`**summarizeCollection(Collection<Integer> input)**\`: Given a collection of integers, returns a comma-delimited string of numbers, grouping the numbers into a range when they are sequential.

The implementation uses Java 8 features, such as stream processing and lambda expressions, to transform and manipulate the input data efficiently. The code also includes some error handling, such as checking for empty input or invalid integer values.

## Assumptions
1. The collect method takes in a comma delimited string that is in sequential order.
2. The input collection of integers contains duplicates.
3. The input collection of integers contains negative numbers.
4. The summarizeCollection method returns an empty string if the input collection is empty.

## Unit tests
This project contains several unit tests to ensure the correctness of the implementation. All tests are located in the \`**NumberSummarizerTests**\ class, in the \`**numberrangesummarizer**\` package.

Here is a brief explanation of the tests:
* \`**collect_inputNotInOrder_returnPopulatedCollection**\`: tests the collect method with an input that is not in order. The expected output is a populated collection with the same values as the input.
* \`**collect_inputPositiveNumbersValid_returnPopulatedCollection**\`: tests the collect method with valid input of positive numbers. The expected output is a populated collection with the same numbers as the input.
* \`**collect_inputNegativeNumbersValid_returnPopulatedCollection**\`: tests the collect method with valid input of negative numbers. The expected output is a populated collection with the same numbers as the input.
* \`**collect_inputDoubleNumbersValid_returnPopulatedCollection**\`: tests the collect method with valid input that contains duplicate numbers. The expected output is a populated collection with distinct numbers.
* \`**collect_inputSingleValue_returnCollectionSizeOne**\`: tests the collect method with a single value as input. The expected output is a collection with size 1.
* \`**collect_inputNull_throwException**\`: tests the collect method with null input. The expected output is a NullPointerException.
* \`**collect_inputEmptyString_throwException**\`: tests the collect method with an empty string as input. The expected output is a NumberFormatException.
* \`**collect_inputNonNumericValue_throwException**\`: tests the collect method with non-numeric values as input. The expected output is a NumberFormatException.
* \`**summarizeCollection_inputContainsMultipleConsecutiveRanges**\`: ests the summarizeCollection method with an input that contains multiple consecutive ranges. The expected output is a string with the summarization of the ranges.
* \`**summarizeCollection_inputContainsSingleRange**\`: tests the summarizeCollection method with an input that contains a single range. The expected output is a string with the summarization of single range.
* \`**summarizeCollection_inputContainsNoRanges**\`: tests the summarizeCollection method with an input that does not contain any ranges. The expected output is a string with the summarization of the input values.
* \`**summarizeCollection_inputContainsOneValue**\`: tests the summarizeCollection method with an input that contains a single value. The expected output is a string with the single value.
* \`**summarizeCollection_inputContainsNoValue**\`: tests the summarizeCollection method with an empty collection. The expected output is an empty string.
