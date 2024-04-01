import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

/**
 * Clase Juego, hereda de la clase Tablero4Rayas
 * @author Hugo Sastre Cuesta
 * @version 1.0
 * */
public abstract class Juego extends Tablero4Rayas{
     
    /**
     * definicoon de la funcion VerSiFin
     * */
    public abstract boolean VerSiFin()throws IOException;
    
    /**
     * definicion de la funcion jugar
    * */
    public abstract void jugar()throws IOException;
    
    /**
     * definicion de la funcion jugarHumano
     * */
    public abstract void jugarHumano()throws IOException;
    
    /**
     * definicion de la funcion jugarMaquina
     * */
    public abstract void jugarMaquina()throws IOException;
}


