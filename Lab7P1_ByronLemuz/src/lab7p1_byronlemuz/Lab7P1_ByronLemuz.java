/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_byronlemuz;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author lesly
 */
public class Lab7P1_ByronLemuz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 4) {
            String mensaje = "Seleccione una opción:\n";
            mensaje += "1. PROMEDIOS\n";
            mensaje += "2. DE LANDSCAPE A PORTRAIT\n";
            mensaje += "3. HIGHER-ORDER CONTAINS\n";
            mensaje += "4. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje));
            switch (opcion) {
                case 1:

                    // Pedir dimensiones de la matriz
                    int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas de la matriz:"));
                    int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas de la matriz:"));

                    // Crear matriz y llenar con números aleatorios
                    int[][] matriz = new int[m][n];
                    Random random = new Random();
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            matriz[i][j] = random.nextInt(100);
                        }
                    }

                    // Pedir tipo de promedio a calcular
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de promedio a calcular (1 = por fila, 2 = por columna):"));

                    // Calcular promedios
                    double[] promedios;
                    if (tipo == 1) {
                        promedios = calcularPromedioFila(matriz);
                    } else if (tipo == 2) {
                        promedios = calcularPromedioColumna(matriz);
                    } else {
                        promedios = new double[0];
                        JOptionPane.showMessageDialog(null, "El tipo de promedio ingresado no es válido.");
                    }

                    // Imprimir promedios
                    String promediosStr = imprimirArreglo(promedios);
                    JOptionPane.showMessageDialog(null, "Promedios:\n" + promediosStr);
                    break;
                case 2:
                    int rows = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las filas de la matriz:"));
                    int cols = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las columnas de la matriz:"));
                    int[][] matrix = new int[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            matrix[i][j] = (int) (Math.random() * 10);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "La rotacion de 90 grados a la derecha de:\n\n" + matrixToString(matrix) + "\nes\n\n" + matrixToString(rotarMatriz(matrix)));

                    break;

                case 3:
                    // Pedir al usuario las dimensiones de la matriz
                    int mm = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de filas:"));
                    int nn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columnas:"));

                    // Crear la matriz con números aleatorios del 0 al 9
                    int[][] matrixx = new int[mm][nn];
                    for (int i = 0; i < mm; i++) {
                        for (int j = 0; j < nn; j++) {
                            matrixx[i][j] = (int) (Math.random() * 10);
                        }
                    }

                    // Pedir al usuario los elementos del arreglo
                    int s = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo:"));
                    int[] array = new int[s];
                    for (int i = 0; i < s; i++) {
                        array[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento " + (i + 1) + " del arreglo:"));
                    }

                    // Verificar si el arreglo está contenido en la matriz
                    boolean contains = containsHO(matrixx, array);
                    if (contains) {
                        JOptionPane.showMessageDialog(null, "El arreglo está contenido en la matriz.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El arreglo NO está contenido en la matriz.");
                             }
                        break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion que selecciono nos es valida.");

            
            }
        }
    }
    

    
     public static double[] calcularPromedioFila(int[][] matriz) {
        int m = matriz.length;
        int n = matriz[0].length;
        double[] promedios = new double[m];
        for (int i = 0; i < m; i++) {
            double suma = 0;
            for (int j = 0; j < n; j++) {
                suma += matriz[i][j];
            }
            promedios[i] = suma / n;
        }
        return promedios;
    }

    public static double[] calcularPromedioColumna(int[][] matriz) {
        int m = matriz.length;
        int n = matriz[0].length;
        double[] promedios = new double[n];
        for (int j = 0; j < n; j++) {
            double suma = 0;
            for (int i = 0; i < m; i++) {
                suma += matriz[i][j];
            }
            promedios[j] = suma / m;
        }
        return promedios;
    }

    public static String imprimirArreglo(double[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (double valor : arreglo) {
            sb.append(valor);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean containsHO(int[][] matrix, int[] secuencia) {
        // Recorremos las filas de la matriz
        for (int i = 0; i < matrix.length; i++) {
            // Recorremos las columnas de la matriz hasta S columnas antes del final
            for (int j = 0; j <= matrix[i].length - secuencia.length; j++) {
                boolean found = true;
                // Comparamos los valores de la secuencia con los de la matriz
                for (int k = 0; k < secuencia.length; k++) {
                    if (matrix[i][j + k] != secuencia[k]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String matrizToString(int[][] matriz) {
        String salida = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                salida += matriz[i][j] + " ";
            }
            salida += "\n";
        }
        return salida;
    }

    public static String arrayToString(int[] array) {
        String salida = "";
        for (int i = 0; i < array.length; i++) {
            salida += array[i] + " ";
        }
        return salida;
    }

    public static int[][] rotarMatriz(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotarMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotarMatrix[j][rows - i - 1] = matrix[i][j];
            }
        }
        return rotarMatrix;
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append("[" + matrix[i][j] + "]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
