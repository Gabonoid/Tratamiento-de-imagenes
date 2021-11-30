package modelo;

/**
 *
 * @author Gabriel
 */
public class Convolucion {

    public static short[][] convolucion(short[][] matrizOriginal, short mascara[][]) {

        short[][] matrizNueva = new short[matrizOriginal.length][matrizOriginal[0].length];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                double primer = Math.abs((matrizOriginal[x - 1][y - 1] * mascara[0][0]) + (matrizOriginal[x][y - 1] * mascara[1][0]) + (matrizOriginal[x + 1][y - 1] * mascara[2][0])
                        + (matrizOriginal[x - 1][y] * mascara[0][1]) + (matrizOriginal[x][y] * mascara[1][1]) + (matrizOriginal[x + 1][y] * mascara[2][1])
                        + (matrizOriginal[x - 1][y + 1] * mascara[0][2]) + (matrizOriginal[x][y + 1] * mascara[1][2]) + (matrizOriginal[x + 1][y + 1] * mascara[2][2]));

                matrizNueva[x][y] = (short) primer;
            }
        }
        return matrizNueva;
    }

}
