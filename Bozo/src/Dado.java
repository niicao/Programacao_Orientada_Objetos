import java.security.InvalidParameterException;
import java.util.Random;

public class Dado {
    int number;

    int numSides;

    public Dado(int x) {
        this.numSides = x;
    }

    public Dado() {
        this.numSides = 6;
    }


    public int getLado() {
        return this.number;
    }

    public int rolarDado() {
        Random randomNum = new Random();
        this.number = randomNum.nextInt(1, this.numSides);
        return this.number;
    }

    public String toString() {
        String face = "";
        for (int i = 0; i < 5; i++) {
            face += ascii[number-1][i];
        }
        return face;
    }
    String[][] ascii = {
            {
                    "+-------+",
                    "|       |",
                    "|   o   |",
                    "|       |",
                    "+-------+",
            },
            {
                    "+-------+",
                    "| o     |",
                    "|       |",
                    "|     o |",
                    "+-------+",
            },
            {
                    "+-------+",
                    "| o     |",
                    "|   o   |",
                    "|     o |",
                    "+-------+",
            },
            {
                    "+-------+",
                    "| o   o |",
                    "|       |",
                    "| o   o |",
                    "+-------+",
            },
            {
                    "+-------+",
                    "| o   o |",
                    "|   o   |",
                    "| o   o |",
                    "+-------+",
            },
            {
                    "+-------+",
                    "| o   o |",
                    "| o   o |",
                    "| o   o |",
                    "+-------+",
            },
    };
}




