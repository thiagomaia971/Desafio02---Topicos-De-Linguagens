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
		// CriarTxt("arquivo.txt");
		float[] resultadoDistancia = new float[3];

		AvioesDistancia("arquivo.txt", resultadoDistancia);

		timeFinal = System.currentTimeMillis();

		deltaTime = timeFinal - timeIni;

		System.out
				.printf("O avião %.0f com o avião %.0f tem a distancia: %.2f\nTime: %d (ms)",
						resultadoDistancia[0] + 1, resultadoDistancia[1] + 1,
						resultadoDistancia[2], deltaTime);
	}

	private static float[] AvioesDistancia(String File, float[] avioesDistancia)
			throws IOException {
		boolean firstTime = false;

		FileReader arquivo = new FileReader(File);
		BufferedReader lerArq = new BufferedReader(arquivo);

		float[] coordX = null;
		float[] coordY = null;

		// Número de Avioes
		boolean closeArq = false;
		String linha = lerArq.readLine();
		while (!closeArq) {
			coordX = new float[Integer.parseInt(linha)];
			coordY = new float[coordX.length];
			closeArq = true;
		}
		linha = lerArq.readLine();

		// Populando
		int contSplit = 0;
		while (linha != null) {
			String[] splitT = linha.split(" ");
			coordX[contSplit] = Float.parseFloat(splitT[0]);
			coordY[contSplit] = Float.parseFloat(splitT[1]);

			contSplit++;

			linha = lerArq.readLine();
		}

		arquivo.close();

		for (int i = 0; i < coordY.length; i++) {
			for (int j = i; j < coordY.length; j++) {
				if (i != j) {
					if (!firstTime) {
						float x = coordX[i] - coordX[j];
						float y = coordY[i] - coordY[j];
						float res = (float) Math.sqrt((x * x) + (y * y));
						avioesDistancia[0] = i;
						avioesDistancia[1] = j;
						avioesDistancia[2] = res;
						firstTime = true;
					} else if ((1.1 * coordX[i]) > coordX[j]
							&& (coordX[i] / 2) < coordX[j]) {
						if ((1.1 * coordY[i]) > coordY[j]
								&& (coordY[i] / 2) < coordY[j]) {
							float x = coordX[i] - coordX[j];
							float y = coordY[i] - coordY[j];

							float res = (float) Math.sqrt((x * x) + (y * y));
							if (res < avioesDistancia[2]) {
								avioesDistancia[0] = i;
								avioesDistancia[1] = j;
								avioesDistancia[2] = res;
							}
						}

					}

				}
			}
		}
		return avioesDistancia;
	}

}
