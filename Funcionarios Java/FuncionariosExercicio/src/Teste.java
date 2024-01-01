import java.util.Scanner;

public class Teste {
    public static void main(int num_funcionarios){
        Scanner scan = new Scanner(System.in);
        String CPFentered;
        int option;
        double salario;
        float comission;
        int somaTotal = 0;
        String Nome;
        Funcionario[] arrayFunc = new Funcionario[num_funcionarios];
        for(int i = 0; i < num_funcionarios; i++ ){
            System.out.println("Insira o numero relativo ao cargo:\n 1) Gerente\n 2) Assistente\n 3) Vendedor");
            option = scan.nextInt();
            System.out.println("Insira o CPF no formato (XXXXXXXXXXX):");
            scan.nextLine();
            CPFentered = scan.nextLine();


            if(!Funcionario.verificaCPF(CPFentered)){
                System.out.println("CPF invalido, o cadastro será reiniciado");
                continue;
            }

            System.out.println("Insira o nome:");
            Nome = scan.next();
            System.out.println("Insira o salario base:");
            salario = scan.nextDouble();
            switch(option){
                case 1:
                    arrayFunc[i] = new Gerente();
                    somaTotal += arrayFunc[i].calculaSalario(salario);
                    arrayFunc[i].CPF = CPFentered;
                    arrayFunc[i].nome = Nome;
                    break;
                case 2:
                    arrayFunc[i] = new Assistente();
                    somaTotal += arrayFunc[i].calculaSalario(salario);
                    arrayFunc[i].CPF = CPFentered;
                    arrayFunc[i].nome = Nome;
                    break;
                case 3:
                    System.out.println("Insira a comissao:");
                    comission = scan.nextFloat();
                    arrayFunc[i] = new Vendedor(comission);
                    somaTotal += arrayFunc[i].calculaSalario(salario);
                    arrayFunc[i].CPF = CPFentered;
                    arrayFunc[i].nome = Nome;
                    break;
            }
            System.out.println("Despesas totais da folha salarial da empresa: " + somaTotal);



        }


    }
}
