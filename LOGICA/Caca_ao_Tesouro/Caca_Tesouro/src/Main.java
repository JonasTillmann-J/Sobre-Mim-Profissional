import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        //Declarações Globais
        Scanner sc = new Scanner(System.in);
        Classe_Jogo cj = new Classe_Jogo();
        boolean runningGameStatus = false;
        do {
            runningGameStatus = cj.painelGameInit(sc, runningGameStatus);
            cj.MapGame();
            cj.GetLocalMap(sc);
        } while (runningGameStatus);
        sc.close();
    }
}
