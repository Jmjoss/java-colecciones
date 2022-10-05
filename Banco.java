
/**
 * Clase Banco que permite crear objetos de este tipo.
 * 
 * @author jose candia
 * @version 
 */
import java.util.*;

public class Banco
{
    //atributos
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList <Empleado> empleados;
    private ArrayList <CuentaBancaria> cuentas;
    
    //constructores
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList <Empleado>());
        this.agregarEmpleado(p_empleado);
        this.setCuentas(new ArrayList <CuentaBancaria> ());
    }
    
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList <Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentas(new ArrayList <CuentaBancaria> ());
    }
    
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList <Empleado> p_empleados, ArrayList <CuentaBancaria> p_cuentas) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentas(p_cuentas);
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
    
    private void setCuentas(ArrayList <CuentaBancaria> p_cuentas) {
        this.cuentas = p_cuentas;
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
    
    public ArrayList <CuentaBancaria> getCuentas() {
        return this.cuentas;
    }
    
    //metodos
    
    /**
     * metodo que agrega un empleado al arrayList empleados
     * 
     * @return true si se agrego correctamente de lo contrario false
     */
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }
    
    /**
     * metodo que quita un empleado del arrayList empleados
     * 
     * @return true si se quito correctamente de lo contrario false
     */
    public boolean quitarEmpleado(Empleado p_empleado) {
        if(this.getEmpleados().size() >= 1) {
            return this.getEmpleados().remove(p_empleado);
        }else {
            return false;
        } 
    }
    
    /**
     * metodo que suma todos los sueldos netos de los empleados
     * 
     * @return total de sueldos a pagar
     */
    public double sueldosAPagar() {
        double total = 0;
        for(Empleado empleado : empleados) {
            total += empleado.sueldoNeto();
        }
        return total;
    }
    
    /**
     * metodo que imprime por pantalla todos los empleados
     */
    public void listarSueldos() {
        for(Empleado empleado : empleados) {
             System.out.println(empleado.getCuil() + "  " + empleado.apeYnom() + " ------------------------------- $"+ empleado.sueldoNeto());   
        }
    }
    
    
    /**
     * metodo que imprime por pantalla datos del banco, todos los empleados y total de sueldos a pagar
     */
    public void mostrar() {
        System.out.println("Banco: "+ this.getNombre() + "    "+ " Sucursal: "+ this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar() + "\n");
        this.listarSueldos();
        System.out.println("Total a pagar: ------------------------------------------------ $"+ this.sueldosAPagar());
    }
    
    
    /**
     * metodo que agrega una cuenta bancaria al arrayList cuentas
     * @param objeto de tipo CuentaBancaria
     * @return true si se agrego correctamente de lo contrario false
     */
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuentaBancaria) {
        return this.getCuentas().add(p_cuentaBancaria);
    }
    
    /**
     * metodo que quita una cuenta bancaria del arrayList cuentas
     * @param objeto de tipo CuentaBancaria
     * @return true si se quito correctamente de lo contrario false
     */
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuentaBancaria) {
        if(this.getCuentas().size() >= 1) {
            return this.getCuentas().remove(p_cuentaBancaria);
        }else {
            return false;
        }
    }
    
    
    /**
     * metodo que imprime por pantalla los titulares con cuenta en saldo cero
     */
    private void mostrarSaldoCero() {
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Titulares con Cuenta en Saldo Cero \n");
        System.out.println("-----------------------------------------------------------------\n");
        for(CuentaBancaria cuenta : cuentas) {
            if(cuenta.getSaldo() == 0) {
                System.out.println(cuenta.getTitular().getNroDni() + "            "+ cuenta.getTitular().apeYNom());
            }
        }
        System.out.println("-----------------------------------------------------------------\n");
    }
    
    /**
     * metodo que cuenta la cantidad de cuentas activas
     * @return la cantidad de cuentas activas
     */
    private int cuentasSaldoActivo() {
        int cantActivas = 0;
        for(CuentaBancaria cuenta : cuentas) {
            if(cuenta.getSaldo() > 0) {
                cantActivas += 1;
            }
        }
        return cantActivas;
    }
    
    /**
     * metodo que imprime por pantalla el resumen de cuentas
     */
    public void mostrarResumen() {
        int cantSaldoCero = 0;
        System.out.println("Banco: "+ this.getNombre() + "    "+ " Sucursal: "+ this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar()    + "\n");
        System.out.println("*************************************************************************\n"); 
        System.out.println("RESUMEN DE CUENTAS BANCARIAS\n"); 
        System.out.println("*************************************************************************\n");
        System.out.println("Numero total de Cuentas Bancarias: "+ this.getCuentas().size());
        System.out.println("Cuentas activas: "+ this.cuentasSaldoActivo());
        for(CuentaBancaria cuenta : cuentas) {
            if(cuenta.getSaldo() == 0) {
                cantSaldoCero += 1;
            }
        }
        System.out.println("Cuentas en Saldo Cero: "+ cantSaldoCero + "\n");
        this.mostrarSaldoCero();
    }
}
