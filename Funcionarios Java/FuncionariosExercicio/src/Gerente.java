public class Gerente extends Funcionario{

    @Override
    public double calculaSalario(double salario_base) {
        this.salarioBase = 2*salario_base;

        return this.salarioBase;
    }

}
