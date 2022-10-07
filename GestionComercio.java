
/**
 * Clase ejecutable GestionComercio.
 * 
 * @author jose candia
 * @version 
 */

import java.util.*;

public class GestionComercio
{
   public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char sigue = 'S';
        long cuil;
        double sueldo;
        int anioIngreso;
        String nombre;
        String apellido;
        int op = -1;
        HashMap <Long, Empleado> empleados = new HashMap <Long, Empleado>();
        System.out.println("Ingrese el nombre del comercio: ");
        String nombreComercio = teclado.nextLine();
        
        Comercio comercio = new Comercio(nombreComercio, empleados);
        
        while(op != 0) {
            System.out.println("\n");
            System.out.println("Ingrese la operacion que desea realizar: ");
            System.out.println("1.Dar de alta empleado   \n2.Dar baja empleado  \n3.verifcar si es empleado \n4.Sueldo de un empleado \n5.Imprimir nomina \n6.Buscar empleado \n7.Cantidad de empleados \n0.Salir ");
            op = teclado.nextInt();
            teclado.nextLine();
            
            if(op == 1) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese los datos del empleado: ");
                    System.out.println("Ingrese el cuil: ");
                    cuil = teclado.nextLong();
                    teclado.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellido = teclado.nextLine();
                    System.out.println("Ingrese el nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Ingrese el sueldo: ");
                    sueldo = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese el año de ingreso: ");
                    anioIngreso = teclado.nextInt();
                    teclado.nextLine();
                    
                    Empleado empleado = new Empleado(cuil, apellido, nombre, sueldo,anioIngreso);
                    
                    comercio.altaEmpleado(empleado);
                    
                    System.out.println("Desea dar de alta otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 2) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese el cuil de empleado: ");    
                    cuil = teclado.nextLong();
                    
                    if(comercio.esEmpleado(cuil)) {
                        comercio.bajaEmpleado(cuil);
                        System.out.println("Dado de baja");    
                    }else {
                        System.out.println("El empleado de cuil : "+ cuil + " no es empleado");  
                    }
                    
                    System.out.println("Desea dar de baja otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 3) {
                sigue = 'S';
                 while(sigue != 'N') {
                    System.out.println("Ingrese el cuil del empleado: ");    
                    cuil = teclado.nextLong();
                    
                    if(comercio.esEmpleado(cuil)) {
                        System.out.println("Es empleado");
                    }else {
                        System.out.println("No es empleado");
                    }
                    
                    
                    System.out.println("Desea verificar otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }   
            }else if(op == 4) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese cuil de empleado: ");    
                    cuil = teclado.nextLong();
                    
                    comercio.sueldoNeto(cuil);
                    
                    
                    System.out.println("Desea saber el sueldo neto de otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 5) {
                if(comercio.getEmpleados().isEmpty()) {
                    System.out.println("Todavia no existen empleados registrados");
                }else {
                    comercio.nomina();
                }      
            }else if(op == 6) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese cuil de empleado: ");    
                    cuil = teclado.nextLong();
                    
                    Empleado empleado = comercio.buscarEmpleado(cuil);
                    if(empleado == null) {
                        System.out.println("El empleado no se encuentra");
                    }else {
                        empleado.mostrar();
                    }    
                      
                    System.out.println("Desea buscar otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 7) {
                System.out.println("cantidad de empleados: "+ comercio.cantDeEmpleados());
            }
        }
    }
}
