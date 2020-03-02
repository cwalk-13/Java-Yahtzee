/**
 * This class is used to update possibleList and output the possible scores
 * CPSC 224, Spring 2020
 * HW3
 * No sources to cite.
 *
 * @author Charles Walker
 */
public class ScoreOutput extends Main {
    static void Upper() {
        for (int dieValue = 1; dieValue <=dieSize; dieValue++)
        {
            int currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand.get(diePosition) == dieValue)
                    currentCount++;
            }
            for (String cardline : cardList) {
                String[] elem = cardline.split(" ");
                if (elem[0].equals(String.valueOf(dieValue))) {
                    if (elem[1].equals("n")) {
                        System.out.print("Score " + dieValue * currentCount + " on the ");
                        System.out.println(dieValue + " line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals(String.valueOf((dieValue)))) {
                                possibleList.set(i, ch[0] + " " + (dieValue * currentCount) + " " + ch[2]);
                            }
                        }
                    }
                }
            }
        }
    }
    static void Lower() {
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("3K")) {
                if (elem[1].equals("n")) {
                    if (Scoring.maxOfAKindFound(hand) >= 3) {
                        System.out.print("Score " + Scoring.totalAllDice(hand) + " on the ");
                        System.out.println("3K line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("3K")) {
                                possibleList.set(i, ch[0] + " " + Scoring.totalAllDice(hand) + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the 3K line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("4K")) {
                if (elem[1].equals("n")) {
                    if (Scoring.maxOfAKindFound(hand) >= 4) {
                        System.out.print("Score " + Scoring.totalAllDice(hand) + " on the ");
                        System.out.println("4K line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("4K")) {
                                possibleList.set(i, ch[0] + " " + Scoring.totalAllDice(hand) + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the 4K line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("FH")) {
                if (elem[1].equals("n")) {
                    if (Scoring.fullHouseFound(hand)) {
                        System.out.println("Score 25 on the FH line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("FH")) {
                                possibleList.set(i, ch[0] + " " + 25 + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the FH line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("SS")) {
                if (elem[1].equals("n")) {
                    if (Scoring.maxStraightFound(hand) >= 4) {
                        System.out.println("Score 30 on the SS line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("SS")) {
                                possibleList.set(i, ch[0] + " " + 30 + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the SS line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("LS")) {
                if (elem[1].equals("n")) {
                    if (Scoring.maxStraightFound(hand) >= 5) {
                        System.out.println("Score 40 on the LS line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("LS")) {
                                possibleList.set(i, ch[0] + " " + 40 + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the LS line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("Y")) {
                if (elem[1].equals("n")) {
                    if (Scoring.maxOfAKindFound(hand) >= 5) {
                        System.out.println("Score 50 on the Y line");
                        for (int i = 0; i < possibleList.size(); i++) {
                            String line = possibleList.get(i);
                            String[] ch = line.split(" ");
                            if (ch[0].equals("Y")) {
                                possibleList.set(i, ch[0] + " " + 50 + " " + ch[2]);
                            }
                        }
                    } else System.out.println("Score 0 on the Y line");
                }
            }
        }
        for (String cardline : cardList) {
            String[] elem = cardline.split(" ");
            if (elem[0].equals("C")) {
                if (elem[1].equals("n")) {
                    System.out.print("Score " + Scoring.totalAllDice(hand) + " on the ");
                    System.out.println("C line");
                    for (int i = 0; i < possibleList.size(); i++) {
                        String line = possibleList.get(i);
                        String[] ch = line.split(" ");
                        if (ch[0].equals("C")) {
                            possibleList.set(i, ch[0] + " " + Scoring.totalAllDice(hand) + " " + ch[2]);
                        }
                    }
                }
            }
        }
    }
}
