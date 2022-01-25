package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeGenerator implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) { // Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31


        List<Integer> listOfNumbers = new ArrayList<>(); // stores the numbers collected from the input

        if(input.length() == 0) return listOfNumbers;

        String[] numbs = input.split(","); // splitting the string into a list of numbers
        for(int i = 0; i < numbs.length; ++i) {

            int numToAdd = Integer.parseInt(numbs[i]); // converting the numbers from strings to int and storing them in a list.

            if(!listOfNumbers.contains(numToAdd)) // filtering duplicates
                listOfNumbers.add(numToAdd);
        }

        Collections.sort(listOfNumbers); // preSorting the list for easy processing

        return listOfNumbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        ArrayList<Integer> listOfNumbers = (ArrayList<Integer>) input; // casting the input collection to list so that we can have the get method
        int length = 1; // keeps track of the range length
        StringBuilder sb = new StringBuilder(); // sb to store the ranges, it's cheaper to append to String builder than to be creating a new copy of the string each time

        // If the array is empty,
        // return the list
        if (listOfNumbers.size() == 0) {
            return sb.toString();
        }

        // Traverse the array from first position
        for (int i = 1; i <= listOfNumbers.size(); ++i) {

            // Checking if the difference between current and previous number is 1
            // if its not go a head and append it to the string builder
            // else increment the length by 1
            if (i == listOfNumbers.size() || listOfNumbers.get(i) - listOfNumbers.get(i - 1) != 1) {

                if (length == 1) {

                    if(i != listOfNumbers.size()) {
                        sb.append(String.valueOf(listOfNumbers.get(i - length)));
                        sb.append(", ");
                    } else {
                        sb.append(String.valueOf(listOfNumbers.get(i - length)));
                    }

                }
                else {

                    // Builds the range to append to the string builder
                    // it gets the first element by subtracting the current index by the length
                    // and the last element of the range by subtracting 1 from the current index
                    String range = listOfNumbers.get(i - length) + "-" + listOfNumbers.get(i - 1);
                    if(i != listOfNumbers.size()) {
                        sb.append(range);
                        sb.append(", ");
                    } else {
                        sb.append(range);
                    }
                }

                length = 1; // initialise length to 1 after setting the range.
            }
            else {
                length++;
            }
        }

        return sb.toString();
    }

}
