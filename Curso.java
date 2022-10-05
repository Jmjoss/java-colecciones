
/**
 * Clase Curso que permite crear objetos de este tipo.
 * 
 * @author jose candia
 * @version
 */
import java.util.*;

public class Curso
{
    //atributos
    private String nombre;
    private HashMap <Integer, Alumno> alumnos;
   
   //constructores
    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap <Integer, Alumno> ());
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
    
    
    /**
     * metodo que inscribe a un alumno al curso
     * @param objeto de tipo Alumno
     */
    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(new Integer(p_alumno.getLu()), p_alumno);
    }
    
    /**
     * metodo que quita un alumno del curso
     * @param lu del alumno
     * @return objeto de tipo Alumno
     */
    public Alumno quitarAlumno(int p_lu) {
       return this.getAlumnos().remove(new Integer(p_lu));
    } 
    
    /**
     * metodo que cuenta la cantidad de alumnos
     * 
     * @return cantidad de alumnos
     */
    public int cantDeAlumnos() {
        return this.getAlumnos().size();
    }
    
    /**
     * metodo que verifica si un alumno esta inscripto
     * @param lu del alumno
     * @return true si esta inscripto de lo contrario false
     */    
    public boolean estaInscripto(int p_lu) {
         return this.getAlumnos().containsKey(new Integer(p_lu));
    }
    
    /**
     * metodo que verificas si un alumno esta inscripto
     * @param objeto de tipo Alumno
     * @return true si esta inscripto de lo contrario false
     */
    public boolean estaInscripto(Alumno p_alumno) {
         return this.getAlumnos().containsValue(p_alumno);
    }
    
    /**
     * metodo que busca un alumno 
     * @param lu del alumno
     * @return objeto de tipo alumno
     */
    public Alumno buscarAlumno(int p_lu) {
        return this.getAlumnos().get(new Integer(p_lu));
    } 
    
    /**
     * metodo que imprime por pantalla el promedio de un alumno
     * 
     *@param lu del alumno
     */
    public void imprimirPromedioDelAlumno(int p_lu) {
        Alumno auxAlumno = this.getAlumnos().get(new Integer(p_lu));
        if(auxAlumno == null) {
            System.out.println("El alumno no se encuentra");
        }else {
            auxAlumno.mostrar();
        }  
    }
    
    /**
     * metodo que imprime por pantalla los alumnos inscriptos
     */
    public void mostrarInscriptos() {
        System.out.println("Cantidad de Inscriptos: "+ this.cantDeAlumnos());
        for(Map.Entry <Integer, Alumno> alumno : alumnos.entrySet()) {
            System.out.println(alumno.getValue().getLu() + "  "+ alumno.getValue().nomYape());
        }
    }
}

