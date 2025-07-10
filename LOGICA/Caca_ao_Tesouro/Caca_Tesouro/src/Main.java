import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        //Declarações Globais
        Scanner sc = new Scanner(System.in);
        Classe_Jogo cj = new Classe_Jogo();
        boolean runningGameStatus = false;
        int contador = 0;
        do {
            cj.InitGame();
            runningGameStatus = cj.painelGameInit(sc, runningGameStatus);
            if (runningGameStatus){
                cj.MapGame(true);
                do {
                    if (contador > 0) {
                        cj.getCoodHorizontal(sc);
                        cj.getCoodVertical(sc);
                        cj.MapGame(false);
                        contador++;
                    }else{
                        System.out.println("\nInforme as Localizações no mapa seguindo suas referencias\nExemplo 1 , 1");
                        cj.getCoodHorizontal(sc);
                        cj.getCoodVertical(sc);
                        cj.MapGame(false);
                        contador++;
                    }
                } while (runningGameStatus);
            }
        }while(runningGameStatus);
        sc.close();
    }
}