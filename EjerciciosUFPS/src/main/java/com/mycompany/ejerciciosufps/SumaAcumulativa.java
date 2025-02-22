
package com.mycompany.ejerciciosufps;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author Miguel Angel
 */

public class SumaAcumulativa {
    public static void main(String[] args) {
        int[][] instancias = {     
            {1, 2, 3, 4, 5},       // instancia 1
            {10, 20, 30, 40, 50},  // instancai 2
            {5, -2, 7, 0, -3}      // instancia 3
        };

        for (int i = 0; i < instancias.length; i++) {
            System.out.println("\n--- INSTANCIA " + (i + 1) + " ---");

            StopWatch reloj = new StopWatch();

            // Método 1 Ineficiente
            reloj.start();
            int[] resultado1 = sumaAcumulativaIneficiente(instancias[i]);
            reloj.stop();
            System.out.println("Método 1 (Ineficiente) - Tiempo: " + reloj.getTime() + " ms");
            imprimirArreglo(resultado1);

            reloj.reset(); // Reinicia el reloj

            // Método 2 más eficiente
            reloj.start();
            int[] resultado2 = sumaAcumulativaEficiente(instancias[i]);
            reloj.stop();
            System.out.println("Método 2 (Eficiente) - Tiempo: " + reloj.getTime() + " ms");
            imprimirArreglo(resultado2);
        }
    }

    public static int[] sumaAcumulativaIneficiente(int[] arr) {
        int n = arr.length;
        int[] resultado = new int[n];

        for (int i = 0; i < n; i++) {
            int suma = 0;
            for (int j = 0; j <= i; j++) {suma += arr[j];}
            resultado[i] = suma;}
        return resultado;}

    public static int[] sumaAcumulativaEficiente(int[] arr) {
        int n = arr.length;
        int[] resultado = new int[n];

        if (n > 0) {
            resultado[0] = arr[0];
            for (int i = 1; i < n; i++) {
                resultado[i] = resultado[i - 1] + arr[i];}
        }
        return resultado;}

    public static void imprimirArreglo(int[] arr) {
        System.out.print("[ ");
        for (int num : arr) {System.out.print(num + " ");}
        System.out.println("]");}
}
