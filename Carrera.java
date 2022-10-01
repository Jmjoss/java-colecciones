
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
        
        System.out.println("Ingrese el nombre del curso: ");
        String nombreCurso = teclado.nextLine();
        Curso curso = new Curso(nombreCurso);
        
        while(sigue != 'N') {
            System.out.println("Ingrese los datos del alumno: ");
            System.out.println("Ingrese el lu: ");
            lu = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Ingrese el nombre: ");
            nombre = teclado.nextLine();
            System.out.println("Ingrese el apellido: ");
            apellido = teclado.nextLine();
            
            Alumno alumno = new Alumno(lu, nombre, apellido);
            
            curso.inscribirAlumno(alumno);
            
            System.out.println("Desea Inscribir otro alumno? S/N");
            sigue = (teclado.next()).charAt(0);
        }
        
        curso.mostrarInscriptos();
        System.out.println("Cantidad de alumnos inscriptos: "+ curso.cantDeAlumnos());
        
        System.out.println("Desea eliminar un alumno? S/N");
        sigue = (teclado.next()).charAt(0);
        
        if(sigue == 'S') {
            while(sigue != 'N') {
                System.out.println("Ingrese el lu del alumno: ");    
                lu = teclado.nextInt();
                
                curso.quitarAlumno(lu);
                curso.mostrarInscriptos();
                System.out.println("Cantidad de alumnos inscriptos: "+ curso.cantDeAlumnos());
                
                System.out.println("Desea eliminar otro alumno? S/N");
                sigue = (teclado.next()).charAt(0);
            }
        }
        System.out.println("Cantidad de alumnos inscriptos: "+ curso.cantDeAlumnos());
    }
}