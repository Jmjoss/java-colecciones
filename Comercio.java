
/**
 * Write a description of class Comercio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Comercio
{
    private String nombre;
    private HashMap <Long, Empleado> empleados;
    
    
    public Comercio(String p_nombre) {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap <Long, Empleado> ());
    }
    
    public Comercio(String p_nombre, HashMap <Long, Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }
    
    //setters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    private void setEmpleados(HashMap <Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }
    
    //getters
    public String getNombre() {
        return this.nombre;
    }
    
    public HashMap <Long, Empleado> getEmpleados() {
        return this.empleados;
    }
    
    
    //metodos
    
    public void altaEmpleado(Empleado p_empleado) {
        this.getEmpleados().put(new Long(p_empleado.getCuil()), p_empleado);
    }
    
    public Empleado bajaEmpleado(long p_cuil) {
        return this.getEmpleados().remove(new Long(p_cuil));
    }
    
    public int cantDeEmpleados() {
        return this.getEmpleados().size();
    }
    
    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(new Long(p_cuil));
    }
    
    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(new Long(p_cuil));
    }
    
    public void sueldoNeto(long p_cuil) {
        Empleado aux = this.buscarEmpleado(p_cuil);
        if(aux == null) {
            System.out.println("El empleado no se encuentra");   
        }else {
            System.out.println("El sueldo neto es: "+ aux.sueldoNeto());
        }
    }
    
    public void nomina() {
        System.out.println("***Nomina de empleados de "+ this.getNombre() + " ****\n");
        for(Map.Entry <Long, Empleado> empleado : empleados.entrySet()) {
            System.out.println(empleado.getValue().getCuil() + "  "+ empleado.getValue().apeYnom() + "------"+ empleado.getValue().sueldoNeto());
        }
    }
}

