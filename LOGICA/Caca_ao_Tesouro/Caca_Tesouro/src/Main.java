import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        //Declarações Globais
        Scanner sc = new Scanner(System.in);
        Classe_Jogo cj = new Classe_Jogo();
        //boolean runningGameStatus;
        cj.painelGameInit();
        cj.MapGame();
              
        sc.close();
    }
}
