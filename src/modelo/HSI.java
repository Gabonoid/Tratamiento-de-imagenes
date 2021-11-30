package modelo;

public class HSI {

    public static double[][] Matiz(short[][] red, short[][] green, short[][] blue) {

        double[][] matrizModificada = new double[red.length][red[0].length];

        for (int i = 0; i < red.length; i++) {
            for (int j = 0; j < red[0].length; j++) {

                double numerador = ((red[i][j] - green[i][j]) + (red[i][j] - blue[i][j])) / 2;
                double a = (green[i][j] - blue[i][j]) * (red[i][j] - blue[i][j]);

                double raiz = Math.pow(red[i][j] - green[i][j], 2) + a;
                double denominador = (Math.sqrt(raiz));
                double resultado = (numerador / denominador);
                double a2 = (Math.toDegrees(Math.acos(resultado)));
                double division = 360 / a2;
                matrizModificada[i][j] = (short) (Math.floor(255 / division));

            }
        }

        return matrizModificada;

    }

    public static double[][] Saturacion(short[][] red, short[][] green, short[][] blue) {
        double[][] matrizModificada = new double[red.length][red[0].length];

        for (int i = 0; i < red.length; i++) {
            for (int j = 0; j < red[0].length; j++) {
                double r = red[i][j];
                double g = green[i][j];
                double b = blue[i][j];

                double minimo1 = Math.min(r, g);
                double minimo2 = Math.min(minimo1, b);

                double suma = (r + g + b);
                double division = (minimo2 / suma);
                double multiplicacion = (3 * division);
                double resultado = (1 - multiplicacion);

                matrizModificada[i][j] = (resultado * 255);

            }
        }

        return matrizModificada;
    }

    public static double[][] Intensidad(short[][] red, short[][] green, short[][] blue) {
        double[][] matrizModificada = new double[red.length][red[0].length];
        for (int i = 0; i < matrizModificada.length; i++) {
            for (int j = 0; j < matrizModificada[0].length; j++) {

                matrizModificada[i][j] = (red[i][j] + green[i][j] + blue[i][j]) / 3;

            }

        }
        return matrizModificada;
    }

}
