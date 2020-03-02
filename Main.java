import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 /**
  * This program runs a dynamically changeable game of yahtzee
  * CPSC 224, Spring 2020
  * HW3
  * No sources to cite.
  *
  * @author Charles Walker
  */
public class Main {
    static List<String> cardList = new ArrayList<>();
    static List<String> possibleList = new ArrayList<>();
    public static int dieSize, dieCount, rollsPerHand;
    static List<Integer> hand = new ArrayList<>();
    public static String keep;
    public static void main(String[] args) throws IOException {

        boolean openLine = true;
        Scanner in = new Scanner(System.in);
        //initiates the ReadFile class
        ReadFile.UpdateGame();
        ScoreCard.createScorecard();

        while (openLine)
        {
            int turn = 1;
            keep = "nnnnn";
            while (turn <= rollsPerHand && !keep.equals("yyyyy"))
            {
                //roll dice not kept
                Roll.rollDice();
                //output roll
                Roll.rollOutput();
                //if not the last roll of the hand prompt the user for dice to keep
                if (turn < rollsPerHand)
                {
                    System.out.println("enter dice to keep (y or n) or enter 'S' for scorecard ");
                    keep = in.nextLine();
                    if (keep.equals("S")){
                        ScoreCard.printScorecard();
                        System.out.println("enter dice to keep (y or n)");
                        keep = in.nextLine();
                    }
                }
                turn++;
            }
            //start scoring
            //hand need to be sorted to check for straights
            //sort and score
            Scoring.sortArray(hand, dieCount);
            System.out.println("Here is your sorted hand : ");
            for (int dieNumber = 0; dieNumber < dieCount; dieNumber++)
            {
                System.out.println(hand.get(dieNumber) + " ");
            }
            System.out.println();
            ScoreCard.readScorecard();

            System.out.println("Your scoring options are as follows:");
            //upper scorecard

            ScoreOutput.Upper();

            //lower scorecard
            ScoreOutput.Lower();

            //get score choice from user
            System.out.println("Enter the code for the line where you would like your score placed");
            String choice = in.nextLine();
            String scoreOfChoice = null;
            for (String line : possibleList) {
                String[] ch = line.split(" ");
                if (ch[0].equals(choice)) {
                    scoreOfChoice = ch[1];
                }
            }

            //update cardList
            for (int i = 0; i <cardList.size(); i++) {
                String line = cardList.get(i);
                String[] ch = line.split(" ");
                if (ch[0].equals(choice)) {
                    cardList.set(i, ch[0] + " " + "y" + " " + ch[2] + " " + scoreOfChoice);
                }
            }

            //set condition to play another hand if any scorecard lines still not used
            openLine = false;
            int openCount = 0;
            for (String line : cardList) {
                String[] ch = line.split(" ");
                if (ch[1].equals("n")) {
                    openCount++;
                }
            }
            if (openCount > 0) {
                openLine = true;
                System.out.println();
                System.out.println(openCount + " scorecard lines are still available");
            }
        }
        ScoreCard.printScorecard();
        System.out.println("Game Over");
    }

}
