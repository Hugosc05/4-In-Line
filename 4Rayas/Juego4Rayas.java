import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class Juego4Rayas extends Juego  { 
    Teclado tec = new Teclado();
    private Tablero4Rayas tablero;

    /**
     * Constructor de la clase Juego4Rayas
     * @param tablero
     */
    public Juego4Rayas(Tablero4Rayas tablero) {
        super();
        this.tablero = tablero;
        this.t = tablero.getTablero();
    }
    
    /**
     * Contructor por defecto de la clase Juego4Rayas
     * */
    public Juego4Rayas() {
        super();
    }
    
    // Ver si el juego ha acabado bien porque no hay más huecos libres en el tablero o bien porque uno de los dos haya completado un 4 en raya.
    @Override
    public boolean VerSiFin() throws IOException {
    // Verificar empate (tablero lleno)
    boolean empate = true;
    for (int i = 0; i < tablero.getNumFilas(); i++) {
        for (int j = 0; j < tablero.getNumColumnas(); j++) {
            if (!t[i][j].getEstado()) {
                empate = false; // Todavía hay al menos un hueco libre
                break;
            }
        }
        if (!empate) {
            break;
        }
    }
    if (empate) {
        System.out.println("El juego ha terminado en empate.");
        return true;
    }

    // Verificar si hay un "4 en raya" horizontalmente
    for (int i = 0; i < tablero.getNumFilas(); i++) {
        for (int j = 0; j <= tablero.getNumColumnas() - 4; j++) {
            if (t[i][j].getEstado() && 
                t[i][j].getJugador() != 0 &&
                t[i][j].getJugador() == t[i][j+1].getJugador() &&
                t[i][j].getJugador() == t[i][j+2].getJugador() &&
                t[i][j].getJugador() == t[i][j+3].getJugador()) {
                System.out.println("¡Cuatro en raya horizontal en la fila " + i + "!");
                return true;
            }
        }
    }

    // Verificar si hay un "4 en raya" verticalmente
    for (int i = 0; i <= tablero.getNumFilas() - 4; i++) {
        for (int j = 0; j < tablero.getNumColumnas(); j++) {
            if (t[i][j].getEstado() &&
                t[i][j].getJugador() != 0 &&
                t[i][j].getJugador() == t[i+1][j].getJugador() &&
                t[i][j].getJugador() == t[i+2][j].getJugador() &&
                t[i][j].getJugador() == t[i+3][j].getJugador()) {
                System.out.println("¡Cuatro en raya vertical en la columna " + j + "!");
                return true;
            }
        }
    }

    // Verificar si hay un "4 en raya" en diagonales
    for (int i = 0; i <= tablero.getNumFilas() - 4; i++) {
        for (int j = 0; j <= tablero.getNumColumnas() - 4; j++) {
            if (t[i][j].getEstado() &&
                t[i][j].getJugador() != 0 &&
                t[i][j].getJugador() == t[i+1][j+1].getJugador() &&
                t[i][j].getJugador() == t[i+2][j+2].getJugador() &&
                t[i][j].getJugador() == t[i+3][j+3].getJugador()) {
                System.out.println("¡Cuatro en raya diagonal hacia abajo a la derecha!");
                return true;
            }
            if (t[i][j+3].getEstado() &&
                t[i][j+3].getJugador() != 0 &&
                t[i][j+3].getJugador() == t[i+1][j+2].getJugador() &&
                t[i][j+3].getJugador() == t[i+2][j+1].getJugador() &&
                t[i][j+3].getJugador() == t[i+3][j].getJugador()) {
                System.out.println("¡Cuatro en raya diagonal hacia abajo a la izquierda!");
                return true;
            }
        }
    }

    return false; // El juego no ha terminado
}

    
    // Jugar: Bucle que se encarga de pedir movimiento al usuario y al ordenador
    @Override
    public void jugar()throws IOException {
        int jugador = 1;
        while(jugador < 2){
            if(jugador == 1){
                jugarHumano();
            }else{
                jugarMaquina();
            }
            jugador++;
        }
    }
    
    // Pide una columna y recorre esa columna hasta encontrar un hueco libre y colocar su ficha
    @Override
    public void jugarHumano() throws IOException {
        System.out.println("Ingrese el número de columna:");
        int columna = tec.leerEntero();
        while (columna < 0 || columna >= tablero.getNumColumnas()) {
            System.out.println("Columna fuera de rango");
            columna = tec.leerEntero();
            System.out.println("Número de columnas en el tablero: " + tablero.getNumColumnas());
        }
        mover(columna, 1); // 1 para el jugador humano
    }

    // Recorre la columna dada hasta encontrar un hueco libre y colocar la ficha
    public void mover(int columna, int jugador) throws IOException {
    int fila = tablero.getNumFilas() - 1;
    while (fila >= 0 && (t[fila][columna] == null || t[fila][columna].getEstado())) {
        if (t[fila][columna] == null) {
            t[fila][columna] = new CeldaRaya(); // Inicializar la celda si es null
        }
        fila--;
    }
    if (fila >= 0) {
        t[fila][columna].setEstado(true);
        t[fila][columna].setJugador(jugador);
        
        // Verificar si este movimiento crea un 4 en raya
        if (verificarCuatroEnRaya(fila, columna, jugador)) {
            System.out.println("¡Cuatro en raya!");
            // Aquí puedes agregar cualquier otra acción que desees al detectar un 4 en raya
        }
    }
}

//Verifica un posible 4 en raya en la celda dada
    private boolean verificarCuatroEnRaya(int fila, int columna, int jugador) {
    // Verificar horizontalmente
    int count = 0;
    for (int j = 0; j < tablero.getNumColumnas(); j++) {
        if (t[fila][j] != null && t[fila][j].getEstado() && t[fila][j].getJugador() == jugador) {
            count++;
            if (count >= 4) {
                return true;
            }
        } else {
            count = 0;
        }
    }

    // Verificar verticalmente
    count = 0;
    for (int i = 0; i < tablero.getNumFilas(); i++) {
        if (t[i][columna] != null && t[i][columna].getEstado() && t[i][columna].getJugador() == jugador) {
            count++;
            if (count >= 4) {
                return true;
            }
        } else {
            count = 0;
        }
    }
    return false;
}
    // Aleatoriamente coloca una ficha en una columna libre usando la función mover
    @Override
    public void jugarMaquina() throws IOException {
        Random rnd = new Random();
        int columna = rnd.nextInt(tablero.getNumColumnas());
        mover(columna, 2); // 2 para la máquina
}
}