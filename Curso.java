
/**
 * Write a description of class Curso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Curso
{
    private String nombre;
    private HashMap <Integer, Alumno> alumnos;
   
   
    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap());
    }
   
    public Curso(String p_nombre, HashMap <Integer, Alumno> p_alumnos) {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }
    
   //Setters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    private void setAlumnos(HashMap  <Integer, Alumno> p_alumnos) {
        this.alumnos = p_alumnos;
    }
    
    //getters
    public String getNombre() {
        return this.nombre;
    }
    
    public HashMap <Integer, Alumno> getAlumnos() {
        return this.alumnos;    
    }
    
    //metodos
    
    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(new Integer(p_alumno.getLu()), p_alumno);
    }
    
    public Alumno quitarAlumno(int p_lu) {
       return this.getAlumnos().remove(p_lu);
    } 
    
    public int cantDeAlumnos() {
        return this.getAlumnos().size();
    }
    
        
    public boolean estaInscripto(int p_lu) {
         return this.getAlumnos().containsKey(p_lu);
    }
    
    public boolean estaInscripto(Alumno p_alumno) {
         return this.getAlumnos().containsValue(p_alumno);
    }
    
    public Alumno buscarAlumno(int p_lu) {
        return this.getAlumnos().get(p_lu);
    } 
    
    public void imprimirPromedioDelAlumno(int p_lu) {
        Alumno auxAlumno = this.getAlumnos().get(p_lu);
        System.out.println("Promedio del alumno: "+ auxAlumno.promedio());
    }
    
    public void mostrarInscriptos() {
        System.out.println("Cantidad de Inscriptos: "+ this.cantDeAlumnos());
        for(Map.Entry <Integer, Alumno> alumno : alumnos.entrySet()) {
            System.out.println(alumno.getValue().getLu() + "  "+ alumno.getValue().nomYape());
        }
    }
}

