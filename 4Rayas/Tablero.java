
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

/**Clase Tablero, clase abstracta que contiene los tableros de juego
 * @author Hugo Sastre Cuesta
 * @version 1.0
 * */
public abstract class Tablero {

    protected  int numFilas;
    protected  int numColumnas;
    protected  CeldaRaya[][] t;

    /**
     * Constructor por defecto de la clase Tablero
     * */
    public Tablero(){
        this.numFilas = 0;
        this.numColumnas = 0;
        this.t = new CeldaRaya[0][0];
    }

    /**
     * Constructor parametrizado de la clase Tablero
     * @param numFilas Numero de filas del tablero
     * @param numColumnas Numero de columnas del tablero
     * */
    public Tablero(int numFilas, int numColumnas){
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.t = new CeldaRaya[numFilas][numColumnas];
    }
    
    /**
     * Setter de la clase Tablero
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @param estado estdo de la celda
     * */
    public void setEstado(int fila, int columna, boolean estado){
        this.t[fila][columna] = new CeldaRaya(fila, columna, estado);
    }

    /**
     * Getter de la clase Tablero
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @return
     * */
    public boolean getEstado(int fila, int columna){
        return this.t[fila][columna].getEstado();
    }

    /**
     * Getter de la clase Tablero
     * @param fila Fila de la celda
     * @param columna Columna de la celda
     * @return
     * */
    public Celda getCelda(int fila, int columna){
        return this.t[fila][columna];
    }
    
    /**
     * inicializar el tablero con celdas vacias
     * */
    public abstract void inicializar();

    /**
     * Empieza dando 3 movimientos aleatorios a cada jugador
    */ 
    public abstract void repartir();

    /**
     * Dibuja el tablero
     * @param filas Numero de filas del tablero
     * @param columnas Numero de columnas del tablero
     * */
    public abstract void dibujarTablero(int filas, int columnas); 
    
}

