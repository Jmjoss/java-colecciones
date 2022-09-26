
/**
 * Clase Alumno.
 * 
 * @author jose candia 
 * @version 1.0
 */
public class Alumno
{
    //atributos
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    
    //constructor
    /**
     * Metodo constructor que crea un objeto Alumno
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido){
        this.setLu(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(0);
        this.setNota2(0);
    }
    
    //getters
    public int getLu() {
        return this.lu;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public double getNota1() {
        return this.nota1;
    }
    public double getNota2() {
        return this.nota2;
    }
    
    
    //setters
    private void setLu(int p_lu) {
        this.lu = p_lu;
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    public void setNota1(double p_nota){
        this.nota1 = p_nota;
    }
    public void setNota2(double p_nota) {
        this.nota2 = p_nota;
    }    
    
    //metodos
    /**
     * Metodo que retorna un true o false, segun el promedio de notas
     * @return     boolean
     */
    private boolean aprueba() {
        if(this.promedio() > 7.0 && this.getNota1() >= 6.0 && this.getNota2() >= 6.0) {
            return true;
        }else {
            return false;
        }
    } 
    /**
     * Metodo que retorna una leyenda de aprobado o desaprobado
     * @return     String
     */
    private String leyendaAprueba() {
        if(this.aprueba()) {
            return "APROBADO";
        }else {
            return "DESAPROBADO";
        }
    }
    /**
     * Metodo que retorna el promedio de notas
     * @return     double
     */
    public double promedio() {
        return (this.getNota1() + this.getNota2()) / 2;
    }
    /**
     * Metodo que retorna apellido y nombre concatenados
     * @return     String 
     */    
    public String apeYnom() {
        return this.getApellido() + " " + this.getNombre();
    }
    /**
     * Metodo que retorna nombre y apellido concatenados
     * @return     String
     */
    public String nomYape() {
        return this.getNombre() + " " + this.getApellido();
    }
    
    /**
     * Metodo que proporciona una salida por pantalla de atributos del objeto y datos del problema
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ this.nomYape());
        System.out.println("LU: "+ this.getLu() + " Notas: "+ this.getNota1() + " - " + this.getNota2());
        System.out.println("Promedio: "+ this.promedio() + " - "+ this.leyendaAprueba());
    }
}
