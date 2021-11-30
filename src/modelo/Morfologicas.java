package modelo;

public class Morfologicas {

    public static short[][] erocion(short matrizOriginal[][], short[][] matriz) {
        short matrizModificada[][] = new short[matrizOriginal.length][matrizOriginal[0].length];

        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                matrizModificada[i][j] = matrizOriginal[i][j];
            }
        }

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {
                double contador = 0;

                if (matriz[0][0] == 1 || matriz[0][1] == 1 || matriz[0][2] == 1 || matriz[1][0] == 1 || matriz[1][1] == 1 || matriz[1][2] == 1
                        || matriz[2][0] == 1 || matriz[2][1] == 1 || matriz[2][2] == 1) {

                    if (matrizOriginal[x - 1][y - 1] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x][y - 1] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x + 1][y - 1] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x - 1][y] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x][y] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x + 1][y] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x - 1][y + 1] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x][y + 1] == 0) {

                        contador++;
                    }
                    if (matrizOriginal[x + 1][y + 1] == 0) {

                        contador++;
                    }

                }

                double nuevoContador = contador;

                if (nuevoContador <= 4.5) {

                    matrizModificada[x][y] = 255;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

                if (nuevoContador <= 2.25) {

                    matrizModificada[x][y] = 255;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

                if (nuevoContador <= 6.75) {

                    matrizModificada[x][y] = 255;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

            }

        }
        return matrizModificada;

    }

    public static short[][] dilatacion(short matrizOriginal[][]) {
        short matrizModificada[][] = new short[matrizOriginal.length][matrizOriginal[0].length];

        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                matrizModificada[i][j] = matrizOriginal[i][j];
            }
        }

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {
                double contador = 0;

                if (matrizOriginal[x - 1][y - 1] == 255) {

                    contador++;
                }
                if (matrizOriginal[x][y - 1] == 255) {

                    contador++;
                }
                if (matrizOriginal[x + 1][y - 1] == 255) {

                    contador++;
                }
                if (matrizOriginal[x - 1][y] == 255) {

                    contador++;
                }
                if (matrizOriginal[x][y] == 255) {

                    contador++;
                }
                if (matrizOriginal[x + 1][y] == 255) {

                    contador++;
                }
                if (matrizOriginal[x - 1][y + 1] == 255) {

                    contador++;
                }
                if (matrizOriginal[x][y + 1] == 255) {

                    contador++;
                }
                if (matrizOriginal[x + 1][y + 1] == 255) {

                    contador++;
                }

                double nuevoContador = contador;

                if (nuevoContador <= 4.5) {

                    matrizModificada[x][y] = 0;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

                if (nuevoContador <= 2.25) {

                    matrizModificada[x][y] = 0;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

                if (nuevoContador <= 6.75) {

                    matrizModificada[x][y] = 0;

                } else {
                    matrizModificada[x][y] = matrizOriginal[x][y];
                }

            }

        }
        return matrizModificada;

    }

}
