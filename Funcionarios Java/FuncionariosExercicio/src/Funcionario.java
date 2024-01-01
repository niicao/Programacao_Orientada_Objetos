import static java.lang.Integer.parseInt;

public abstract class Funcionario {
    String nome;
    String CPF;
    double salarioBase = 0;

    public abstract double calculaSalario(double salario_base);
    public static boolean verificaCPF(String strCPF){
        int Soma;
        String nullCPF = "00000000000";
        int Resto;
        Soma = 0;
        if (strCPF.equals(nullCPF)) {
            return false;
        }

        for (int i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11)){
            Resto = 0;
        }
        if (Resto != parseInt(strCPF.substring(9, 10)) ) return false;

        Soma = 0;
        for (int i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
        Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false;
        return true;
    }
}
