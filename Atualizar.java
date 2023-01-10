//Atualiza os espaços em branco se o jogo singleplayer for escolhido

public class Atualizar{
  public static String stringSecreta(String letrasEscolhidas, String responder){
      String palavraOculta = "";
      int len = responder.length();
      for (int i=0; i<len; i++){
        String verificar = responder.substring(i, i+1);
        if (letrasEscolhidas.contains(verificar)){
          // adiciona um caso se estiver no final de uma palavra para que o espaço seja maior após
          palavraOculta += verificar + " ";
        }
        else if (!verificar.equals(" ")){
          palavraOculta += "_ ";
        }
        else{
          palavraOculta += "  ";
        }
      }
      System.out.print(palavraOculta);
      return palavraOculta;
  }
}