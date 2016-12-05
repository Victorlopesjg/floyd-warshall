import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("entrada.txt"));

		int size = input.nextInt();
		int[][] matrizPredecessor = new int[size][size];
		int[][] matrizDistancia = new int[size][size];

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				if (input.hasNextInt()) {
					int valor = input.nextInt();
					matrizDistancia[i][j] = valor;
					if (valor != 999 && i != j) {
						matrizPredecessor[i][j] = i;
					}
					System.out.print(String.valueOf(matrizDistancia[i][j]) + " ");
				}
			}
			System.out.print("\n");
		}

		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					int auxpre = matrizDistancia[i][j];
					if (matrizDistancia[i][j] > (matrizDistancia[i][k] + matrizDistancia[k][j]) && matrizDistancia[i][k] != 999 && matrizDistancia[k][j] != 999) {
						matrizDistancia[i][j] = matrizDistancia[i][k] + matrizDistancia[k][j];
						matrizPredecessor[i][j] = k;
					}
				}
			}
		}

		System.out.print("\nRESULTADOS\n");

		System.out.println("\nMATRIZ DISTANCIA\n");

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.print(String.valueOf(matrizDistancia[i][j]) + " ");
			}
			System.out.print("\n");
		}

		System.out.println("\nMATRIZ PREDECESSOR\n");

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.print(String.valueOf(matrizPredecessor[i][j]) + " ");
			}
			System.out.print("\n");
		}

	}
}
