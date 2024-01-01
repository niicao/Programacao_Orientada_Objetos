from random import Random

def main() -> None:
    upper_range = input("Insira o limite superior de criação do número aleatório:\n")
    upper_range = int(upper_range)
    random_number = Random()
    secret_number = random_number.get_int_rand(upper_range)

    passwordGame(secret_number)

def passwordGame(secret_number) -> None:
    num_of_tries = 1
    while True:
        guessed_number = int(input("Insira seu palpite:\n"))

        if guessed_number < secret_number:
            print("Seu número é menor que a senha.\n")
            num_of_tries += 1

        elif guessed_number > secret_number:
            print("Seu número é maior que a senha.\n")
            num_of_tries += 1

        elif guessed_number == secret_number:
            print("Você acertou em " + str(num_of_tries) + " tentativas. Parabéns!!!\n")
            break


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    main()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
