
/**
 * Write a description of class AplicacionBanco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class AplicacionBanco
{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char sigue = 'S';
        long cuil;
        String apellido;
        String nombre;
        double sueldo;
        int anio;
        int dni;
        int mes;
        int dia;
        ArrayList <Empleado> empleados = new ArrayList <Empleado> ();
        
        System.out.println("Ingrese la localidad: ");
        String nombreLocalidad = teclado.nextLine();
        System.out.println("Ingrese la provincia: ");
        String nombreProvincia = teclado.nextLine();
        
        
        Localidad localidad = new Localidad(nombreLocalidad, nombreProvincia);
        
        System.out.println("Ingrese el nombre del banco: ");
        String nombreBanco = teclado.nextLine();
        System.out.println("Ingrese el numero de sucursal: ");
        int nroSucursal = teclado.nextInt();
        teclado.nextLine();
        
        Banco banco = new Banco(nombreBanco, localidad, nroSucursal, empleados);
        
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
            anio = teclado.nextInt();
            teclado.nextLine();
            
            Empleado empleado = new Empleado(cuil, apellido, nombre, sueldo, anio);
            banco.agregarEmpleado(empleado);
            
            System.out.println("Desea Inscribir otro empleado? S/N");
            sigue = (teclado.next()).charAt(0);
        }           

        banco.mostrar();
        
        
    }
}
