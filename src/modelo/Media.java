package modelo;

import java.util.Arrays;

public class Media {

    public static short[][] mediaAritmetica(short[][] matrizOriginal) {

        short[][] matrizMediaAritmetica = new short[matrizOriginal.length][matrizOriginal[0].length];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                double matrizNueva = (matrizOriginal[x - 1][y - 1] + matrizOriginal[x][y - 1] + matrizOriginal[x + 1][y - 1]
                        + matrizOriginal[x - 1][y] + matrizOriginal[x + 1][y]
                        + matrizOriginal[x - 1][y + 1] + matrizOriginal[x][y + 1] + matrizOriginal[x + 1][y + 1]);

                double suma = (matrizNueva / 8);

                matrizMediaAritmetica[x][y] = (short) suma;

            }

        }

        return matrizMediaAritmetica;

    }

    public static short[][] mediaGeometrica(short[][] matrizOriginal) {

        short[][] matrizGeometrica = new short[matrizOriginal.length][matrizOriginal.length];

        for (int x = 1; x < matrizGeometrica.length - 1; x++) {
            for (int y = 1; y < matrizGeometrica[0].length - 1; y++) {

                double producto1 = (matrizOriginal[x - 1][y - 1] * matrizOriginal[x][y - 1] * matrizOriginal[x + 1][y - 1] * matrizOriginal[x - 1][y]);
                double producto2 = (matrizOriginal[x + 1][y] * matrizOriginal[x - 1][y + 1] * matrizOriginal[x][y + 1] * matrizOriginal[x + 1][y + 1]);
                double producto3 = producto1 * producto2;

                matrizGeometrica[x][y] = (short) Math.pow(producto3, 0.125);

            }

        }
        return matrizGeometrica;
    }

    public static short[][] mediaContraArmonica(short[][] matrizOriginal, double Q) {
        short[][] matrizContraArmonica = new short[matrizOriginal.length][matrizOriginal[0].length];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {
                double numerador = (Math.pow(matrizOriginal[x - 1][y - 1], Q + 1)
                        + Math.pow(matrizOriginal[x][y - 1], Q + 1)
                        + Math.pow(matrizOriginal[x + 1][y - 1], Q + 1)
                        + Math.pow(matrizOriginal[x - 1][y], Q + 1)
                        + Math.pow(matrizOriginal[x + 1][y], Q + 1)
                        + Math.pow(matrizOriginal[x - 1][y + 1], Q + 1)
                        + Math.pow(matrizOriginal[x][y + 1], Q + 1)
                        + Math.pow(matrizOriginal[x + 1][y + 1], Q + 1));

                double denominador = (Math.pow(matrizOriginal[x - 1][y - 1], Q)
                        + Math.pow(matrizOriginal[x][y - 1], Q)
                        + Math.pow(matrizOriginal[x + 1][y - 1], Q)
                        + Math.pow(matrizOriginal[x - 1][y], Q)
                        + Math.pow(matrizOriginal[x + 1][y], Q)
                        + Math.pow(matrizOriginal[x - 1][y + 1], Q)
                        + Math.pow(matrizOriginal[x][y + 1], Q)
                        + Math.pow(matrizOriginal[x + 1][y + 1], Q));
                
                double division = numerador / denominador;

                matrizContraArmonica[x][y] = (short) division;
            }
        }
        return matrizContraArmonica;
    }

    public static short[][] EstadisticoMediana(short[][] matrizOriginal) {

        short mediana;
        short[][] matrizEstadisticoMediana = new short[matrizOriginal.length][matrizOriginal[0].length];
        short[] medianas = new short[9];

        //Creado del arreglo
        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                medianas[0] = matrizOriginal[x - 1][y - 1];
                medianas[1] = matrizOriginal[x][y];
                medianas[2] = matrizOriginal[x + 1][y - 1];
                medianas[3] = matrizOriginal[x - 1][y];
                medianas[4] = matrizOriginal[x][y];
                medianas[5] = matrizOriginal[x + 1][y];
                medianas[6] = matrizOriginal[x - 1][y + 1];
                medianas[7] = matrizOriginal[x][y + 1];
                medianas[8] = matrizOriginal[x + 1][y + 1];

                Arrays.sort(medianas);

                if (medianas.length % 2 == 0) {
                    int suma = medianas[medianas.length / 2] + medianas[medianas.length / 2 - 1];
                    mediana = (short) (suma / 2);
                } else {
                    mediana = medianas[medianas.length / 2];
                }
                matrizEstadisticoMediana[x][y] = (short) mediana;
            }
        }
        return matrizEstadisticoMediana;
    }

    public static short[][] EstadisticoMaximo(short[][] matrizOriginal) {
        short[][] matrizMaximo = new short[matrizOriginal.length][matrizOriginal[0].length];
        double[] arregloMaximo = new double[8];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                arregloMaximo[0] = matrizOriginal[x - 1][y - 1];
                arregloMaximo[1] = matrizOriginal[x][y - 1];
                arregloMaximo[2] = matrizOriginal[x + 1][y - 1];
                arregloMaximo[3] = matrizOriginal[x - 1][y];

                arregloMaximo[4] = matrizOriginal[x + 1][y];
                arregloMaximo[5] = matrizOriginal[x - 1][y + 1];
                arregloMaximo[6] = matrizOriginal[x][y + 1];
                arregloMaximo[7] = matrizOriginal[x + 1][y + 1];

                Arrays.sort(arregloMaximo);

                matrizMaximo[x][y] = (short) arregloMaximo[7];
            }
        }
        return matrizMaximo;
    }

    public static short[][] EstadisticoMinimo(short[][] matrizOriginal) {
        short[][] matrizMinimo = new short[matrizOriginal.length][matrizOriginal[0].length];
        short[] arregloMinimo = new short[8];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                arregloMinimo[0] = matrizOriginal[x - 1][y - 1];
                arregloMinimo[1] = matrizOriginal[x][y - 1];
                arregloMinimo[2] = matrizOriginal[x + 1][y - 1];
                arregloMinimo[3] = matrizOriginal[x - 1][y];

                arregloMinimo[4] = matrizOriginal[x + 1][y];
                arregloMinimo[5] = matrizOriginal[x - 1][y + 1];
                arregloMinimo[6] = matrizOriginal[x][y + 1];
                arregloMinimo[7] = matrizOriginal[x + 1][y + 1];

                Arrays.sort(arregloMinimo);

                matrizMinimo[x][y] = arregloMinimo[7];
            }
        }
        return matrizMinimo;
    }

    public static short[][] EstadisticoPuntoAPunto(short[][] matrizOriginal) {

        short[][] matrizPuntoAPunto = new short[matrizOriginal.length][matrizOriginal[0].length];
        short[] arregloPuntoaPunto = new short[8];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                arregloPuntoaPunto[0] = matrizOriginal[x - 1][y - 1];
                arregloPuntoaPunto[1] = matrizOriginal[x][y - 1];
                arregloPuntoaPunto[2] = matrizOriginal[x + 1][y - 1];
                arregloPuntoaPunto[3] = matrizOriginal[x - 1][y];

                arregloPuntoaPunto[4] = matrizOriginal[x + 1][y];
                arregloPuntoaPunto[5] = matrizOriginal[x - 1][y + 1];
                arregloPuntoaPunto[6] = matrizOriginal[x][y + 1];
                arregloPuntoaPunto[7] = matrizOriginal[x + 1][y + 1];

                Arrays.sort(arregloPuntoaPunto);

                int sumatoria = ((arregloPuntoaPunto[0] + arregloPuntoaPunto[7]) / 2);
                matrizPuntoAPunto[x][y] = (short) sumatoria;
            }
        }
        return matrizPuntoAPunto;
    }

    public static short[][] MediaSeccion(short[][] matrizOriginal, int a) {

        short[][] matrizMediaSeccion = new short[matrizOriginal.length][matrizOriginal[0].length];
        short[] arregloMediaSeccion = new short[9];

        for (int x = 1; x < matrizOriginal.length - 1; x++) {
            for (int y = 1; y < matrizOriginal[0].length - 1; y++) {

                arregloMediaSeccion[0] = matrizOriginal[x - 1][y - 1];
                arregloMediaSeccion[1] = matrizOriginal[x][y - 1];
                arregloMediaSeccion[2] = matrizOriginal[x + 1][y - 1];
                arregloMediaSeccion[3] = matrizOriginal[x - 1][y];
                arregloMediaSeccion[4] = matrizOriginal[x][y];
                arregloMediaSeccion[5] = matrizOriginal[x + 1][y];
                arregloMediaSeccion[6] = matrizOriginal[x - 1][y + 1];
                arregloMediaSeccion[7] = matrizOriginal[x][y + 1];
                arregloMediaSeccion[8] = matrizOriginal[x + 1][y + 1];

                Arrays.sort(arregloMediaSeccion);

                if (a == 2 || a == 4 || a == 6) {
                    switch (a) {

                        case 2:

                            arregloMediaSeccion[1] = matrizOriginal[x][y - 1];
                            arregloMediaSeccion[2] = matrizOriginal[x + 1][y - 1];
                            arregloMediaSeccion[3] = matrizOriginal[x - 1][y];
                            arregloMediaSeccion[4] = matrizOriginal[x][y];
                            arregloMediaSeccion[5] = matrizOriginal[x + 1][y];
                            arregloMediaSeccion[6] = matrizOriginal[x - 1][y + 1];
                            arregloMediaSeccion[7] = matrizOriginal[x][y + 1];

                            double suma = arregloMediaSeccion[1] + arregloMediaSeccion[2] + arregloMediaSeccion[3] + 
                                    arregloMediaSeccion[4] + arregloMediaSeccion[5] + arregloMediaSeccion[6] + arregloMediaSeccion[7];

                            double resultado = (suma / 7);

                            matrizMediaSeccion[x][y] = (short) resultado;

                            break;

                        case 4:

                            arregloMediaSeccion[2] = matrizOriginal[x + 1][y - 1];
                            arregloMediaSeccion[3] = matrizOriginal[x - 1][y];
                            arregloMediaSeccion[4] = matrizOriginal[x][y];
                            arregloMediaSeccion[5] = matrizOriginal[x + 1][y];
                            arregloMediaSeccion[6] = matrizOriginal[x - 1][y + 1];

                            double suma2 = arregloMediaSeccion[2] + arregloMediaSeccion[3] + arregloMediaSeccion[4] + 
                                    arregloMediaSeccion[5] + arregloMediaSeccion[6];

                            double resultado2 = (suma2 / 5);

                            matrizMediaSeccion[x][y] = (short) resultado2;

                            break;

                        case 6:

                            arregloMediaSeccion[3] = matrizOriginal[x - 1][y];
                            arregloMediaSeccion[4] = matrizOriginal[x][y];
                            arregloMediaSeccion[5] = matrizOriginal[x + 1][y];

                            double suma3 = arregloMediaSeccion[3] + arregloMediaSeccion[4] + arregloMediaSeccion[5];

                            double resultado3 = (suma3 / 3);

                            matrizMediaSeccion[x][y] = (short) resultado3;

                            break;
                    }
                }
            }
        }

        return matrizMediaSeccion;
    }

}
