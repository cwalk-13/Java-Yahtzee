
/**
 * This class is used to create and updatable cardList which is used to print the Score card
 * CPSC 224, Spring 2020
 * HW3
 * No sources to cite.
 *
 * @author Charles Walker
 */
public class ScoreCard extends Main {

    static void createScorecard() {
        //loop for upper section
        for (int i = 1; i < dieSize + 1; i++)
        {
            cardList.add(i + " n u 0");
        }
            //individual writes for lower section
        cardList.add("3K n l 0");
        cardList.add("4K n l 0");
        cardList.add("FH n l 0");
        cardList.add("SS n l 0");
        cardList.add("LS n l 0");
        cardList.add("Y n l 0");
        cardList.add("C n l 0");

    }

    static void readScorecard() {
        //this function reads the scordcard.txt file and stores in in a list named cardList
        //and stores unused lines in the scorecard in a list named possibleList

        for (String line : cardList) {
            String[] elems = line.split(" ");
            String name = elems[0];
            String used = elems[1];
            String section = elems[2];
            if (used.equals("n"))
            {
                String possList = (name + " " + "0" + " " + section);
                possibleList.add(possList);
            }
        }
    }



    static void printScorecard () {
        //this function prints a scorecard from the cardList
        System.out.println("Line          Score");
        System.out.println("-------------------");
        int upperTotal = 0;
        int bonus = 0;
        int lowerTotal = 0;
        //loop looking for upper section lines
        for (String line : cardList) {
            String[] ch = line.split(" ");

            if (ch[2].equals("u"))
            {
                upperTotal = upperTotal + Integer.parseInt(String.valueOf(ch[3]));
                System.out.println(ch[0] + "           " + ch[3]);
            }
        }
        if (upperTotal >= 63) {
            bonus = 35;
        }
        //upper sub total
        System.out.println("-------------------");
        System.out.println("Sub Total        " + upperTotal);
        //bonus
        System.out.println("Bonus        " + bonus);
        //upper tot
        System.out.println("-------------------");
        System.out.println("Upper Total       " + Integer.parseInt(String.valueOf(upperTotal+bonus)));
        System.out.println();

        //loop looking for lower section lines
        for (String line : cardList) {
            String[] ch = line.split(" ");
            if (ch[2].equals("l"))
            {
                int score = Integer.parseInt(String.valueOf(ch[3]));
                lowerTotal = lowerTotal + score;
                System.out.println(ch[0] + "           " + ch[3]);
            }
        }

        //lower total
        System.out.println("-------------------");
        System.out.println("Lower Total        " + lowerTotal);

        //grand total
        System.out.println("-------------------");
        System.out.println("Grand Total       " + Integer.parseInt(String.valueOf(upperTotal + bonus + lowerTotal)));
        System.out.println();
    }
}
