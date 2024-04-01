import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Tablero4Rayas extends Tablero {
 
    /**
     * Constructor por defecto de la clase Tablero4Rayas
     */
    public Tablero4Rayas() {
        super();
    }

    /**
     * Constructor parametrizado de la clase Tablero4Rayas
     * @param numFilas Numero de filas del tablero
     * @param numColumnas Numero de columnas del tablero
     * */
    public Tablero4Rayas(int numFilas, int numColumnas){
        super(numFilas, numColumnas);
        t = new CeldaRaya[numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                t[i][j] = new CeldaRaya(); // Inicializar cada celda
            }
        }
    }
    
    /**
     * Getter de la clase Tablero4Rayas
     * @return Numero de columnas
     * */

    public int getNumColumnas() {
        return numColumnas;
    }

    /**
     * Getter de la clase Tablero4Rayas
     * @return Numero de filas
     * */
    public int getNumFilas() {
        return numFilas;
    }

    /**
     * Getter de la clase Tablero4Rayas
     * @return Tablero
     * */
    public CeldaRaya[][] getTablero() {
        return t;
    }
    /**
     * Inicializar el tablero con las celdas
     */
    @Override
    public void inicializar() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                this.t[i][j] = new CeldaRaya(i, j);
            }
        }
    }
    /**
     * Reparte 3 movimientos a cada jugador aleatorios al comienzo de la partida metiendo la columna y viendo si hay hueco por
     */
    @Override
    public void repartir() {
        int movimientosPorJugador = 3; // Número de movimientos a repartir por jugador
        
        for (int jugador = 1; jugador <= 2; jugador++) {
            for (int movimiento = 0; movimiento < movimientosPorJugador; movimiento++) {
                int columna;
                int fila;
                do {
                    columna = (int) (Math.random() * numColumnas);
                    fila = encontrarFilaDisponible(columna);
                } while (fila == -1); // Si no hay filas disponibles en esa columna, repite la selección de columna
    
                this.t[fila][columna].setEstado(true);
                this.t[fila][columna].setJugador(jugador);
            }
        }
    }
    
    /**
     * En funcion de una columna dada encuentra si alguna fila esta libre
     * @param columna
     * @return
     */
    
    private int encontrarFilaDisponible(int columna) {
        for (int fila = numFilas - 1; fila >= 0; fila--) {
            if (!this.t[fila][columna].getEstado()) {
                return fila;
            }
        }
        return -1; // Si no hay filas disponibles en la columna dada
    }
    
    /**
     * Dibuja el tablero en pantalla
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * */
     @Override
    public void dibujarTablero(int filas, int columnas) {
    for (int i = 0; i < filas; i++) {
        // Dibujar las celdas y los jugadores
        for (int j = 0; j < columnas; j++) {
            if (t[i][j].getEstado()) {
                if (t[i][j].getJugador() == 1) {
                    System.out.print("| X "); // Jugador humano
                } else if (t[i][j].getJugador() == 2) {
                    System.out.print("| O "); // Jugador máquina
                } else {
                    System.out.print("|   "); // Celda vacía
                }
            } else {
                System.out.print("|   "); // Celda vacía
            }
        }
        System.out.println("|");
        
        // Dibujar las divisiones entre filas
        for (int j = 0; j < columnas; j++) {
            System.out.print("|---");
        }
        System.out.println("|");
    }
}

}
