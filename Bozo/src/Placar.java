import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Placar {
    int[] table;


    public Placar(){
        this.table = new int[10];
        for(int i = 0; i < 10; i++){
            this.table[i] =-1;
        }
    }


    public void add(int posicao , int[] dados) throws IOException {

        int pontuacao = 0;
        int num1 = 0;
        int num2 = 0;
        int recursiveInput;
        switch(posicao){
            case 1:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 1){
                        pontuacao += 1;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 2:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 2){
                        pontuacao += 2;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 3:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 3){
                        pontuacao += 3;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 4:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 4){
                        pontuacao += 4;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 5:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 5){
                        pontuacao += 5;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 6:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(dados[i] == 6){
                        pontuacao += 6;
                    }
                }
                this.table[posicao-1] = pontuacao;
                break;
            case 7:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 0; i < 5; i++){
                    if(num1 == 0) num1 = dados[i];
                    else if(num2 == 0 && dados[i] != num1) num2 = dados[i];
                    else if(dados[i] != num1 && dados[i] != num2){
                        this.table[posicao - 1] = 0;
                        System.out.println("Seus dados não formaram um fullhouse, o espaço foi preenchido com a pontuação zero!");
                        return;
                    }

                }
                this.table[posicao - 1] = 15;
                break;

            case 8:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                Arrays.sort(dados);
                for(int i = 1; i < 5; i++){
                    if(dados[i] != dados[i-1] + 1){
                        this.table[posicao - 1] = 0;
                        System.out.println("Seus dados não formaram uma sequencia, o espaço foi preenchido com a pontuação zero!");
                        return;
                    }
                }
                this.table[posicao - 1] = 20;
                break;
            case 9:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                Arrays.sort(dados);
                for(int i = 0; i < 5; i++){
                    if(num1 == 0){
                        num1 = dados[i];
                    }
                    else if(num2 == 0 && dados[i] != num2){
                        num2 = dados[i];
                    }
                    else if(dados[i] != num1 && dados[i] != num2){
                        this.table[posicao - 1] = 0;
                        System.out.println("Seus dados não formaram uma quadra, o espaço foi preenchido com a pontuação zero!");
                        return;
                    }
                }
                this.table[posicao-1] = 30;
                break;
            case 10:
                if(this.table[posicao - 1] != -1){
                    System.out.println("Esta posição já foi preenchida, insira outra posição");
                    add(recursiveInput = EntradaTeclado.leInt(), dados);
                    return;
                }
                for(int i = 1; i < 5; i++){
                    if(dados[i-1] != dados[i]){
                        this.table[posicao - 1] = 0;
                        System.out.println("Seus dados não formaram uma quina, o espaço foi preenchido com a pontuação zero!");
                        return;
                    }
                }
                this.table[posicao-1] = 40;
                break;
        }
    }
    public int getScore(){
        int total = 0;

        for(int i = 0; i < 10; i++){
                if(this.table[i] != -1) total += this.table[i];
        }

        return total;

    }

    public java.lang.String toString(){
        String placarStr = new String();
        placarStr = isOccupied(1) + "    |   " + isOccupied(7) + "    |   " + isOccupied(4) +
                "\n--------------------------\n" +
                isOccupied(2) + "    |   " + isOccupied(8) + "    |   " + isOccupied(5) +
                "\n--------------------------\n" +
                isOccupied(3) + "    |   " + isOccupied(9) + "    |   " + isOccupied(6) +
                "\n--------------------------\n" + "       |   "+ isOccupied(10) + "   |\n" + "       +----------+";
        return placarStr;
//        System.out.println(isOccupied(1) + "    |   " + isOccupied(7) + "    |   " + isOccupied(4));
//        System.out.println("--------------------------");
//        System.out.println(isOccupied(2) + "    |   " + isOccupied(8) + "    |   " + isOccupied(5));
//        System.out.println("--------------------------");
//        System.out.println(isOccupied(3) + "    |   " + isOccupied(9) + "    |   " + isOccupied(6));
//        System.out.println("--------------------------");
//        System.out.println("        |   "+ isOccupied(10) + "    |");
//        System.out.println("+----------+");
    }
    public java.lang.String isOccupied(int position){
        if(this.table[position -1] != -1){
            return Integer.toString(this.table[position-1]) + " ";
        }
        else{
            return "(" + Integer.toString(position) + ")";
        }
    }
}
