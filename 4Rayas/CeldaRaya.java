import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

/**
 * Clase CeldaRaya, hereda de la clase celda
 * @author Hugo Sastre Cuesta
 * @version 1.0
 */
public class CeldaRaya extends Celda {
    int Jugador;

    /**
     * Constructor por defecto de la clase CeldaRaya
     * */
    public CeldaRaya(){
        super();
        Jugador = 1;
    }

    /**
     * Constructor parametrizado de la clase CeldaRaya
     * @param f Fila de la celda
     * @param c Columna de la celda
     * @param est Estado de la celda
     * */
    public CeldaRaya(int f, int c, boolean est){
        super(f, c, est);
        Jugador = 1;
    }
    
    /**
     * Constructor parametrizado de la clase CeldaRaya
     * @param f Fila de la celda
     * @param c Columna de la celda
     * */
    public CeldaRaya(int f, int c){
        super(f, c);
        Jugador = 1;
    }

    /**
     * Setter de la clase CeldaRaya, jugador
     * @param j Jugador de la celda
     * */
    public void setJugador(int j){
        this.Jugador = j;
    }

    /**
     * Getter de la clase CeldaRaya, color
     * @return
     */
    public int getJugador(){
        return Jugador;
    }

    /**
     * Funcion toString de la clase CeldaRaya
     * @return
     * */
    public String toString(){
        String temp;
        temp = "CeldaRaya[Fila:"+fila+" Columna:"+columna+" Jugador:"+Jugador+"]";
        return temp;
    }

    /**
     * Funcion equals de la clase CeldaRaya
     * @param obj
     * @return
     * */
     @Override
    public boolean equals(Object obj){
        CeldaRaya other = (CeldaRaya) obj;
        return this.fila == other.fila && this.columna == other.columna && this.Jugador == other.Jugador;
    }
}
