/*package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Second {

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
		Aviao[] coord = null;
		// Número de Avioes
		boolean closeArq = false;
		String linha = lerArq.readLine();
		while (!closeArq) {
			coord = new Aviao[Integer.parseInt(linha)];
			closeArq = true;
		}
		linha = lerArq.readLine();

		// Populando
		int contSplit = 0;
		while (linha != null) {
			String[] splitT = linha.split(" ");
			coord[contSplit] = new Aviao();
			
			coord[contSplit].x = Float.parseFloat(splitT[0]);
			coord[contSplit].y = Float.parseFloat(splitT[1]);

			contSplit++;

			linha = lerArq.readLine();
		}

		arquivo.close();
		int cont = 0;
		for (int i = 0; i < coord.length; i++) {
			for (int j = i; j < coord.length; j++) {
				if (i != j) {
					if (!firstTime) {
						float x = coord[i].x - coord[j].x;
						float y = coord[i].y - coord[j].y;
						float res = (float) Math.sqrt((x * x) + (y * y));
						avioesDistancia[0] = i;
						avioesDistancia[1] = j;
						avioesDistancia[2] = res;
						firstTime = true;
					} else if ((1.05 * coord[i].x) > coord[j].x && (coord[i].x / 2) < coord[j].x) {
						if ((1.05 * coord[i].y) > coord[j].y && (coord[i].y / 2) < coord[j].y) {
							
							float x = coord[i].x - coord[j].x;
							float y = coord[i].y - coord[j].y;

							float res = (float) Math.sqrt((x * x) + (y * y));
							cont++;
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
		System.out.println(cont);
		return avioesDistancia;
	}

}*/
