from Funcionario import Funcionario
from Gerente import Gerente
from Assistente import Assistente
from Vendedor import Vendedor


class Teste:
    def testeMain(self, num_funcionarios):

        option = 0
        salario = 0.0
        comission = 0.0
        somaTotal = 0
        nome = ''
        CPFentered = ''
        arrayFunc = [num_funcionarios]

        for i in range(num_funcionarios):
            option = int(input("Insira o numero relativo ao cargo:\n 1) Gerente\n 2) Assistente\n 3) Vendedor\n"))
            CPFentered = input("Insira o CPF no formato (XXXXXXXXXXX): ")
            if not Gerente().verificaCPF(CPFentered):
                print("CPF invalido, o cadastro será reiniciado")
                continue
            nome = input("Insira o nome: ")
            salario = float(input("Insira o salario base: "))
            match option:
                case 1:
                    arrayFunc[i] = Gerente()
                    somaTotal += arrayFunc[i].calculaSalario(salario)
                    arrayFunc[i].CPF = CPFentered
                    arrayFunc[i].nome = nome
                case 2:
                    arrayFunc[i] = Assistente()
                    somaTotal += arrayFunc[i].calculaSalario(salario)
                    arrayFunc[i].CPF = CPFentered
                    arrayFunc[i].nome = nome
                case 3:
                    comission = float(input("Insira a comissão: "))
                    arrayFunc[i] = Vendedor(comission)
                    somaTotal += arrayFunc[i].calculaSalario(salario)
                    arrayFunc[i].CPF = CPFentered
                    arrayFunc[i].nome = nome

        print("Despesas totais da folha salarial da empresa: " + str(somaTotal))



