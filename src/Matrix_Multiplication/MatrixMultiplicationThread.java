package Matrix_Multiplication;

import java.util.Random;

public class MatrixMultiplicationThread {
    Random rand = new Random();

    // Criando as matrizes
    int rowA = 3, colA = 3;
    int[][] matrixA = setMatrix(rowA, colA);

    int rowB = 3, colB = 3;
    int[][] matrixB = setMatrix(rowB, rowB);

    // Preenchendo
    public int[][] setMatrix(int row, int col) {
        int aux[][] = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                aux[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("");
        return aux;
    }

    public int[][] MatrixMultiplication(){
        // Criando a matriz resultante
        int[][] matrixC = new int[rowA][colB];

        if (matrixA[0].length == matrixB.length) {
            // Preenchendo a matriz resultante com o resultado
            // da multiplicação entre a matrizA e a matrizB
            for (int i = 0; i < rowA; i++) {
                for (int j = 0; j < colB; j++) {
                    for (int k = 0; k < rowB; k++) {
                        matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }
        } else {
            System.out.println("Não é possível realizar a multiplicação");
        }

        return matrixC;
    }
}
