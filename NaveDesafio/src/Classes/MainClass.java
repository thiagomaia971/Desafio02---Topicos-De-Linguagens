package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		float[] avioesDistancia = new float[3];
		
		float[] coordenadas = new float[NumeroAvioes("arquivo.txt")];
		
		AvioesDistancia("arquivo.txt", avioesDistancia);

		System.out.printf("O avião %.0f com o avião %.0f tem a distancia: %.7f", 
				avioesDistancia[0], avioesDistancia[1], avioesDistancia[2]);

	}

	private static float[] AvioesDistancia(String File, float[] avioesDistancia) {

		try {
			FileReader arquivo = new FileReader(File);
			BufferedReader lerArq = new BufferedReader(arquivo);
			int lineCont = 1;

			String linha = lerArq.readLine();
			while (linha != null) {
				if (lineCont == 1) {
					float[] coordenadaAvioes = new float[Integer.parseInt(linha)];
				}

				linha = lerArq.readLine();
				lineCont++;
			}

			arquivo.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		avioesDistancia[0] = 1;
		avioesDistancia[1] = 2;
		avioesDistancia[2] = 10;

		return avioesDistancia;

	}

	private static int NumeroAvioes(String File) {
		try {
			FileReader arquivo = new FileReader(File);
			BufferedReader lerArq = new BufferedReader(arquivo);

			String linha = lerArq.readLine();
			while (linha != null) {
				return Integer.parseInt(linha);
			}
			linha = lerArq.readLine();

			arquivo.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return 0;
	}

	private static float[] PopularArray(String File, float[] coordenadas){
		try {
			FileReader arquivo = new FileReader(File);
			BufferedReader lerArq = new BufferedReader(arquivo);

			String linha = lerArq.readLine();
			linha = lerArq.readLine();
			
			int contCoordenadas = 0;
			while (linha != null) {
			}
			linha = lerArq.readLine();

			arquivo.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return coordenadas;
	}
	
}
