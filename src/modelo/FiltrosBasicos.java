package modelo;

public class FiltrosBasicos {

    static public short[][] girarNoventa(short[][] matrizOriginal) {
        short[][] matrizModificada = new short[matrizOriginal[0].length][matrizOriginal.length];
        short columna = (short) (matrizOriginal.length - 1);
        for (short i = 0; i < matrizOriginal.length; i++, columna--) {
            for (short j = 0; j < matrizOriginal[0].length; j++) {
                matrizModificada[j][columna] = matrizOriginal[i][j];
            }
        }

        return matrizModificada;
    }

    static public short[][] girarCientoOchenta(short[][] matrizOriginal) {
        short[][] matrizModificada = new short[matrizOriginal[0].length][matrizOriginal.length];

        short columna = (short) (matrizOriginal.length - 1);
        for (short i = 0; i < matrizOriginal.length; i++, columna--) {
            for (short j = 0; j < matrizOriginal[0].length; j++) {
                matrizModificada[j][columna] = matrizOriginal[i][j];
            }
        }

        return girarNoventa(matrizModificada);
    }

    static public short[][] girarDoscientosSetenta(short[][] matrizOriginal) {
        short[][] matrizModificada = new short[matrizOriginal[0].length][matrizOriginal.length];

        short columna = (short) (matrizOriginal.length - 1);
        for (short i = 0; i < matrizOriginal.length; i++, columna--) {
            for (short j = 0; j < matrizOriginal[0].length; j++) {
                matrizModificada[j][columna] = matrizOriginal[i][j];
            }
        }

        return girarCientoOchenta(matrizModificada);
    }
    
    static public short[][] interpolacion(short[][] matrizOriginal) {
        int alto = 2 * matrizOriginal.length;
        int ancho = 2 * matrizOriginal[0].length;
        short [][] matrizZoom = new short [alto][ancho];
        for (int i = 0, k = 0; i < matrizZoom.length; i += 2, k++) {
            for (int j = 0, l = 0; j < matrizZoom[0].length; j+=2, l++) {
                matrizZoom[i][j] = matrizOriginal[k][l];
                matrizZoom[i+1][j] = matrizOriginal[k][l];
                matrizZoom[i][j+1] = matrizOriginal[k][l];
                matrizZoom[i+1][j+1] = matrizOriginal[k][l];   
            }   
        }
        return matrizZoom;
    }
}
