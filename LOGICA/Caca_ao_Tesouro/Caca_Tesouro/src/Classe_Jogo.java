import java.util.Scanner;

public class Classe_Jogo {
    private int contadorPGI;
    private int contadorGLM;
    private int horizontal;
    private int vertical;
    private char[][] matriz = new char[9][9];
    
    public boolean painelGameInit(Scanner sc, Boolean runningGameStatus){
        if (this.contadorPGI > 1) {
            System.out.println(
        "_________________________\n"+
        "|Aperte S para Recomecar|\n"+
        "| Ou Aperte N para sair |\n"+
        "|_______________________|\n");
        char response = sc.nextLine().charAt(0);
        this.contadorPGI++;
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        }else{
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
        char response = sc.nextLine().charAt(0);
        contadorPGI++;
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        }
    }
    public void MapGame(){
        // Declaração da Matriz do Jogo
        // Inicialização da Matriz com o caracter "~" que representa a areia
        for (int i = 1; i < this.matriz.length; i++) {
            for (int j = 1; j < this.matriz.length; j++) {
                matriz[i][j] = '~';
            }
        }
        int contadorV = 0;
        System.out.println("\n    1  2  3  4  5  6  7  8");
        for (int i = 1; i < this.matriz.length; i++) {
            System.out.println("");
            for (int j = 1; j < this.matriz.length; j++) {
                contadorV++;
                    if (contadorV == 1) {
                    System.out.print(""+(i)+"|  "+matriz[i][j]+"  ");
                } else {
                    System.out.print(matriz[i][j]+"  ");
                }
            }
             contadorV = 0;
        }
        System.out.println("");
    }
    boolean horizontalCheckStatus = false;
    boolean verticalCheckStatus = false;
    public void GetLocalMap(Scanner sc){
        if (contadorGLM > 1){

        }else
        System.out.println("\nInforme o local que deseja cavar no mapa usando as cordenadas que aparecem no topo e na lateral do mapa exemplo (1,1)");

        System.out.println("Informe a Coordenada Horizontal");
        this.horizontal = sc.nextInt();
        do{
            if (this.horizontal < 1) {
                System.out.println("Valores invalidos a coodenada horizontal deve ser maior que 0\nTente novamente");
                this.horizontal = sc.nextInt();
                this.horizontalCheckStatus = true;
            }else if(this.horizontal > 8){
                System.out.println("Valores invalidos a coodenada horizontal deve ser menor que 9\nTente novamente");
                this.horizontal = sc.nextInt();
                this.horizontalCheckStatus = true;
            }else{
                this.horizontalCheckStatus = false;
                System.out.println("Informe a coordenada Vertical");
            }
        }while (horizontalCheckStatus);

        this.vertical = sc.nextInt();
        do{
            if (this.vertical < 1) {
                System.out.println("Valores invalidos a coodenada vertical deve ser maior que 0\nTente novamente");
                this.vertical = sc.nextInt();
                this.verticalCheckStatus = true;
            }else if(this.vertical > 8){
                System.out.println("Valores invalidos a coodenada vertical deve ser menor que 9\nTente novamente");
                this.vertical = sc.nextInt();
                this.verticalCheckStatus = true;
            }
        }while (verticalCheckStatus);

        System.out.println("Coordenadas Informadas("+this.horizontal+"|"+this.vertical+")");
    }
}