//Gerar palavras aleatorias

public class Palavra{
  public static String gerarPalavraSecreta(){
    
    String [] palavras = {"analise","sistemas","computador","internet","diagramas","programacao","hardware","software", "python", "java"};
  
    String palavraSecreta = palavras[(int)(Math.random()*(palavras.length))];
    
    return palavraSecreta;
  }
}
