//Método para verificar se o palpite está contido na palavra

public class Verificar{
  public static boolean correta(String advinhar, String responder, int len){
    for(int i = 0; i < len; i++){
      if(responder.substring(i,i+1).equals(advinhar)){
        return true;
      }
    }
    return false;
  }
}