from Funcionario import Funcionario
from abc import ABC
class Vendedor(Funcionario):
    comissao = 0.0

    def __init__(self, comissao: float):
        self.comissao = comissao

    def calculaSalario(self, salario:float):
        self.salarioBase = salario + salario*self.comissao
        return self.salarioBase

    def verificaCPF(self, strCPF: str):
        Soma = 0
        String = ''
        nullCPF = "00000000000"
        Resto: int
        if strCPF == nullCPF:
            return False

        for i in range(1, 10):
            Soma = Soma + int(strCPF[i-1: i])* (11 - i)
        Resto = (Soma * 10) % 11

        if (Resto == 10) or (Resto == 11):
            Resto = 0


        if Resto != int(strCPF[9: 10]):
            return False

        Soma = 0
        for i in range (1, 11):
            Soma = Soma + int(strCPF[i-1: i]) * (12 - i)
        Resto = (Soma * 10) % 11

        if (Resto == 10) or (Resto == 11):  Resto = 0;
        if Resto != int(strCPF[10: 11]): return False
        return True
