
/**
 * Clase Main del juego 4 en raya.
 * 
 * @author Hugo Sastre Cuesta 
 * @version 1.0
 */
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

    public class Main {
    public static void main(String[] args) throws IOException {
        Teclado t = new Teclado();

        // Solicitar al usuario el número de filas y columnas del tablero
        System.out.println("Ingrese el número de filas del tablero:");
        int filas = t.leerEntero();
        System.out.println("Ingrese el número de columnas del tablero:");
        int columnas = t.leerEntero();

        // Crear el tablero
        Tablero4Rayas tablero = new Tablero4Rayas(filas, columnas);

        // Inicializar el tablero y repartir las fichas
        tablero.inicializar();
        tablero.repartir();

        // Dibujar el tablero inicial
        System.out.println("Tablero inicial:");
        tablero.dibujarTablero(filas, columnas);
        System.out.println("---------------------"); // Línea horizontal de separación

        Juego4Rayas jug = new Juego4Rayas(tablero);
        
        // Comenzar el juego
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            // Turno del jugador humano
            System.out.println("---------------------"); // Línea horizontal de separación
            System.out.println("Turno del jugador humano (X):");
            
            jug.jugarHumano();
            tablero.dibujarTablero(filas, columnas);
            juegoTerminado = jug.VerSiFin();

            if (!juegoTerminado) {
                // Turno de la máquina
                System.out.println("---------------------"); // Línea horizontal de separación
                System.out.println("Turno de la máquina (O):");
                jug.jugarMaquina();
                tablero.dibujarTablero(filas, columnas);
                juegoTerminado = jug.VerSiFin();
            }
        }
    }
}
