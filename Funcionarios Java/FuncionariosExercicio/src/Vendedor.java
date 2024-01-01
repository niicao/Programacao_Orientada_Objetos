public class Vendedor extends Funcionario{
    float comissao;
    public Vendedor(float commiss){
        this.comissao = commiss;
    }
    @Override
    public double calculaSalario(double salario_base) {
        this.salarioBase = salario_base + salario_base*this.comissao;
        return this.salarioBase;
    }
}
