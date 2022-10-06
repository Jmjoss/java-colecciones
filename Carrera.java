
/**
 * Write a description of class Carrera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Carrera
{
     public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char sigue = 'S';
        int lu;
        String nombre;
        String apellido;
        double nota1;
        double nota2;
        int op = -1;
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = teclado.nextLine();
        Curso curso = new Curso(nombreCurso);
        
        
        while(op != 0) {
            System.out.println("\n");
            System.out.println("Ingrese la operacion que desea realizar: ");
            System.out.println("1.Inscribir un alumno   \n2.Buscar un alumno  \n3.Eliminar alumno \n4.Promedio de alumno \n5.Mostrar inscriptos \n0.Salir ");
            op = teclado.nextInt();
            teclado.nextLine();
            
            if(op == 1) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese los datos del alumno: ");
                    System.out.println("Ingrese el lu: ");
                    lu = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese el nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    apellido = teclado.nextLine();
                    System.out.println("Ingrese la nota 1: ");
                    nota1 = teclado.nextDouble();
                    teclado.nextLine();
                    System.out.println("Ingrese la nota 2:  ");
                    nota2 = teclado.nextDouble();
                    teclado.nextLine();
                    
                    Alumno alumno = new Alumno(lu, nombre, apellido);
                    alumno.setNota1(nota1);
                    alumno.setNota2(nota2);
                    curso.inscribirAlumno(alumno);
                    
                    System.out.println("Desea Inscribir otro alumno? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 2) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese el lu del alumno: ");    
                    lu = teclado.nextInt();
                    
                    if(curso.estaInscripto(lu)) {
                        System.out.println("El alumno de lu : "+ lu + " esta inscripto");    
                    }else {
                        System.out.println("El alumno no esta inscripto");    
                    }
                    
                    System.out.println("Desea buscar otro alumno? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 3) {
                sigue = 'S';
                 while(sigue != 'N') {
                    System.out.println("Ingrese el lu del alumno: ");    
                    lu = teclado.nextInt();
                    
                    curso.quitarAlumno(lu);
                    curso.mostrarInscriptos();
                    
                    
                    System.out.println("Desea eliminar otro alumno? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }   
            }else if(op == 4) {
                sigue = 'S';
                while(sigue != 'N') {
                    System.out.println("Ingrese el lu del alumno: ");    
                    lu = teclado.nextInt();
                    
                    curso.imprimirPromedioDelAlumno(lu);
                    
                    
                    System.out.println("Desea Buscar otro alumno? S/N");
                    sigue = (teclado.next()).charAt(0);
                    System.out.println("\n");
                }
            }else if(op == 5) {
                curso.mostrarInscriptos();
            }
        }
    }
}