/**
 * Clase que permite crear objetos de tipo Persona
 * 
 * @author jose candia
 * @version 1.0
 */
import java.util.*;
public class Persona
{
    //atributos
    private int nroDni;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento = new GregorianCalendar();
    
    //constructores sobrecargados
    Persona(int p_dni, String p_nombre, String p_apellido, int p_anioNacimiento){
        this.setNroDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anioNacimiento);
    }
    
    Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        this.setNroDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_fecha.get(Calendar.YEAR));
        this.setFechaNacimiento(p_fecha);
    }
    
    //setters
    private void setNroDni(int p_nroDni){
        this.nroDni = p_nroDni;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    private void setAnioNacimiento(int p_anioNacimiento){
        this.fechaNacimiento.set(p_anioNacimiento,0,1);
    }
    
    private void setFechaNacimiento(Calendar p_fecha) {
        this.fechaNacimiento = p_fecha;
    }
    
    
    //getters
    public int getNroDni() {
        return this.nroDni;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public int getAnioNacimiento(){
        return this.fechaNacimiento.get(Calendar.YEAR);
    }
    
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    //metodos
    /**
     * Metodo que retorna la edad de la persona
     * @return edad 
     */
    public int edad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioNacimiento();
    }
    
    /**
     * Metodo que concatena nombre y apellido
     * @return nombre y apellido
     */
    public String nomYApe() {
        return this.getNombre() + " " + this.getApellido();
    }
    
    
    /**
     * Metodo que concatena apellido y nombre
     * @return  apellido y nombre
     */
    public String apeYNom(){
        return this.getApellido() + " " + this.getNombre();
    }
    
    /**
     * Metodo que muestra por pantalla los datos del objeto
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ this.nomYApe());
        System.out.println("DNI: "+ this.getNroDni());
        System.out.println("Edad: "+ this.edad());
    }
    
    /**
     * Metodo que comprueba si hoy es el cumpleaños de la persona
     * @return true o false
     */
    public boolean esCumpleaños() {
        Calendar fechaHoy = new GregorianCalendar();
        int mes = (fechaHoy.get(Calendar.MONTH)+1);
        int dia = fechaHoy.get(Calendar.DATE);
        if(mes == this.getFechaNacimiento().get(Calendar.MONTH) && dia == this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH)) {
            return true;
        }else {
            return false;
        }
    }
}

