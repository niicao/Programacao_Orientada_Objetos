import java.util.Scanner;

public class passwordGame {
    int upper_range;
    int bottom_range = 0;
    int numTries = 1;
    int secretPassword;

    public void setUpper_range(int upperRangeFromUser) {
        this.upper_range = upperRangeFromUser;
    }

    public void setBottom_range(int bottomRangeFromUser){
        this.bottom_range = bottomRangeFromUser;
    }

    public void startGame(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insira o limite superior do intervalo: ");
        setUpper_range(scan.nextInt());
        Random password = new Random();
        int guess;
        this.secretPassword = password.getIntRand(this.bottom_range, this.upper_range);

        do {
            System.out.println("Insira seu palpite: ");
            guess = scan.nextInt();

            if (guess < this.secretPassword){
                System.out.println("Seu número é menor que a senha.");
                this.numTries += 1;
            }

            else if(guess > this.secretPassword) {
                System.out.println("Seu número é maior que a senha.");
                this.numTries += 1;
            }

        }while (guess != this.secretPassword);
        System.out.println("Você acertou em " + this.numTries + " tentativas!");
    }


}
