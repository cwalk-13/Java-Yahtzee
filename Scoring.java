import java.util.List;
/**
 * This class is used to calculate the score from a hand
 * CPSC 224, Spring 2020
 * HW3
 * No sources to cite.
 *
 * @author Charles Walker
 */
public class Scoring extends Main {
    static void sortArray(List<Integer> array, int size)
//bubble sort from  Gaddis chapter 8
    {
        boolean swap;
        int temp;

        do
        {
            swap = false;
            for (int count = 0; count < (size - 1); count++)
            {
                if (array.get(count) > array.get(count + 1))
                {
                    temp = array.get(count);
                    array.set(count, array.get(count + 1));
                    array.set(count + 1, temp);
                    swap = true;
                }
            }
        } while (swap);
    }
    static int maxOfAKindFound(List<Integer> hand)
//this function returns the count of the die value occurring most in the hand
//but not the value itself
    {
        int maxCount = 0;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand.get(diePosition) == dieValue)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }
    static int totalAllDice(List<Integer> hand)
//this function returns the total value of all dice in a hand
    {
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++)
        {
            total += hand.get(diePosition);
        }

        return total;
    }

    static int maxStraightFound(List<Integer> hand)
//this function returns the length of the longest
//straight found in a hand
    {
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < 4; counter++)
        {
            if (hand.get(counter) + 1 == hand.get(counter + 1)) //jump of 1
                curLength++;
            else if (hand.get(counter) + 1 < hand.get(counter + 1)) //jump of >= 2
                curLength = 1;
            if (curLength > maxLength)
                maxLength = curLength;
        }
        return maxLength;
    }
    static boolean fullHouseFound(List<Integer> hand)
//this function returns true if the hand is a full house
//or false if it does not
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand.get(diePosition) == dieValue)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }

}
