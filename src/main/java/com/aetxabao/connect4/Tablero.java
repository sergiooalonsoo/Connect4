package com.aetxabao.connect4;

import java.util.Random;

/**
 * @author Nombre Apellido
 */
public class Tablero {

    public final static char O = 'O';
    public final static char X = 'X';
    public final static char L = ' ';
    private final static int W = 7;
    private final static int H = 6;
    private int contador;
    private char turno;
    private final int ancho;
    private final int alto;
    private final char[][] m;

    public Tablero() {
        contador = 0;
        turno = O;
        ancho = W;
        alto = H;
        m = new char[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                m[i][j] = L;
            }
        }
    }

    public Tablero(char[][] m) {
        //TODO: Tablero(m) DONE
        ancho = W;
        alto = H;
        this.m = m;
        int cntX = 0;
        int cntO = 0;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if (m[i][j] == O) {
                    cntO++;
                } else if (m[i][j] == X) {
                    cntX++;
                }
            }
        }
        contador = cntO + cntX;

        if (cntO > cntX) {
            turno = X;
        } else if (cntX > cntO) {
            turno = O;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getContador() {
        return contador;
    }

    public char[][] getMatriz(){
        return m;
    }

    public char getTurno() {
        return turno;
    }

    public void iniciaTurno() {
        //TODO: iniciaTurno DONE
        Random rnd = new Random();
        boolean aleatorio = rnd.nextBoolean();
        if (aleatorio) {
            turno = X;
        } else {
            turno = O;
        }
    }

    public void cambiaTurno() {
        //TODO: cambiaTurno DONE
        if (turno == X) {
            turno = O;
        } else {
            turno = X;
        }
    }

    public boolean estaColumnaLibre(int columna) {
        //TODO: estaColumnaLibre DONE
        if (columna < 0 || columna > getAncho() - 1) {
            return false;
        }

        for (int i = 0; i < getAncho(); i++) {
            if (i == columna) {
                for (int j = 0; j < getAlto(); j++) {
                   if (m[i][j] == L) {
                       return true;
                   }
                }
            }
        }
        return false;
    }

    public void inserta(char ficha, int columna) {
        //TODO: insertar DONE
        if (estaColumnaLibre(columna)) {
            for (int i = getAlto(); i >= 0; i--) {
                if (i == columna) {
                    for (int j = 0; j < getAlto(); j++) {
                        if (m[i][j] == L) {
                            m[i][j] = ficha;
                            contador++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean estaLleno() {
        //TODO: estaLleno DONE
        return contador == alto*ancho;
    }

    public boolean gana(char jugador) {
        boolean b;
        b = ganaHorizontal(jugador);
        b = b || ganaVertical(jugador);
        b = b || ganaDiagonalArriba(jugador);
        b = b || ganaDiagonalAbajo(jugador);
        return b;
    }

    private boolean ganaHorizontal(char jugador) {
        //TODO: ganaHorizontal DONE
        boolean b = false;
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAlto(); j++) {
                if (hay4Horizontales(i, j, jugador)) {
                    b = true;
                }
            }
        }
        return b;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
        //TODO: hay4Horizontales DONE
        if (columna + 3 >= getAncho()) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (m[columna + i][fila] != jugador) {
                return false;
            }
        }

        return true;
    }

    private boolean ganaVertical(char jugador) {
        //TODO: ganaVertical DONE
        boolean b = false;
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAlto(); j++) {
                if (hay4Verticales(i, j, jugador)) {
                    b = true;
                }
            }
        }
        return b;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        //TODO: hay4Verticales DONE
        if (fila + 3 >= getAlto()) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (m[columna][fila + i] != jugador) {
                return false;
            }
        }

        return true;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        //TODO: ganaDiagonalArriba DONE
        boolean b = false;
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAlto(); j++) {
                if (hay4DiagonalesArriba(i, j, jugador)) {
                    b = true;
                }
            }
        }
        return b;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesArriba DONE
        if (columna + 3 >= getAncho() || fila + 3 >= getAlto()) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (m[columna + i][fila + i] != jugador) {
                return false;
            }
        }

        return true;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        //TODO: ganaDiagonalAbajo DONE
        boolean b = false;
        for (int i = 0; i < getAncho(); i++) {
            for (int j = 0; j < getAlto(); j++) {
                if (hay4DiagonalesAbajo(i, j, jugador)) {
                    b = true;
                }
            }
        }
        return b;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesAbajo DONE
        if (columna - 3 < 0 || fila + 3 >= getAlto()) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (m[columna - i][fila + i] != jugador) {
                return false;
            }
        }

        return true;
    }

    public boolean estaFinalizado() {
        //TODO: finalizado DONE
        return gana(O) || gana(X) || estaLleno();
    }

}
