import java.util.Scanner;
import java.util.Random;
public class Classe_Jogo {
    //declarações da classe
    private int contadorPGI = 1, posicaoHorizontal, posicaoVertical, horizontal, vertical, pontuacao = 0;
    private boolean horizontalCheckStatus = false, verticalCheckStatus = false;
    private char[][] matriz = new char[9][9];
    private char[][] ShadowMatriz = new char[9][9];
    private Random random = new Random();
    
    //painel do jogo
    public boolean painelGameInit(Scanner sc, Boolean runningGameStatus){
        //painel do jogo depois do primeiro acesso
        if (this.contadorPGI  > 1) {
            System.out.println(
        "_________________________\n"+
        "|Aperte S para Recomecar|\n"+
        "| Ou Aperte N para sair |\n"+
        "|_______________________|\n");
        char response = sc.nextLine().charAt(0);
        this.contadorPGI++;
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        //painel do jogo no primeiro acesso
        }else{
            System.out.println(
        "__________________________________\n"+
        "|Jogo Caça ao Tesouro de Terminal|\n"+
        "|________________________________|\n"+
        "\nExplore as coordenadas de uma Ilha Misteriosa para tentar achar os Tesouros Escondidos\n"+
        "de pessoas que não lembram mais onde esconderam\n"+
        "\nMas Cuidado essas mesmas pessoas colocaram armadilhas para gente como você\n"+

        "\nO jogo acontece em um mapa de 8x8\n"+

        "\ntendo 5 armadilhas que valem -5 pontos cada e 8 tesouro que\n"+
        "valem +10 pontos cada, escondidos aleatoriamente pelo mapa,\n"+
        "tenha a sorte de encontrar todos os tesouros e nenhuma armadilha\n"
        );
            System.out.println(
        "_______________________\n"+
        "|Aperte S para começar|\n"+
        "|_____________________|\n"
        );
        char response = sc.nextLine().charAt(0);
        contadorPGI++;
        //retornando a resposta do usuario para usar na main
        return runningGameStatus = response == 's' || response == 'S' ? true : false;
        }
    }
    public void InitGame(){
        // Inicialização da Matriz com o caracter "~" que representa a areia
        for (int i = 1; i < this.matriz.length; i++) {
            for (int j = 1; j < this.matriz.length; j++) {
                matriz[i][j] = '~';
            }
        }
        // fazendo uma sombra do mapa que guarda a posição dos tesouros
        // e armadilhas e sem nada
        for (int k = 0; k < 8; k++) {
            //| T tesouro | A armadilha | O Nada |
            //declarando a classe Random
            //Usando a Classe Ramdon para gerar valores para a localização
            while (true) {
            //gera as pocicoes
                posicaoHorizontal = random.nextInt(8) + 1;
                posicaoVertical = random.nextInt(8) + 1;
                System.out.println(posicaoHorizontal);
                System.out.println(posicaoVertical);
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
            //gera as pocicoes
                posicaoHorizontal = random.nextInt(8) + 1;
                posicaoVertical = random.nextInt(8) + 1;
                System.out.println(posicaoHorizontal);
                System.out.println(posicaoVertical);
                //verifica se está fazia se estiver ele adiciona o valor e vai para a proxima localizacao
                //se tiver algo ele gera os numeros novamente até achar algo vazio
                if (ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'T' && ShadowMatriz[posicaoHorizontal][posicaoVertical] != 'A') {
                    ShadowMatriz[posicaoHorizontal][posicaoVertical] = 'A';
                    break;
                }
            }  
        }
    }
    //renderiza o mapa e informa ele ao jogador
    public void MapGame(boolean onlyMap){
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
        }else{
            int contadorV = 0;
            System.out.println("\n    1  2  3  4  5  6  7  8");
            if(ShadowMatriz[horizontal][vertical] == 'T'){
                matriz[horizontal][vertical] = 'T';                
            }else if(ShadowMatriz[horizontal][vertical] == 'A'){
                matriz[horizontal][vertical] = 'A';                
            }else{
                matriz[horizontal][vertical] = 'O';
            }
            for (int i = 1; i < this.matriz.length; i++) {

                System.out.println("");
                for (int j = 1; j < this.matriz.length; j++) {
                    contadorV++;
                    if (contadorV == 1) {
                    System.out.print(""+(i)+" | "+matriz[i][j]+"  ");
                }else{
                    System.out.print(matriz[i][j]+"  ");
                }
            }
            contadorV = 0;
            }
            if(ShadowMatriz[horizontal][vertical] == 'T'){
                System.out.println("\n\nParabens, Você Achou um tesouro:");
                pontuacao += 10;
                System.out.println("pontuação: "+pontuacao);
                
            }else if(ShadowMatriz[horizontal][vertical] == 'A'){
                System.out.println("\nDroga uma Armadilha:");
                pontuacao += 10;
                System.out.println("pontuação: "+pontuacao);
                
            }else{
                System.out.println("\nNão achei nada, Vamos continuar:");
                System.out.println("pontuação: "+pontuacao);
            }
            System.out.println("");
        }
    }
    public void GetLocalMap(Scanner sc){
        System.out.println("\nInforme a Coordenada Horizontal");
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
    }
}