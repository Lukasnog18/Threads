package Matrix_Multiplication;

import java.util.Random;

public class MatrixMultiplicationSequential {
    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();
        Random rand = new Random();

        // Criando as matrizes
        int linhaA = 3, colunaA = 3;
        int[][] matrizA = new int[linhaA][colunaA];

        int linhaB = 3, colunaB = 3;
        int[][] matrizB = new int[linhaB][colunaB];


        // Preenchendo as matrizes
        for(int i = 0; i < linhaA; i++) {
            for(int j = 0; j < colunaA; j++) {
                matrizA[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("");

        for(int i = 0; i < linhaB; i++) {
            for(int j = 0; j < colunaB; j++) {
                matrizB[i][j] = rand.nextInt(10);
            }
        }

        // Imprimindo as matrizes A e B
//		for(int i = 0; i < linhaA; i++) {
//			for(int j = 0; j < colunaA; j++) {
//				System.out.print(matrizA[i][j] + " ");
//			}
//			System.out.println("");
//		}
//
//		System.out.println("");
//
//		for(int i = 0; i < linhaB; i++) {
//			for(int j = 0; j < colunaB; j++) {
//				System.out.print(matrizB[i][j] + " ");
//			}
//			System.out.println("");
//		}
//
//		System.out.println("");


        // Realizando a multiplicação
        if (matrizA[0].length == matrizB.length) {
            // Criando a matriz resultante
            int[][] matrizC = new int[linhaA][colunaB];

            // Preenchendo a matriz resultante com o resultado
            // da multiplicaÃ§Ã£o entre a matrizA e a matrizB
            for (int i = 0; i < linhaA; i++) {
                for (int j = 0; j < colunaB; j++) {
                    for (int k = 0; k < linhaB; k++) {
                        matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }

            // Imprimindo a matriz resultante
            for (int i = 0; i < linhaA; i++) {
                for (int j = 0; j < colunaB; j++) {
                    System.out.print(matrizC[i][j] + " ");
                }
                System.out.println("");
            }

        } else {
            System.out.println("Não é possível realizar a multiplicação");
        }

        System.out.println("A multiplicação foi feita em "
                + (System.currentTimeMillis() - tempoInicial)  + "ms");
    }
}
