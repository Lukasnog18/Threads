package Matrix_Multiplication;

import java.io.IOException;

public class MatrixMultiplicationThreadMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        long tempoInicial = System.currentTimeMillis();

        MatrixMultiplicationThread mt = new MatrixMultiplicationThread();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (mt) {
                    int aux[][] = mt.MatrixMultiplication();
                    int linha = aux.length, coluna = aux[0].length;

                    for (int i = 0; i < linha; i++) {
                        for (int j = 0; j < coluna; j++) {
                            System.out.print(aux[i][j] + " ");
                        }
                        System.out.println("");
                    }
                }

            }
        });

        thread.start();
        thread.join();

        System.out.println("A multiplicação foi feita em "
                + (System.currentTimeMillis() - tempoInicial) + "ms");
    }
}
