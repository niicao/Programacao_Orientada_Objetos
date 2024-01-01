import java.util.Scanner;
public class Advinha {
    int upperLimit;
    int bottomLimit = 0;
    int guess;

    public void setUpperLimit(int upperLimit){
        this.upperLimit = upperLimit;
    }
    public void setBottomLimit(int bottomLimit){
        this.bottomLimit = bottomLimit;
    }

    public void guessNumber(){
        Character answer;
        Random guessed_number = new Random();
        System.out.println("Insira o limite superior do intervalo: ");
        Scanner scan = new Scanner(System.in);
        int upperLimitFromUser = scan.nextInt();
        setUpperLimit(upperLimitFromUser);

        do {
            this.guess = Math.round((upperLimit + bottomLimit)/2);

            System.out.println("Seu número é: " + this.guess + "?");
            System.out.println("Se o número que você pensou é menor, escreva '<'");
            System.out.println("Se o número que você pensou é maior, escreve '>'");
            System.out.println("Se o número dado está correto escreva '='");

            answer = scan.next().charAt(0);

            if(answer == '>'){
                this.setBottomLimit(this.guess);
            }

            else if (answer == '<') {
                setUpperLimit(this.guess);
            }
        }while (answer != '=');

        System.out.println("Bem jogado!");
    }
}
