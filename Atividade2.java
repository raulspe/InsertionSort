class Atividade2{

  //InsertionSort Binário

  public static int BinarySearch(int[] array, int fim, int chave){
    int inicio = 0;   // Iremos reordenar o arranjo da esquerda pra direita, utilizando o 0 como ínicio
    /*
      Enquanto o comeco é menor igual que o fim, o algortimo é executado, no contrário,
    ele retorna a posição em que a chave esta.
    */
    while(inicio <= fim){
    int meio = inicio + (fim - inicio) / 2;       // Pesquisamos o valor intermediário do vetor.
    /*
    Caso o meio do arranjo seja maior que a chave, o programa reduz o perímetro de buscas
    excluíndo todos os ítens maiores que a chave, caso contrário, o mesmo exclui os ítens 
    menores que a chave.
    */
      if(chave < array[meio]){
        fim = meio - 1;
      }
      else{
        inicio = meio + 1;
      }
    }
    return inicio;
  }

  public static int[] BinaryInsertionSort(int[] array){
    int tam = array.length;
    /*
      Para todos os elementos do arranjo, da esquerda para direita, o alogoritmo realoca o elemento para sua posição correta.
    */

    for(int i = 0; i < (tam - 1); i++){
      int pos = BinarySearch(array, i, array[i + 1]);
      int j = i + 1;
      while(j > pos){
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
        j--;
      }
    }
    return array;
  }

  //InsertionSort Binário Recursivo

  public static int BinarySearchR(int[] array, int inicio, int fim, int chave){
    if(inicio <= fim){
      // Pesquisamos o valor intermediário do vetor.
      int meio = inicio + (fim - inicio) / 2;
      if(chave < array[meio]){
        return(BinarySearchR(array, inicio, (meio - 1), chave));
      }
      /*
        Se valor é maior igual que o valor do meio do arranjo, ele reduz o
      perímetro de buscas do meio até o fim.
      */
      else{
        return(BinarySearchR(array, (meio + 1), fim, chave));
      }
    }
    /*
      Se o fim do perímetro de buscas for menor que o início, ele retorna a posição
    que a chave deve ser reacolocada.
    */
    else{
      return inicio;
    }
  }

  public static int[] BinaryInsertionSortR(int[] array, int n){
    // Se n é maior que 1, o algoritmo é executado. Do contrário, retorna o arranjo pronto.
    if(n > 1){
      int tam = array.length;
      int posicaoChave = (tam - n + 1);
      int posicaoCerta = BinarySearchR(array, 0, (posicaoChave - 1), array[posicaoChave]);
      /*
        Caso a posição da chave seja maior que 1, o programa identifica se a chave está
      na posição correta, caso contrário ele leva a chave ao seu lugar.
      */
      if(posicaoChave > 1){
        if(posicaoCerta < posicaoChave){
          int temp = array[posicaoChave];
          array[posicaoChave] = array[posicaoChave - 1];
          array[posicaoChave - 1] = temp;
        }
        return(BinaryInsertionSortR(array, n - 1));
      }
      /*
        Caso a posição da chave seja 1, já que ela nunca será menor que 1, o programa,
      se necessário, ajeita a posição da chave e faz no próximo item do vetor a nova chave.
      */
      else{
        if(posicaoCerta < posicaoChave){
          int temp = array[posicaoChave];
          array[posicaoChave] = array[posicaoChave - 1];
          array[posicaoChave - 1] = temp;
          return(BinaryInsertionSortR(array, n - 1));
        }
        else{
          return(BinaryInsertionSortR(array, n - 1));
        }
      }
    }
    else{
      return array;
    }
  }

  //Insertion Sort
  
  public static int[] InsertionSort(int[] array){
    int n = array.length;
    int maior = array[0];
    /*
    Se um dos elementos do arranjo for maior que o ultimo elemento maior até então, 
    ele se torna o novo maior. Entretanto se ele for menor,
    o elemento é recolocado para a esquerda até que o elemento anterior a ele seja
    menor que ele, organizando o arranjo desta forma em ordem crescente.
    */
    for(int i = 1; i < n; i++){
      if(array[i] >= maior){
        maior = array[i];
      }
      else{
        array[i - 1] = array[i];
        array[i] = maior;
        int j = i;
          while(j > 1 && array[j - 1] < array[j - 2]){
          int temp = array[j - 2];
          array[j - 2] = array[j - 1];
          array[j - 1] = temp;
          j--;
        }
      }
    }
    return array;
  }


  
//Insertion Sort recursivo

public static int[] InsertionSortR(int[] array, int n){
  /*
  O é percorrido, enquanto ele não chega no 1º elemento do sub-arranjo,
  ele busca e identifica o maior elemento, o levando para a esquerda,
  reorganizando o arranjo em ordem crescente.
  */
    if(n >= 1){
      int maior = array[0];
      for(int i = 1; i < n; i++){
        if(array[i] >= maior){
          maior = array[i];
        } 
        else{
          array[i - 1] = array[i];
          array[i] = maior;
        }
      }
      InsertionSortR(array, (n - 1));
      return array;
    }
    else{
      return null;
    }
  } 
}
