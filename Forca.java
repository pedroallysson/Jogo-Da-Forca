//Imprime o boneco de acordo com a quantidade de erros.

public class Forca{
    public static void imprimirForca(int vidas){
    if (vidas==7){
          //prints hanger w/ 7 lives
      System.out.print(" ----------------------- \n|Jogo da Forca|\n ----------------------- \n\n----------\n|\t|\n|\n|\n|\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==6){
      System.out.print("\n----------\n|\t|\n|\tO\n|\n|\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==5){
      System.out.print("\n----------\n|\t|\n|\tO\n|\t|\n|\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==4){
      System.out.print("\n----------\n|\t|\n|\tO\n|      /|\n|\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==3){
      System.out.print("\n----------\n|\t|\n|\tO\n|      /|\\\n|\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==2){
      System.out.print("\n----------\n|\t|\n|\tO\n|      /|\\\n|      /\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==1){
      System.out.print("\n----------\n|\t|\n|\tO\n|      /|\\\n|      / \\\n|\n|\n|\n--------\n\n");
    }
    else if (vidas==0){
      System.out.print("\n----------\n|\t|\n|\tx\n|      /|\\\n|      / \\\n|\n|\n|\n--------\n\n"); 
    }
  }
}