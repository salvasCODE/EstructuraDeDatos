//Método para buscar un punto de silla en una matriz.
class PuntoDeSilla {
    public int[] encontrarPuntoDeSilla(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        
        // Recorrer cada fila de la matriz
        for (int i = 0; i < filas; i++) {
            int valorMinimoFila = Integer.MAX_VALUE;
            int columnaMinimoFila = -1;
            
            // Encontrar el valor mínimo de la fila y su columna correspondiente
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] < valorMinimoFila) {
                    valorMinimoFila = matriz[i][j];
                    columnaMinimoFila = j;
                }
            }
            
            boolean esPuntoDeSilla = true;
            
            // Verificar si el valor mínimo de la fila es el máximo en su columna
            for (int k = 0; k < filas; k++) {
                if (matriz[k][columnaMinimoFila] > valorMinimoFila) {
                    esPuntoDeSilla = false;
                    break;
                }
            }
            
            // Si se encontró un punto de silla, retornar su posición.
            if (esPuntoDeSilla) {
                return new int[]{i, columnaMinimoFila};
            }
        }
        
        // Si no se encontró un punto de silla, retornar null.
        return null;
    }
}

public class App {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        PuntoDeSilla buscarPuntoDeSilla = new PuntoDeSilla();
        
        // Llamar al método encontrarPuntoDeSilla.
        int[] puntoDeSilla = buscarPuntoDeSilla.encontrarPuntoDeSilla(matriz);
        
        // Mostrar el resultado obtenido
        if (puntoDeSilla != null) {
            int fila = puntoDeSilla[0];
            int columna = puntoDeSilla[1];
            int valor = matriz[fila][columna];
            System.out.println("Punto de silla - posición (" + fila + ", " + columna + ")");
            System.out.println("Punto de silla - Valor: " + valor);
        } else {
            System.out.println("No se encontró un punto de silla en la matriz");
        }
    }
}