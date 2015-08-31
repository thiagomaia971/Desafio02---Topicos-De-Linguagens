package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws IOException {
		long timeIni = System.currentTimeMillis(), timeFinal, deltaTime;
		//CriarTxt("arquivo.txt");
		float[] resultadoDistancia = new float[3];

		float[] coordenadasX = new float[NumeroAvioes("arquivo.txt")+1];
		float[] coordenadasY = new float[coordenadasX.length];

		PopularArray("arquivo.txt", coordenadasX, coordenadasY);

		AvioesDistancia("arquivo.txt", resultadoDistancia, coordenadasX,
				coordenadasY);

		timeFinal = System.currentTimeMillis();
		
		deltaTime = timeFinal - timeIni;
		
		System.out.printf(
				"O avião %.0f com o avião %.0f tem a distancia: %.2f\nTime: %d (ms)",
				resultadoDistancia[0], resultadoDistancia[1],
				resultadoDistancia[2], deltaTime);
	}
	
	private static float[] AvioesDistancia(String File,
			float[] avioesDistancia, float[] coordenadasX, float[] coordenadasY) {

		for (int i = 1; i < coordenadasY.length; i++) {
			int j = i;
			while(j < coordenadasY.length){
				if (i == j) {

					j++;

				}
				if (!(j >= coordenadasX.length)) {

					float x = coordenadasX[i] - coordenadasX[j];
					float y = coordenadasY[i] - coordenadasY[j];

					float res = (float) Math.sqrt((x * x) + (y * y));
					if(i == 1){
						avioesDistancia[0] = i;
						avioesDistancia[1] = j;
						avioesDistancia[2] = res;
					}else if (res < avioesDistancia[2]) {
						avioesDistancia[0] = i;
						avioesDistancia[1] = j;
						avioesDistancia[2] = res;
					}
				}
				j++;
			}
		}
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
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		return 0;
	}

	private static void PopularArray(String File, float[] coordenadasX,
			float[] coordenadasY) {
		try {
			FileReader arquivo = new FileReader(File);
			BufferedReader lerArq = new BufferedReader(arquivo);

			String line = lerArq.readLine();
			line = lerArq.readLine();
			int contSplit = 1;

			while (line != null) {
				String[] splitT = line.split(" ");
				coordenadasX[contSplit] = Float.parseFloat(splitT[0]);
				coordenadasY[contSplit] = Float.parseFloat(splitT[1]);

				contSplit++;
				line = lerArq.readLine();
			}

			arquivo.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
		// return coordenadas;
	}

		
}
