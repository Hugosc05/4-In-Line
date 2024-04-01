import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

/**Clase Celda, clase abstracta que contiene las celdas dtel tablero de juego
 * @author Hugo Sastre Cuesta
 * @version 1.0
  */

public abstract class Celda {
    protected int fila;
    protected int columna;
    protected boolean estado;                     // EN true es = 1 que significa celda ocupada, y en false es = 0 que significa celda vacia

    /**
     * Constructor parametrizado de la clase Celda
     * @param f Fila de la celda
     * @param c Columna de la celda
     */
    public Celda(int f, int c) {
        this.fila = f;
        this.columna = c;
        this.estado = false;
    }
    /**
     * Constructor por defecto de la clase Celda
     */
    public Celda(){
        this.fila = 0;
        this.columna = 0;
        this.estado = false;
    }

    /**
     * Constructor parametrizado de la clase Celda
     * @param f Fila de la celda
     * @param c Columna de la celda
     * @param est Estado de la celda
     * */
    public Celda(int f, int c, boolean est){
        this.fila = f;
        this.columna = c;
        this.estado = est;
    }

    /**
     * Getter de la clase Celda, fila
     * @return
     */
    public int getFila() {
        return fila;
    }

    /**
     * Setter de la clase Celda, fila
     * @param f
     * */
    public void setFila(int f) {
        this.fila = f;
    }
    
    /**
     * Getter de la clase Celda, columna
     * @return
     * */
    public int getColumna() {
        return columna;
    }

    /**
     * Setter de la clase Celda, columna
     * @param c
     * */
    public void setColumna(int c){
        this.columna = c;
    }

    /**
     * Setter de la clase Celda, estado
     * @param est
     * */
    public void setEstado(boolean est){
        this.estado = est;
    }

    /**
     * Getter de la clase Celda, estado
     * @return
     * */
    public boolean getEstado(){
        return estado;
    }

    /**
     * Funcion toString de la clase Celda
     * @return
     * */
    public String toString(){
        return "Fila: " + fila + " Columna: " + columna + " Estado: " + estado;
    }
    
    /**
     * Funcion equals de la clase Celda
     * @param obj
     * @return
     * */
   @Override
    public boolean equals(Object obj) {
    // Comprobando si obj es nulo o no es una instancia de CeldaRaya
        if (obj == null || !(obj instanceof Celda)) {
            return false;
        }
    
    // Haciendo casting de obj a CeldaRaya
        Celda other = (Celda) obj;
    
    // Comparando fila y columna
        return this.fila == other.fila && this.columna == other.columna;
}
}
