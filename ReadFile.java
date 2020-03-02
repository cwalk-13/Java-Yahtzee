import java.io.*;
import java.util.Scanner;
/**
 * This class opens a file and uses the contents to update # of die, # of sides on each die and # of rolls for a hand
 * CPSC 224, Spring 2020
 * HW3
 * No sources to cite.
 *
 * @author Charles Walker
 */
public class ReadFile extends Main {
    //this function reads what is in yahtzeeConfig
    static void readFile() {
        try {
            Scanner scanner = new Scanner(new File("yahtzeeConfig.txt"));
            dieSize = scanner.nextInt();
            dieCount = scanner.nextInt();
            rollsPerHand = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // this function uses ReadFile and reConfigureFile to prompt the user to reconfigure the game
    static void UpdateGame() throws IOException {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("you are playing with " + dieCount + ", " + dieSize + " -sided dice");
        System.out.println("you get " + rollsPerHand + " rolls per hand");
        System.out.println("enter 'y' if you would like to change the configuration ");
        String changeConfig = in.nextLine();
        if (changeConfig.equals("y")) {
            System.out.println("enter the number of sides on each die ");
            dieSize = in.nextInt();
            System.out.println("enter the number of dice in play ");
            dieCount = in.nextInt();
            System.out.println("enter the number of rolls per hand ");
            rollsPerHand = in.nextInt();
            reConfigFile();
        } else {
            return;
        }
        readFile();
        System.out.println("you are playing with " + dieCount + ", " + dieSize + " -sided dice");
        System.out.println("you get " + rollsPerHand + " rolls per hand");
    }
    //this function changes the values in the text file which reconfigures the game
    static void reConfigFile() throws IOException {

        PrintWriter writer = new PrintWriter("yahtzeeConfig.txt");
        writer.print("");

        writer.write(dieSize + "");
        writer.append(System.lineSeparator());
        writer.write(dieCount + "");
        writer.append(System.lineSeparator());
        writer.write(rollsPerHand + "");
        writer.append(System.lineSeparator());

        writer.close();
    }
}
