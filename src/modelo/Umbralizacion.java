package modelo;

public class Umbralizacion {

    public static short[][] inverso(short[][] matrizOriginal) {
        short[][] matrizInverso  = new short [matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                matrizInverso[i][j] = (short) (255 - matrizOriginal[i][j]);   
            }
        }
        return matrizInverso;
    }

    public static short[][] umbral(short[][] matrizOriginal, short u) {
        short[][] matrizUmbral  = new short [matrizOriginal.length][matrizOriginal[0].length];
        u = 253;
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[0].length; j++) {
                if (matrizOriginal[i][j] <= u){
                    matrizUmbral[i][j] = 0;
                } else {
                    matrizUmbral[i][j] = 255;
                }
            }
        }
        return matrizUmbral;
    }

}
