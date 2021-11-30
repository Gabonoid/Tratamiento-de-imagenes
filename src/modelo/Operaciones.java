package modelo;

public class Operaciones {

    public static short[][] suma(short[][] matrizA, short[][] matrizB) {
        short[][] matrizSuma = new short[matrizA.length][matrizA[0].length];
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {

            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    matrizSuma[i][j] = (short) ((matrizA[i][j] + matrizB[i][j]) / 2);
                }
            }
        } else {
            System.out.println("Imagenes de diferentes dimensiones");
        }
        return matrizSuma;
    }

    public static short[][] resta(short[][] matrizA, short[][] matrizB) {
        short[][] matrizResta = new short[matrizA.length][matrizA[0].length];
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {

            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    int resta = matrizA[i][j] - matrizB[i][j];
                    matrizResta[i][j] = (short) ((resta < 0) ? resta * (-1) : resta);
                }
            }
        } else {
            System.out.println("Imagenes de diferentes dimensiones");
        }
        return matrizResta;
    }

    public static short[][] OR(short[][] matrizA, short[][] matrizB) {
        short[][] matrizOr = new short[matrizA.length][matrizA[0].length];
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {

            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    if (matrizA[i][j] == 255 && matrizB[i][j] == 255) {
                        matrizOr[i][j] = 255;
                    }
                    if (matrizA[i][j] == 255 && matrizB[i][j] == 0) {
                        matrizOr[i][j] = 0;
                    }
                    if (matrizA[i][j] == 0 && matrizB[i][j] == 255) {
                        matrizOr[i][j] = 0;
                    }
                    if (matrizA[i][j] == 0 && matrizB[i][j] == 0) {
                        matrizOr[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("Imagenes de diferentes dimensiones");
        }
        return matrizOr;
    }

    public static short[][] NOT(short[][] matrizA) {
        short[][] matrizNot = new short[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizNot.length; i++) {
            for (int j = 0; j < matrizNot[0].length; j++) {
                if (matrizA[i][j] == 0) {
                    matrizNot[i][j] = 255;
                } else {
                    matrizNot[i][j] = 0;
                }

            }

        }

        return matrizNot;
    }

    public static short[][] AND(short[][] matrizA, short[][] matrizB) {
        short[][] matrizAnd = new short[matrizA.length][matrizA[0].length];
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {

            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    if (matrizA[i][j] == 255 || matrizB[i][j] == 255) {
                        matrizAnd[i][j] = 255;
                    } else {
                        matrizAnd[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("Imagenes de diferentes dimensiones");
        }
        return matrizAnd;
    }

    public static short[][] XOR(short[][] matrizA, short[][] matrizB) {
        short[][] matrizXor = new short[matrizA.length][matrizA[0].length];
        if (matrizA.length == matrizB.length && matrizA[0].length == matrizB[0].length) {

            for (int i = 0; i < matrizA.length; i++) {
                for (int j = 0; j < matrizA[0].length; j++) {
                    if (matrizA[i][j] == matrizB[i][j]) {
                        matrizXor[i][j] = 255;
                    } else {
                        matrizXor[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("Imagenes de diferentes dimensiones");
        }
        return matrizXor;
    }
}
