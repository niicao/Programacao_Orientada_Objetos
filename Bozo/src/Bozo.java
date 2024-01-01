import java.io.IOException;
import java.util.Scanner;

public class Bozo {
    rolaDados roler;
    Placar scoreboard;

    public Bozo(){
        roler = new rolaDados();
        scoreboard = new Placar();
    }
    public void Main() throws IOException {
        Scanner enterPress = new Scanner(System.in);
        String reroll = new String();
        int posicao;
        for (int i = 0; i < 10; i++) {
            System.out.println("Pressione ENTER para iniciar a rodada.");
            enterPress.nextLine();
            roler.rolar();
            System.out.println(roler.toString());
            System.out.println("Informe os dados que quer re-rolar separados por espaço (2a tentativa).\n");
            reroll = EntradaTeclado.leString();
            roler.rolar(reroll);
            System.out.println(roler.toString());
            System.out.println("Informe os dados que quer re-rolar separados por espaço (3a tentativa)\n");
            reroll = EntradaTeclado.leString();
            roler.rolar(reroll);
            System.out.println(roler.toString());
            System.out.println(scoreboard.toString());
            scoreboard.toString();
            System.out.println("Insira a posição que deseja ocupar.");
            posicao = EntradaTeclado.leInt();
            scoreboard.add(posicao, roler.rolar(" "));
            scoreboard.toString();
            System.out.println("Pontuação: " + scoreboard.getScore());





        }
    }
}
