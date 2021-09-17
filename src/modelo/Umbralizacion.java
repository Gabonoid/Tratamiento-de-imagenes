package modelo;

public class Umbralizacion {

    public static short[][] inverso(short[][] matrizOriginal) {
        short[][] matrizInverso = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                matrizInverso[i][j] = (short) (255 - matrizOriginal[i][j]);
            }
        }
        return matrizInverso;
    }

    public static short[][] umbral(short[][] matrizOriginal, short u) {
        short[][] matrizUmbral = new short[matrizOriginal.length][matrizOriginal[0].length];
        u = 253;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] <= u) {
                    matrizUmbral[i][j] = 0;
                } else {
                    matrizUmbral[i][j] = 255;
                }
            }
        }
        return matrizUmbral;
    }

    public static short[][] umbralBinario(short[][] matrizOriginal, short u1, short u2) {
        short[][] matrizUmbralBinario = new short[matrizOriginal.length][matrizOriginal[0].length];
        u1 = 90;
        u2 = 180;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] < u1 || matrizOriginal[i][j] > u2) {
                    matrizUmbralBinario[i][j] = 0;
                }
                if (u1 > matrizOriginal[i][j] && matrizOriginal[i][j] < u2) {
                    matrizUmbralBinario[i][j] = 255;
                }
            }
        }
        return matrizUmbralBinario;
    }

    public static short[][] umbralGris(short[][] matrizOriginal, short u1, short u2) {
        short[][] matrizUmbralGris = new short[matrizOriginal.length][matrizOriginal[0].length];
        u1 = 90;
        u2 = 180;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] < u1 || matrizOriginal[i][j] > u2) {
                    matrizUmbralGris[i][j] = 255;
                }
                if (u1 > matrizOriginal[i][j] && matrizOriginal[i][j] < u2) {
                    matrizUmbralGris[i][j] = matrizOriginal[i][j];
                }
            }
        }
        return matrizUmbralGris;
    }

    public static short[][] extension(short[][] matrizOriginal, short u1, short u2) {
        short[][] matrizExtension = new short[matrizOriginal.length][matrizOriginal[0].length];
        u1 = 90;
        u2 = 180;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] < u1 || matrizOriginal[i][j] > u2) {
                    matrizExtension[i][j] = 255;
                }
                if (u1 > matrizOriginal[i][j] && matrizOriginal[i][j] < u2) {
                    short suma = (short) ((255 * (matrizOriginal[i][j] - u1)) / (u2 - u1));
                    matrizExtension[i][j] = (short) ((suma >= 0) ? suma : (suma * -1));
                }
            }
        }
        return matrizExtension;
    }

  

}
