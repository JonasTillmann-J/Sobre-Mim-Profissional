import java.util.Scanner;
import java.util.Random;
public class Classe_Jogo {
    //declarações da classe
    //declaração de inteiros
    private int contadorPGI = 1, posicaoHorizontal, posicaoVertical, horizontal, vertical, userDataHorizontal, userDataVertical, pontuacao = 0, valorTesouro = 10, valorArmadilha = 5;
    //declaração de booleanos
    private boolean horizontalCheckStatus = false, verticalCheckStatus = false;
    //declaração de matrizes
    private char[][] matriz = new char[9][9];
    private char[][] ShadowMatriz = new char[9][9];
    //declaração de classes externas
    private Random random = new Random();

    //inicialização das partes minimas do jogo
    public void InitGame(){
        // Inicialização da Matriz com o caracter "~" que representa a areia
        for (int i = 1; i < this.matriz.length; i++) {
            for (int j = 1; j < this.matriz.length; j++) {
                matriz[i][j] = '~';
            }
        }
        // fazendo uma sombra do mapa que guarda a posição dos tesourose armadilhas e lugares "vazios"
        // Criando a posição aleatorias dos tesouros e apontando na sombra
        for (int k = 0; k < 8; k++) {
            //declarando a classe Random
            //Usando a Classe Ramdon para gerar valores para a localização
            while (true) {
            //gera as pocicoes limitado a 1 até 8
                posicaoHorizontal = random.nextInt(8) + 1;
                posicaoVertical = random.nextInt(8) + 1;
                //verifica se está fazia se estiver ele adiciona o valor e vai para a proxima localizacao
                //se tiver algo ele gera os numeros novamente até achar algo vazio
                if (ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'T' && ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'A') {
                    ShadowMatriz[posicaoHorizontal][posicaoVertical] = 'T';
                    break;
                }
            }  
        }
        for (int i = 0; i < 5; i++) {
             while (true) {
            //gera as pocicoes limitado a 1 até 8
                posicaoHorizontal = random.nextInt(8) + 1;
                posicaoVertical = random.nextInt(8) + 1;
                //verifica se está fazia se estiver ele adiciona o valor e vai para a proxima localizacao
                //se tiver algo ele gera os numeros novamente até achar algo vazio
                if (ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'T' && ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'A') {
                    ShadowMatriz[posicaoHorizontal][posicaoVertical] = 'A';
                    break;
                }
            }  
        }
    }
    
    //painel do jogo
    public boolean painelGameInit(Scanner sc, Boolean runningGameStatus){
        //painel do jogo depois do primeiro acesso
        if (this.contadorPGI  > 1) {
            System.out.println("_________________________\n|Aperte S para Recomecar|\n| Ou Aperte N para sair |\n|_______________________|\n");
        char response = sc.nextLine().charAt(0);
        this.contadorPGI++;
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        //painel do jogo no primeiro acesso
        }else{
            System.out.println("__________________________________\n|Jogo Caça ao Tesouro de Terminal|\n|________________________________|\n\nExplore as coordenadas de uma Ilha Misteriosa para tentar achar os Tesouros Escondidos\nde pessoas que não lembram mais onde esconderam\n\nMas Cuidado essas mesmas pessoas colocaram armadilhas para gente como você\n\nO jogo acontece em um mapa de 8x8\n\ntendo 5 armadilhas que valem -5 pontos cada e 8 tesouro que\nvalem +10 pontos cada, escondidos aleatoriamente pelo mapa,\ntenha a sorte de encontrar todos os tesouros e nenhuma armadilha\n");
            System.out.println("_______________________\n|Aperte S para começar|\n|_____________________|\n");
        char response = sc.nextLine().charAt(0);
        contadorPGI++;
        //retornando a resposta do usuario para usar na main
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        }
    }
    //renderiza o mapa e informa ele ao jogador
    public void MapGame(boolean onlyMap){
        //mostra apenas o mapa e nada mais
        if (onlyMap) {
            int contadorV = 0;
            System.out.println("\n    1  2  3  4  5  6  7  8");
            for (int i = 1; i < this.matriz.length; i++) {
                System.out.println("");
                for (int j = 1; j < this.matriz.length; j++) {
                    contadorV++;
                    if (contadorV == 1) {
                        System.out.print(""+(i)+" | "+matriz[i][j]+"  ");
                    }else {
                        System.out.print(matriz[i][j]+"  ");
                    }
                }
             contadorV = 0;
            }
        System.out.println("\n__________________________");
        }else{
            //mostra o mapa atualizado atravez do input do usuario
            int contadorV = 0;
            System.out.println("\n    1  2  3  4  5  6  7  8");
            if(ShadowMatriz[this.horizontal][this.vertical] == 'T'){
                matriz[this.horizontal][this.vertical] = 'T';                
            }else if(ShadowMatriz[horizontal][this.vertical] == 'A'){
                matriz[this.horizontal][this.vertical] = 'A';                
            }else{
                matriz[this.horizontal][this.vertical] = 'O';
            }
            //renderiza o mapa atualizado
            for (int i = 1; i < matriz.length; i++) {
                System.out.println("");
                for (int j = 1; j < matriz.length; j++) {
                    contadorV++;
                    if (contadorV == 1) {
                    System.out.print(""+(i)+" | "+matriz[i][j]+"  ");
                }else{
                    System.out.print(matriz[i][j]+"  ");
                }
            }
            contadorV = 0;
            }
            //mostra as mesnsagens casa encontre tesouros, armadilhas ou vazios
            System.out.println("\n__________________________");
            //tesouro
            if(ShadowMatriz[this.horizontal][this.vertical] == 'T'){
                System.out.println("\n\nParabens, Você Achou um tesouro:");
                pontuacao += valorTesouro;
                System.out.println("pontuação: "+pontuacao);
            //armadilha
            }else if(ShadowMatriz[this.horizontal][this.vertical] == 'A'){
                System.out.println("\nDroga uma Armadilha:");
                pontuacao -= valorArmadilha;
                System.out.println("pontuação: "+pontuacao);
            //vazio
            }else{
                System.out.println("\nNão achei nada, Vamos continuar:");
                System.out.println("pontuação: "+pontuacao);
            }
            System.out.println("");
        }
    }

    public int getCoodHorizontal(Scanner sc){
        System.out.print("\nInforme a Coordenada Horizontal para cavar: ");
        userDataHorizontal = sc.nextInt();
        do {
            if(userDataHorizontal < 1){
                System.out.print("Você precisa Informar uma coordenada horizontal maior ou igual a 1\nInforme a coordenada novamente: ");
                userDataHorizontal = sc.nextInt();
            }else if(userDataHorizontal > 8){
                System.out.print("Você precisa Informar uma coordenada horizontal menor ou igual a 8\nInforme a coordenada novamente: ");
                userDataHorizontal = sc.nextInt();
            }else{
                this.horizontal = userDataHorizontal;
                horizontalCheckStatus = false;
            }
            return this.horizontal;
        } while (horizontalCheckStatus);
    }

    public int getCoodVertical(Scanner sc){
        System.out.print("\nInforme a Coordenada Vertical para cavar: ");
        userDataVertical = sc.nextInt();
        do{
            if(userDataVertical < 1){
                System.out.print("Você precisa Informar uma coordenada Vertical maior ou igual a 1\nInforme a coordenada novamente: ");
                userDataVertical = sc.nextInt();
            }else if(userDataVertical > 8){
                System.out.print("Você precisa Informar uma coordenada Vertical menor ou igual a 8\nInforme a coordenada novamente: ");
                userDataVertical = sc.nextInt();
            }else{
                this.vertical = userDataVertical;
                verticalCheckStatus = false;
            }
            return this.vertical;
        }while (verticalCheckStatus);
    }
}