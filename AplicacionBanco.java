
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
        int op = -1;
        int nroCuenta;
        double saldo;
        int index;
        ArrayList <Empleado> empleados = new ArrayList <Empleado> ();
        ArrayList <CuentaBancaria> cuentas = new ArrayList <CuentaBancaria> ();
        
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
        
        Banco banco = new Banco(nombreBanco, localidad, nroSucursal, empleados, cuentas);
        
        while(op != 0) {
            System.out.println("\n1.Agregar un empleado  \n2.agregar cuenta bancaria  \n3.Nomina empleados  \n4.Resumen \n5.Quitar empleado \n6.Quitar cuenta Bancaria \n0.Salir");
            op = teclado.nextInt();
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
                    anio = teclado.nextInt();
                    teclado.nextLine();
                        
                    Empleado empleado = new Empleado(cuil, apellido, nombre, sueldo, anio);
                    banco.agregarEmpleado(empleado);
                        
                    System.out.println("Desea Inscribir otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
                }
        }           
            
        if(op == 2) {
            sigue = 'S';
            while(sigue != 'N') {
                System.out.println("Ingrese los datos del titular: ");
                System.out.println("Ingrese el dni: ");
                dni = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Ingrese el apellido: ");
                apellido = teclado.nextLine();
                System.out.println("Ingrese el nombre: ");
                nombre = teclado.nextLine();
                System.out.println("Ingrese el año de nacimiento: ");
                anio = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Ingrese los datos de la cuenta: ");
                System.out.println("Ingrese el nro  de cuenta: ");
                nroCuenta = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Ingrese el saldo de la cuenta: ");
                saldo = teclado.nextDouble();
                teclado.nextLine();
                        
                Persona persona = new Persona(dni, nombre, apellido, anio);
                CuentaBancaria cuenta = new CuentaBancaria(nroCuenta, persona, saldo);
                banco.agregarCuentaBancaria(cuenta);
                System.out.println("Desea Inscribir otra cuenta? S/N");
                sigue = (teclado.next()).charAt(0);
            }
        } 

        if(op == 3) {
            banco.mostrar();
        } 
            
        if(op == 4) {
            banco.mostrarResumen();
        }
            
        if(op == 5) {
            sigue = 'S';
            while(sigue != 'N') {
                System.out.println("\nIngrese la posicion del empleado a eliminar: ");
                index = teclado.nextInt();
                teclado.nextLine();
                   
                banco.quitarEmpleado(empleados.get(index-1));
                    
                banco.mostrar();
                
                System.out.println("\nDesea eliminar otro empleado? S/N");
                sigue = (teclado.next()).charAt(0);
            }
        }
        if(op == 6) {
            sigue = 'S';
            while(sigue != 'N') {
                System.out.println("\nIngrese la posicion de la cuenta a eliminar");
                index = teclado.nextInt();
                teclado.nextLine();
                
                banco.quitarCuentaBancaria(cuentas.get(index-1));
                  
                banco.mostrarResumen();
                
                System.out.println("\nDesea eliminar otra cuenta? S/N");
                sigue = (teclado.next()).charAt(0);
                }
            }
        }   
    }
}
