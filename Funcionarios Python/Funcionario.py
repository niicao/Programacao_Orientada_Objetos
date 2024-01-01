import string
from abc import ABC, abstractmethod


class Funcionario(ABC):
    nome: str
    CPF: str
    salarioBase: float

    @abstractmethod
    def calculaSalario(self, salario:float):
        pass

    def verificaCPF (self, CPF: str):
        pass
    
