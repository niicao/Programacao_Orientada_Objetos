import javax.lang.model.type.ArrayType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Scanner;

class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n1, n2, n3, n4;

        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        n3 = scanner.nextInt();
        n4 = scanner.nextInt();


        List<List<String>> values = ReadCSV(); // lendo o CSV e armazenando os dados em uma lista de Strings;

        // Busca os dados na lista de Strings e os insere em uma lista da classe criada, chamada Country;
        List<Country> countries = values.stream().map(r -> new Country(r.get(0), Integer.parseInt(r.get(1)), Integer.parseInt(r.get(2)), Integer.parseInt(r.get(3)), Integer.parseInt(r.get(4)))).collect(Collectors.toList());

        firstFunction(n1, countries); // Chamada da função 1;

        secondFunction(n2, n3, countries); // Chamada da função 2;

        thirdFunction(n4, countries); // Chamada da função 3;


    }

    public static void firstFunction(int n1, List<Country> countries){
        List<Country> countriesFiltered = new ArrayList<Country>(); // Criando uma nova lista da classe Country para realizar a filtragem dos dados;

        // Realizando o filtro;
        countriesFiltered =  countries.stream().filter(country -> country.Confirmed > n1).collect(Collectors.toList());

        // Somando os valores, conforme solicitado;
        int sum = countriesFiltered.stream().mapToInt(Country::getActive).sum();

        // Imprimindo a soma dos valores;
        System.out.println(sum);
    }

    public static void secondFunction(int n2, int n3, List<Country> countries){

        List<Country> sortedCountries = new ArrayList<>();

        // Se n3 for maior que n2, n3 recebe o valor de n2;
        if(n3 > n2){
            n3 = n2;
        }

        // Ordenando os países pelo parâmetro Active;
        sortedCountries = countries.stream().sorted(Comparator.comparingInt(Country::getActive)).collect(Collectors.toList());

        int size = sortedCountries.size();

        sortedCountries = sortedCountries.subList(size-n2, size); // Criando uma sublista com os maiores n2 disponíveis;

        // Ordenando os países pelo parâmetro Confirmed;
        sortedCountries = sortedCountries.stream().sorted(Comparator.comparingInt(Country::getConfirmed)).collect(Collectors.toList());

        sortedCountries = sortedCountries.subList(0, n3); // Criando uma sublista dos menores n3;

        sortedCountries.forEach(Country -> System.out.println(Country.Deaths)); // Imprimindo as informações necessárias;

    }

    public static void thirdFunction(int n4, List<Country> countries){
        List<Country> sortedCountries = new ArrayList<>();

        // Ordenando os países pelo parâmetro Confirmed;
        sortedCountries = countries.stream().sorted(Comparator.comparingInt(Country::getConfirmed)).collect(Collectors.toList());

        int size = sortedCountries.size();

        sortedCountries = sortedCountries.subList(size - n4, size);

        sortedCountries = sortedCountries.stream().sorted(Comparator.comparing(Country::getCountry)).collect(Collectors.toList());

        sortedCountries.stream().forEach(line -> System.out.println(line.Country));


    }


    public static List<List<String>> ReadCSV() { // Função para ler o arquivo CSV corretamente;
        String NomeArquivo = "dados.csv";
        List<List<String>> values = new ArrayList<>();

        try (Stream<String> lines = Files.lines(Paths.get(NomeArquivo))) {
            values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            return values;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }


    private static class Country{ // Implementação da classe Country;
        private String Country;
        private int Confirmed;
        private int Deaths;
        private int Recovery;
        private int Active;

        public Country(String country, int confirmed, int deaths, int recovery, int active){
            Country = country;
            Confirmed = confirmed;
            Deaths = deaths;
            Recovery = recovery;
            Active = active;
        }

        public int getConfirmed(){
            return this.Confirmed;
        }

        public int getActive(){
            return this.Active;
        }

        public int getDeaths(){
            return this.Deaths;
        }

        public int getRecovery(){
            return this.Recovery;
        }
        public String getCountry(){
            return this.Country;
        }

    }


}