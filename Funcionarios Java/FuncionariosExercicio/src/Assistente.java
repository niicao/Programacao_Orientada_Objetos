public class Assistente extends Funcionario{

    @Override
    public double calculaSalario(double salario_base) {
        this.salarioBase = salario_base;
        return this.salarioBase;
    }
}
