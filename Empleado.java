
/**
 * Clase Empleado.
 * 
 * @author jose candia 
 * @version 1.0
 */
import java.util.*;

public class Empleado
{
    //atributos
    private long cuil;
    private String nombre;
    private String apellido;
    private double sueldoBasico;
    private Calendar fechaIngreso = new GregorianCalendar();
    
    //constructores sobrecargados
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anioIngreso) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anioIngreso);
    }
    
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fechaIngreso) {
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_fechaIngreso.get(Calendar.YEAR));
        this.setFechaIngreso(p_fechaIngreso);
        
    }
    
    //getters
    public long getCuil() {
        return this.cuil;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    public double getSueldoBasico() {
        return this.sueldoBasico;
    }
    public int getAnioIngreso() {
        return this.fechaIngreso.get(Calendar.YEAR);
    }    
    
    public Calendar getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    //setters
    private void setCuil(long p_cuil) {
        this.cuil = p_cuil;
    }
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }
    private void setSueldoBasico(double p_sueldoBasico) {
        this.sueldoBasico = p_sueldoBasico;
    }
    private void setAnioIngreso(int p_anioIngreso) {
        this.fechaIngreso.set(p_anioIngreso, 0, 1);
    }
    
    private void setFechaIngreso(Calendar p_fechaIngreso) {
        this.fechaIngreso = p_fechaIngreso;
    }
    
    //metodos
    
    /**
     * Metodo que retorna la antiguedad del empleado 
     * @return    años de antiguedad
     */
    public int antiguedad() {
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getFechaIngreso().get(Calendar.YEAR); 
    }
    
    
    /**
     * Metodo que retorna el descuento al sueldo basico
     * @return     el monto de descuento 
     */
    private double descuento() {
        double descuentoObraS = this.getSueldoBasico() * 0.02;
        return  descuentoObraS + 12; 
    }
    
    
    /**
     * Metodo que retorna el monto adicional 
     * @return     el monto adicional
     */
    private double adicional() {
        double adicional = 0;
        if(this.antiguedad() < 2){
            adicional = this.getSueldoBasico() * 0.02;
        }else if(this.antiguedad() >= 2 && this.antiguedad() < 10) {
            adicional = this.getSueldoBasico() * 0.04;
        }else if(this.antiguedad() >= 10) {
            adicional = this.getSueldoBasico() * 0.06;
        }
        return adicional;
    }
    /**
     * Metodo que suma el sueldo basico, el adicional y resta el descuento
     * @return     el sueldo neto
     */
    public double sueldoNeto() {
        return this.getSueldoBasico() + this.adicional() - this.descuento();
    }
    /**
     * Metodo que retorna apellido y nombre concatenados 
     * @return     apellido y nombre
     */
    public String apeYnom() {
        return this.getApellido() + " " + this.getNombre();
    }
    /**
     * Metodo que retorna nombre y apellido concatenados 
     * @return     nombre y apellido
     */
    public String nomYape() {
        return this.getNombre() + " " + this.getApellido();
    }
    /**
     * Metodo que imprime por pantalla los atributos y datos del problema
     * 
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: "+ this.nomYape());
        System.out.println("Cuil: "+ this.getCuil() + "   Antiguedad: "+ this.antiguedad() + " años de servicio");
        System.out.println("Sueldo neto: $"+ this.sueldoNeto());
    }
    /**
     * Metodo que retorna una linea con atributos concatenados
     * @return     atributos del objeto concatenados
     */
    public String mostrarLinea() {
        return this.getCuil() + "  " + this.getApellido() + ", " + this.getNombre() + "...." + "$" + this.sueldoNeto();
    }
    
    
    /**
     * Metodo que verifica si el empleado cumple un año o mas en la empresa
     * @return true o false segun sea o no el aniversario del empleado
     */
    public boolean esAniversario() {
        Calendar fechaHoy = new GregorianCalendar();
        int mesHoy = (fechaHoy.get(Calendar.MONTH)+1);
        int diaHoy = fechaHoy.get(Calendar.DAY_OF_MONTH);
        
        if(mesHoy == this.getFechaIngreso().get(Calendar.MONTH) && diaHoy == this.getFechaIngreso().get(Calendar.DAY_OF_MONTH)) {
            return true;
        }else {
            return false;
        }
    }
}
