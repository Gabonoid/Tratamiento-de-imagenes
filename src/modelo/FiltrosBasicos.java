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
        short[][] matrizInterpolacion = new short[2 * matrizOriginal.length][2 * matrizOriginal[0].length];
        for (int i = 0, k = 0; i < matrizInterpolacion.length; i += 2, k++) {
            for (int j = 0, l = 0; j < matrizInterpolacion[0].length; j += 2, l++) {
                matrizInterpolacion[i][j] = matrizOriginal[k][l];
                matrizInterpolacion[i + 1][j] = matrizOriginal[k][l];
                matrizInterpolacion[i][j + 1] = matrizOriginal[k][l];
                matrizInterpolacion[i + 1][j + 1] = matrizOriginal[k][l];
            }
        }
        return matrizInterpolacion;
    }
}
