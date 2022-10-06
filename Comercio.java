
/**
 * Clase Comercio que permite crear objetos de este tipo.
 * 
 * @author jose candia 
 * @version 
 */

import java.util.*;

public class Comercio
{
    //atributos
    private String nombre;
    private HashMap <Long, Empleado> empleados;
    
    //constructores
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
    
    /**
     * metodo que permite dar de alta un empleado
     * 
     * @param objeto de tipo Empleado
     */
    public void altaEmpleado(Empleado p_empleado) {
        this.getEmpleados().put(new Long(p_empleado.getCuil()), p_empleado);
    }
    
    /**
     * metodo que da de baja un empleado
     * @return objeto de tipo Empleado
     * @param objeto de tipo Empleado
     */
    public Empleado bajaEmpleado(long p_cuil) {
        return this.getEmpleados().remove(new Long(p_cuil));
    }
    
    
    /**
     * metodo que cuenta la cantidad de empleados
     * 
     * @return cantidad de empleados
     */
    public int cantDeEmpleados() {
        return this.getEmpleados().size();
    }
    
    
    /**
     * metodo que verifica con el cuil si es empleado
     * @param cuil de la persona
     * @return true si es empleado del comercio de lo contrario false
     */
    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(new Long(p_cuil));
    }
    
    /**
     * metodo que busca un empleado
     * @param cuil de la persona
     * @return Objeto de tipo Empleado 
     */
    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(new Long(p_cuil));
    }
    
    /**
     * metodo que imprime por pantalla el sueldo neto de un empleado
     * 
     * @param cuil de la persona
     */
    public void sueldoNeto(long p_cuil) {
        Empleado aux = this.buscarEmpleado(p_cuil);
        if(aux == null) {
            System.out.println("El empleado no se encuentra");   
        }else {
            System.out.println("El sueldo neto es: $"+ aux.sueldoNeto());
        }
    }
    
    
    /**
     * metodo que imprime por pantalla la nomina de empleados
     *
     */
    public void nomina() {
        System.out.println("***Nomina de empleados de "+ this.getNombre() + " ****\n");
        for(Map.Entry <Long, Empleado> empleado : empleados.entrySet()) {
            System.out.println(empleado.getValue().getCuil() + "  "+ empleado.getValue().apeYnom() + "------ $"+ empleado.getValue().sueldoNeto());
        }
    }
}

