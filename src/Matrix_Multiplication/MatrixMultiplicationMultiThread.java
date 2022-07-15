package Matrix_Multiplication;

import java.util.Random;

public class MatrixMultiplicationMultiThread implements Runnable {
    private int row;
    private int column;
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] matrixC;

    public MatrixMultiplicationMultiThread (int row, int column, int[][] matrixA, int[][] matrixB, int[][] matrixC) {
        this.row = row;
        this.column = column;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
    }

    @Override
    public void run() {
        int K = matrixA[0].length;

        for (int k = 0; k < K; k++) {
            matrixC[row][column] += matrixA[row][k] * matrixB[k][column];

			System.out.println(Thread.currentThread().getName() + " Calculando " + matrixA[row][k] +
						" * " + matrixB[k][column] + " = " +  matrixA[row][k] * matrixB[k][column]);
        }
        System.out.println(Thread.currentThread().getName() + " Resultado " + matrixC[row][column]);
        matrixPrint(matrixC);
    }

    public static void matrixPrint(int[][] aux) {
        int lines = aux.length;
        int cols = aux[0].length;

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(aux[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(";");
    }

    // Preenchendo
    public static int[][] setMatrix(int row, int col) {
        Random rand = new Random();
        int aux[][] = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                aux[i][j] = rand.nextInt(10);
            }
        }

        System.out.println("");
        return aux;
    }


    public static void main(String[] args) {
        long tempoInicial = System.currentTimeMillis();

        int rowA = 3, colA = 3;
        int[][] aMatrix = setMatrix(rowA, colA);

        int rowB = 3, colB = 3;
        int[][] bMatrix = setMatrix(rowB, colB);

        int product[][] = new int[rowA][colB];


        int M = aMatrix.length;
        int N = bMatrix[0].length;

        if (M != N) {
            throw new IllegalArgumentException("Matrizes Diferentes: " + M + "!=" + N);
        }

        int numThreads = M * N;
        Thread[] workers = new Thread[numThreads];
        int auxThreads = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                workers[auxThreads] = new Thread(new MatrixMultiplicationMultiThread(i, j, aMatrix, bMatrix, product));
                workers[auxThreads].start();
                try {
                    workers[auxThreads].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                auxThreads++;
            }
        }

        System.out.println("A multiplicação foi feita em "
                + (System.currentTimeMillis() - tempoInicial)  + "ms");
    }
}
