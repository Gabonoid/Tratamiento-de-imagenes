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

    public static short[][] reduccionGrises(short[][] matrizOriginal) {
        short[][] matrizExtension = new short[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] < 25) {
                    matrizExtension[i][j] = 0;
                } else if (matrizOriginal[i][j] >= 25 && matrizOriginal[i][j] < 50) {
                    matrizExtension[i][j] = 25;
                } else if (matrizOriginal[i][j] >= 50 && matrizOriginal[i][j] < 75) {
                    matrizExtension[i][j] = 50;
                } else if (matrizOriginal[i][j] >= 75 && matrizOriginal[i][j] < 100) {
                    matrizExtension[i][j] = 75;
                } else if (matrizOriginal[i][j] >= 100 && matrizOriginal[i][j] < 125) {
                    matrizExtension[i][j] = 100;
                } else if (matrizOriginal[i][j] >= 125 && matrizOriginal[i][j] < 150) {
                    matrizExtension[i][j] = 125;
                } else if (matrizOriginal[i][j] >= 150 && matrizOriginal[i][j] < 175) {
                    matrizExtension[i][j] = 150;
                } else if (matrizOriginal[i][j] >= 175 && matrizOriginal[i][j] < 200) {
                    matrizExtension[i][j] = 175;
                } else if (matrizOriginal[i][j] >= 200 && matrizOriginal[i][j] < 225) {
                    matrizExtension[i][j] = 200;
                } else if (matrizOriginal[i][j] >= 225 && matrizOriginal[i][j] <= 250) {
                    matrizExtension[i][j] = 225;
                }
            }
        }
        return matrizExtension;
    }

}
