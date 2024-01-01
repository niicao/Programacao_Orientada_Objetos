public class rolaDados {
    Dado vetorDados[];
    int numDados;

    public rolaDados(int n){
        this.vetorDados = new Dado[n];
        for(int i = 0; i < n; i++){
            vetorDados[i] = new Dado();
        }
        this.numDados = n;
    }
    public rolaDados(){
        this.vetorDados = new Dado[5];
        for(int i = 0; i < 5; i++){
            vetorDados[i] = new Dado();
        }
        this.numDados = 5;
    }
    public int[] rolar(){
        int[] vetorValores = new int[this.numDados];
        for(int i = 0; i < this.numDados; i++){
            this.vetorDados[i].rolarDado();
        }
        return vetorValores;
    }

    public int[] rolar(boolean[] quais){
        int[] vetorValores = new int[this.numDados];
        for(int i = 0; i < this.numDados; i++){
            if(quais[i] == true) {
                this.vetorDados[i].rolarDado();
            }
            vetorValores[i] = this.vetorDados[i].number;
        }
        return vetorValores;
    }

    public int[] rolar(java.lang.String s){
        String[] dices = new String[5];
        int[] array = new int[5];
        int size = s.length();
        dices = s.split(" ");
        if(s.isEmpty()){
            for(int i = 0; i < 5; i++){
                array[i] = this.vetorDados[i].getLado();
            }
            return array;
        }
        for(String dice : dices){
            this.vetorDados[Integer.parseInt(dice) - 1].rolarDado();
        }

        for(int i = 0; i < 5; i++){
            array[i] = this.vetorDados[i].getLado();
        }
        return array;

    }
    public String toString() {
        String[] placar = new String[5];
        for (int i = 0; i < 5; i++) {
            placar[i] = "";
            placar[i] += vetorDados[i].toString();
        }
        String displayDados = "";
        int linhasQuadradoAscii = 5;
        int colunasQuadradoAscii = 9;
        for (int k = 1; k <= linhasQuadradoAscii; k++) {
            displayDados += k + "          ";
        }
        displayDados += '\n';
        for (int i = 0; i < placar[0].length(); i += colunasQuadradoAscii) {
            for (int j = 0; j < linhasQuadradoAscii; j++) {
                displayDados += placar[j].substring(i, i + colunasQuadradoAscii) + "  ";
            }
            displayDados += '\n';
        }
        return displayDados;
    }

}
