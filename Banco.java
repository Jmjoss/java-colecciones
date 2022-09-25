
/**
 * Write a description of class Banco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Banco
{
    //atributos
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList <Empleado> empleados;
    
    //constructores
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList <Empleado>());
        this.agregarEmpleado(p_empleado);
    }
    
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList <Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
    }
    
    //setters
    
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    private void setNroSucursal(int p_nroSucursal) {
        this.nroSucursal = p_nroSucursal;
    }
    
    private void setLocalidad(Localidad p_localidad) {
        this.localidad = p_localidad;
    }
    
    private void setEmpleados(ArrayList <Empleado> p_empleados) {
        this.empleados = p_empleados;
    }
    
    //getters
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getNroSucursal() {
        return this.nroSucursal;
    }
    
    public Localidad getLocalidad() {
        return this.localidad;
    }
    
    public ArrayList <Empleado> getEmpleados() {
        return this.empleados;
    }
    
    //metodos
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }
    
    public boolean quitarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().remove(p_empleado);
    }
    
    public double sueldosAPagar() {
        double total = 0;
        for(Empleado empleado : empleados) {
            total += empleado.sueldoNeto();
        }
        return total;
    }
    
    public void listarSueldos() {
        for(Empleado empleado : empleados) {
             System.out.format(empleado.getCuil() + "  " + empleado.apeYnom() + " ------------------------------- %.2f", empleado.sueldoNeto() + "\n");   
        }
    }
    
    public void mostrar() {
        System.out.println("Banco: "+ this.getNombre() + "    "+ " Sucursal: "+ this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar());
        this.listarSueldos();
        System.out.println("Total a pagar: ------------------------------------------------------"+ this.sueldosAPagar());
    }
}
