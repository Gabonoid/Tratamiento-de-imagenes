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
}
