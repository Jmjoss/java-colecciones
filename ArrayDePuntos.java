
/**
 * Clase ArrayDePuntos, ejecutable que crea un array de tipo Puntos.
 * 
 * @author jose candia
 * @version 
 */

import java.util.*;

public class ArrayDePuntos
{
   public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); 
        Punto[] puntos = new Punto[6];
        double x;
        double y;
        
        for(int i = 0; i < puntos.length; i++) {
            System.out.println("Ingrese datos punto : "+ (i+1));
            System.out.println("Ingrese x :");
            x = teclado.nextDouble();
            teclado.nextLine();
            System.out.println("Ingrese y :");
            y = teclado.nextDouble();
            teclado.nextLine(); 
            puntos[i] = new Punto(x, y);
        }
        
        for(int i = 0; i < puntos.length; i++) {
            puntos[i].mostrar();
        }
        
        for(int i = 0; i < puntos.length; i++) {
              if(i == 5) {
                    break;
                }else {
                    System.out.println("Distancia del punto:" + (i+1) + " al punto "+ (i+2) + ": " + puntos[i].distanciaA(puntos[i+1]));
                    System.out.println("\n");
                }
        }
    }
}
