public class Classe_Jogo {
    
    public void painelGameInit(){
        System.out.println(
        "__________________________________\n"+
        "|Jogo Caça ao Tesouro de Terminal|\n"+
        "|________________________________|\n"+
        "\nExplore as coordenadas de uma Ilha Misteriosa para\n"+
        "tentar achar o Tesouro,o jogo acontece em um mapa\n"+
        "de 8x8 tendo 5 armadilhas em pontos aleatorios do mapa\n"
        );

        System.out.println(
        "______________________|\n"+
        "|Aperte S para começar|\n"+
        "|_____________________|\n"
        );
    }
    public void MapGame(){
        // Declaração da Matriz do Jogo
        char[][] matriz = new char[9][9];
        // Inicialização da Matriz com o caracter "~" que representa a areia
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                matriz[i][j] = '~';
            }
        }

        int contadorV = 0;

        System.out.println("\n    1  2  3  4  5  6  7  8");
        for (int i = 1; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 1; j < matriz.length; j++) {
                contadorV++;
                    if (contadorV == 1) {
                    System.out.print(""+(i)+"|  "+matriz[i][j]+"  ");
                } else {
                    System.out.print(matriz[i][j]+"  ");
                }
            }
             contadorV = 0;
        }
    }
}