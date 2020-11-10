import java.util.Scanner;
import java.io.*;
class Principal{

	/*
	Este metodo eh responsavel por ler o arquivo, ao avancar
	o numero de elementos contidos em uma linha, ele pula para
	a proxima.
	*/

	public static int[][] leitor(File arq, int tamanhoVetor){
		try{
			Scanner ler = new Scanner(arq);
			int i = 0;
			int[][] saida = new int[50][tamanhoVetor];
			while(ler.hasNextLine()){
				String linha = ler.nextLine();
				String[] vetorIndString = linha.split(" ");
				float[] vetorInd = new float[tamanhoVetor];
				int[] vetorInt = new int[tamanhoVetor];
				for(int j = 0; j < tamanhoVetor; j++){
					vetorInd[j] = Float.parseFloat(vetorIndString[j]);
					vetorInt[j] = (int)vetorInd[j];
					if(j == (tamanhoVetor - 1)){
						System.out.println(vetorInt[j]);
					}
					else{
						System.out.print(vetorInt[j] + "  ");
					}
				}
				for(int j = 0; j < tamanhoVetor; j++){
					saida[i][j] = vetorInt[j];
				}
				i++;
			}
			return saida;
		}
		catch(FileNotFoundException ex){
			return null;
		}
	}

	/*	
		Metodo principal, responsavel tanto por chamar as funcoes de leitura de arquivo
		como pela ordenacao destes arrays. Além disso, eh medido o tempo de execucao
		gasto apenas para ordenar os arrays (sem considerar o tempo de leitura ou de escrita).
		Por fim, eh calculada uma media, somando o tempo de execucao desses algoritmos
		dividido pelo numero de linhas.
	*/
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Atividade2 order = new Atividade2();

		System.out.println("Qual o arquivo a ser lido?");
		String arq = sc.nextLine();

		char[] arq2 = arq.toCharArray();
		char[] tamanhoEmChar = new char[arq2.length - 5];
		int j;

		for(int i = 0; i < (arq2.length - 5); i++){
		  tamanhoEmChar[i] = arq2[i + 5];
		}

		String tamanhoEmString = new String(tamanhoEmChar);

		int tamanhoVetor = Integer.parseInt(tamanhoEmString);

		arq = arq + ".txt";
		File arquivo = new File(arq);
		int[][] vetores = leitor(arquivo, tamanhoVetor);

		System.out.println("Selecione a operacao \n 1: Binary Insertion Sort iterativo; \n 2: Binary Insertion Sort recursivo; \n 3: Insertion Sort iterativa; \n 4: Insertion Sort recursivo; \n 5: Sair.");
		String operacao = sc.nextLine();

		while(!operacao.equals("5")){

			if(operacao.equals("1")){
				long inicio = System.nanoTime();
				for(int i = 0; i < 50; i++){
					order.BinaryInsertionSort(vetores[i]);
				}
				long tempoTotal = System.nanoTime() - inicio;
				System.out.println("Utilizando o InsertionSort binario iterativo, o tempo medio de execucao para um vetor de " + tamanhoVetor + " elementos e: " + tempoTotal/50 + "ns");
			}

			else if(operacao.equals("2")){
				long inicio = System.nanoTime();
				for(int i = 0; i < 50; i++){
					int[] resultado = order.BinaryInsertionSortR(vetores[i], tamanhoVetor);
				}
				long tempoTotal = System.nanoTime() - inicio;
				System.out.println("Utilizando o InsertionSort binario recursivo, o tempo medio de execucao para um vetor de " + tamanhoVetor + " elementos e: " + tempoTotal/50 + "ns");
			}

			else if(operacao.equals("3")){
				long inicio = System.nanoTime();
				for(int i = 0; i < 50; i++){
					order.InsertionSort(vetores[i]);
				}
				long tempoTotal = System.nanoTime() - inicio;
				System.out.println("Utilizando o InsertionSort iterativo, o tempo medio de execucao para um vetor de " + tamanhoVetor + " elementos e: " + tempoTotal/50 + "ns");
			}

			else if(operacao.equals("4")){
				long inicio = System.nanoTime();
				for(int i = 0; i < 50; i++){
					order.InsertionSortR(vetores[i], tamanhoVetor);
				}

				long tempoTotal = System.nanoTime() - inicio;
				System.out.println("Utilizando o InsertionSort recursivo, o tempo medio de execucao para um vetor de " + tamanhoVetor + " elementos e: " + tempoTotal/50 + "ns");
			}

			else if(operacao.equals("5")){}

			else{
				System.out.println("Operacao invalida.");
			}

			System.out.println("Selecione a operacao \n 1: Binary Insertion Sort iterativo; \n 2: Binary Insertion Sort recursivo; \n 3: Insertion Sort iterativa; \n 4: Insertion Sort recursivo; \n 5: Sair.");
			operacao = sc.nextLine();
		}
		System.out.println("Saindo (:");
	}
}