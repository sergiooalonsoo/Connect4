package com.aetxabao.connect4;

import static com.aetxabao.connect4.Tablero.*;

/**
 * @author Nombre Apellido
 */
public class Salida {

    private static void limpiaPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }

    public static void pintaInicio() {
        limpiaPantalla();
        System.out.println("###################################");
        System.out.println("#            CONECTA 4            #");
        System.out.println("###################################");
        System.out.println("                                   ");
        System.out.println("F  |   |   |   |   |   |   |   |  F");
        System.out.println("E  |   |   | O |   |   |   |   |  E");
        System.out.println("D  | X | O | X | O | X | O |   |  D");
        System.out.println("C  | X | X | X | O | O | X |   |  C");
        System.out.println("B  | X | O | O | X | X | O |   |  B");
        System.out.println("A  | O | X | X | O | O | O | X |  A");
        System.out.println("   -----------------------------   ");
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |   ");
        System.out.println("                                   ");
        System.out.println("Pulsa ENTER para empezar.");
        System.out.println();
    }

    public static void pinta(char[][] matriz) {
        //TODO: pinta DONE
        limpiaPantalla();//no borrar esta primera línea
        int h = matriz[0].length;
        int w = matriz.length;
        System.out.println("###################################");
        System.out.println("#            CONECTA 4            #");
        System.out.println("###################################");
        System.out.println("                                   ");
        char[] letras = {'A','B','C','D','E','F'};

        for (int i = h - 1; i >= 0; i--) {
            System.out.printf("%c %2s", letras[i], "|");
            for (int j = 0; j < w; j++) {
                if (j == 0) {
                    System.out.print(" ");
                }
                System.out.print(matriz[j][i] + " ");
                System.out.print("| ");
            }
            System.out.printf(" %s\n", letras[i]);
        }
        System.out.println("   -----------------------------   ");
        System.out.println("   | 1 | 2 | 3 | 4 | 5 | 6 | 7 |   ");
        System.out.println("                                   ");
    }

    public static void pintaGana(char[][] m, char jugador) {
        pinta(m);
        System.out.printf("Enhorabuena, ha ganado '%c'. FIN.\n", jugador);
    }

    public static void pintaEmpate(char[][] m) {
        pinta(m);
        System.out.println("Empate. No hay ganador. FIN.");
    }

    public static void main(String[] args) {
        char[][] m0 = {
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' '}
        };
        pinta(m0);
        char[][] m1 = {
                {X, O, X, O, L, L},
                {X, O, L, L, L, L},
                {X, O, X, O, O, X},
                {O, X, O, O, X, X},
                {O, X, X, O, L, L},
                {O, O, L, L, L, L},
                {X, X, O, L, L, L}
        };
        pinta(m1);
    }

}
