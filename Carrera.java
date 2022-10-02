
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
            System.out.println("Ingrese la nota 1: ");
            nota1 = teclado.nextDouble();
            teclado.nextLine();
            System.out.println("Ingrese la nota 2:  ");
            nota2 = teclado.nextDouble();
            teclado.nextLine();
            
            Alumno alumno = new Alumno(lu, nombre, apellido);
            alumno.setNota1(nota1);
            alumno.setNota1(nota2);
            curso.inscribirAlumno(alumno);
            
            System.out.println("Desea Inscribir otro alumno? S/N");
            sigue = (teclado.next()).charAt(0);
        }
        
        curso.mostrarInscriptos();
    
        
        System.out.println("Desea eliminar un alumno? S/N");
        sigue = (teclado.next()).charAt(0);
        
        if(sigue == 'S') {
            while(sigue != 'N') {
                System.out.println("Ingrese el lu del alumno: ");    
                lu = teclado.nextInt();
                
                curso.quitarAlumno(lu);
                curso.mostrarInscriptos();
                
                
                System.out.println("Desea eliminar otro alumno? S/N");
                sigue = (teclado.next()).charAt(0);
            }
        }
        
        System.out.println("Desea Buscar un alumno? S/N");
        sigue = (teclado.next()).charAt(0);
        
        if(sigue == 'S') {
            while(sigue != 'N') {
                System.out.println("Ingrese el lu del alumno: ");    
                lu = teclado.nextInt();
                
                curso.imprimirPromedioDelAlumno(lu);
                
                
                System.out.println("Desea Buscar otro alumno? S/N");
                sigue = (teclado.next()).charAt(0);
            }
        }
    }
}