package numberrangesummarizer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestTest {

    @Test
    public void TestSummarizeCollection() {

        // Assumed that inputs will be in this formatted as noted in the Interface class,
        // if the input is in a format like "1, 2, 3,..." with spaces after the comma
        // the split function won't split well and the program will fail.
        String test1 = "";
        String test2 = "10,2,9,5,14,3,1,11,6";
        String test3 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String test4 = "1,2,2,2,3,4,8,9,9,10,13";
        String test5 = "1";


        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeGenerator();

        // testing empty input
        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(test1)), "");

        // Testing unsorted input
        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(test2)), "1-3, 5-6, 9-11, 14");

        // Testing sorted input
        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(test3)), "1, 3, 6-8, 12-15, 21-24, 31");

        // Testing inputs with duplicates
        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(test4)), "1-4, 8-10, 13");

        // Testing inputs with one number
        Assertions.assertEquals(numberRangeSummarizer.summarizeCollection(numberRangeSummarizer.collect(test5)), "1");
    }

    @Test
    public void TestCollect() {
        String test1 = "";
        String test2 = "10,2,9,5,14,3,1,11,6";
        String test3 = "1,3,6,7,8,12,13,14,15,21,22,23,24,31"; // [1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31]
        String test4 = "1,2,2,2,3,4,8,9,9,10,13"; // [1, 2, 3, 4, 8, 9, 10, 13]
        String test5 = "1"; // [1]

        NumberRangeSummarizer numberRangeSummarizer = new NumberRangeGenerator();

        // Testing if it returns empty array
        Assertions.assertEquals(numberRangeSummarizer.collect(test1).toString(), "[]");

        // Testing unsorted input
        Assertions.assertEquals(numberRangeSummarizer.collect(test2).toString(), "[1, 2, 3, 5, 6, 9, 10, 11, 14]");

        // Testing sorted input
        Assertions.assertEquals(numberRangeSummarizer.collect(test3).toString(), "[1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31]");

        // Testing duplicate input
        Assertions.assertEquals(numberRangeSummarizer.collect(test4).toString(), "[1, 2, 3, 4, 8, 9, 10, 13]");

        // Testing single input
        Assertions.assertEquals(numberRangeSummarizer.collect(test5).toString(), "[1]");
    }

}