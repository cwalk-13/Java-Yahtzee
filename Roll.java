
/**
 * This class is used to for simulating the rolling of the die
 * CPSC 224, Spring 2020
 * HW3
 * No sources to cite.
 *
 * @author Charles Walker
 */
public class Roll extends Main {
    static int rollDie()
//this function simulates the rolling of a single die
    {
        return (int) (Math.random() * dieSize + 1);
    }

    static void rollDice() {
        //roll dice not kept
        for (int dieNumber = 0; dieNumber < dieCount; dieNumber++)
        {
            hand.add(dieNumber);
            char ind = keep.charAt(dieNumber);
            if (ind != 'y')
                hand.set(dieNumber, rollDie());
        }
    }
    static void rollOutput() {
        //output roll
        System.out.println("Your roll was: ");
        for (int dieNumber = 0; dieNumber < dieCount; dieNumber++)
        {
            System.out.println(hand.get(dieNumber) + " ");
        }
        System.out.println();
    }
}


