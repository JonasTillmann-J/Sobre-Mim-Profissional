import java.net.ContentHandler;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        //Declarações Globais
        Scanner sc = new Scanner(System.in);
        Classe_Jogo cj = new Classe_Jogo();
        boolean runningGameStatus;
        char[][] matriz = new char[9][9];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = '~';
            }
        }
        System.out.println("\n");
        int contadorV = 0;
        int numeradorH = 0;
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("");
            for (int j = 0; j < matriz.length; j++) {
                contadorV++;
                if(j == 0){
                    numeradorH ++;
                    //System.out.print(""+numeradorH);
                    System.out.print(/*i+"-"+j+"  "*/numeradorH);
                } else if (contadorV == 1) {
                    System.out.print("\n"+(i+1)+"|  "+i+"-"+j+"  ");
                }else{
                    System.out.print(+i+"-"+j+"  ");    
                }
                contadorV = 0;
            }
        }
        /* 
        for (int i = 0; i < matriz.length; i++) {
            
            System.out.println("");
            for (int j = 0; j < matriz.length; j++) {
                contadorV++;
                if (contadorV == 1) {
                    System.out.print((i+1)+"|  "+matriz[i][j]+"  ");
                }else{
                    System.out.print(matriz[i][j]+"  ");
                }
            }
            contadorV = 0;
        }
        //Inicialização do Game
        System.out.println("\n__________________________________\n|Jogo Caça ao Tesouro de Terminal|\n|________________________________|\n\nExplore as coordenadas de uma Ilha Misteriosa para tentar achar o Tesouro,\no jogo acontece em um mapa de 8x8 tendo 5 armadilhas em pontos aleatorios do mapa");
        do {

            char initGameResponse = sc.nextLine().charAt(0);
            runningGameStatus = initGameResponse == 's' || initGameResponse == 'S' ? true : false;
        } while (runningGameStatus);*/
        sc.close();
    }
}
