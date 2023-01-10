/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Pedro
 */
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    
    //Boas vinda e escolher modo multiplayer/singleplayer
    Scanner numOfPlayers = new Scanner(System.in);
    Forca.imprimirForca(1);
    
    System.out.print("Bem-vindo ao jogo da Forca!\nSelecione o modo de Jogo abaixo:\n'M' para Modo Multiplayer\n\'S' para Modo Singleplayer\n\nOBS: Se escolher modo multiplayer, você poderá inserir sua própria frase secreta para seu amigo advinhar..\n");
    
    String playerNumber = numOfPlayers.nextLine();
    playerNumber = playerNumber.toLowerCase();
    
    //Verifica se uma opção valida foi escolhida
    while (!(playerNumber.equals("m")||playerNumber.equals("s"))){
      System.out.print("\n\nOpção Inválida. Digite 'M' para Multiplayer ou  'S' para Singleplayer.\n");
      playerNumber = numOfPlayers.nextLine();
      playerNumber = playerNumber.toLowerCase();
    }
    
    
    //Verifica se é multiplayer ou singleplayer
    String resposta = "";
    if (playerNumber.equals("m")){
      for (int i=1;i<=54;i++){
      System.out.print("\n");
      }

      
      Scanner userPalavra = new Scanner(System.in);
      boolean legalPalavra = false;
      String testPalavra = "";
      String palavraSecreta = "";
      
      while(!legalPalavra){
        System.out.print("\n\nInsira a palavra secreta:\n");
        palavraSecreta="";
        testPalavra="";
        palavraSecreta = userPalavra.nextLine();
        for (int i=0; i<palavraSecreta.length();i++){
          if((Character.isLetter(palavraSecreta.charAt(i))||palavraSecreta.substring(i,i+1).equals(" "))){
            testPalavra += palavraSecreta.substring(i,i+1);
          }
        }
        if (testPalavra.equals(palavraSecreta)){
          legalPalavra=true;
        }
        else {
          for (int i=1;i<=54;i++){
            System.out.print("\n");
          }
          System.out.print ("Essa não é uma frase válida.\n\tNão inclua números ou caracteres especiais.");
        }
      }
      resposta = palavraSecreta;
    }
    else if (playerNumber.equals("s")) {
      resposta = Palavra.gerarPalavraSecreta();
    }
    
    //Inicio do jogo
    
    for (int i=1;i<=54;i++){
      System.out.print("\n");
    }
    resposta = resposta.toLowerCase();
    
    int vidas = 7;
    String letrasEscolhidas = "";
    int len = resposta.length();
    boolean correta = false;
    String revealedPhrase="";
    Forca.imprimirForca(vidas);
    
    Atualizar.stringSecreta(letrasEscolhidas,resposta);    
    
    
    //Verifica se a letra já foi adivinhada ou se há suposições inválidas
    Scanner input= new Scanner(System.in);
    
    while (vidas>0&&(!correta)){
      System.out.print("\n\nQual é seu palpite\n");
      String advinhar = input.nextLine();
      advinhar = advinhar.toLowerCase();
      
      if (advinhar.equals("")||advinhar.equals(" ")){
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("**Você não advinhou. Por favor insira um palpite.**\n");
      }
      else if (!(Character.isLetter(advinhar.charAt(0)))) {
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print("**Você não advinhou a letra. Por favor advinhe uma letra.**\n");
      }
      else if (letrasEscolhidas.contains(advinhar)){
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("**Você já advinhou essa letra. Advinhe de novo.**\n");
      }
      else if (advinhar.length()>1) { 
        for (int i=1;i<=54;i++){
          System.out.print("\n");
        }
        System.out.print ("**Seu palpite é muito longo, por favor digite apenas uma letra.**\n");
      }
      
      // Adiciona letras à lista de letras já adivinhadas
      else {
        if (letrasEscolhidas.equals("")){
          letrasEscolhidas+=(advinhar);
        }
        else {
          letrasEscolhidas+=(", "+ advinhar);
        }
        // Verifica se a palavra contém a letra adivinhada
        if (!(Verificar.correta(advinhar, resposta, len))){
          vidas--;
        }
        for (int i=1;i<=39;i++){
          System.out.print("\n");
        }
      }
      Forca.imprimirForca(vidas);
      revealedPhrase=Atualizar.stringSecreta(letrasEscolhidas,resposta);
      System.out.print ("\nLetras que já foram escolhidas: "+letrasEscolhidas);
        
      if (!(revealedPhrase.contains("_"))){
        correta = true;
      }
    }
    //Imprime uma mensagem de parabéns se você adivinhou corretamente a palavra secreta
    if (correta){
      System.out.print ("\n\nParabéns, você ganhou.");
    }
    
    //Imprime uma mensagem de derrota se você não adivinhou corretamente a palavra secreta
    else {
      System.out.print ("\n\nVocê perdeu e não escapou da forca.");
      System.out.print("\nA palavra secreta é: "+resposta);
    }  
  }
}

