
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
             System.out.println(empleado.getCuil() + "  " + empleado.apeYnom() + " ------------------------------- "+ empleado.sueldoNeto());   
        }
    }
    
    public void mostrar() {
        System.out.println("Banco: "+ this.getNombre() + "    "+ " Sucursal: "+ this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar() + "\n");
        this.listarSueldos();
        System.out.println("Total a pagar: ------------------------------------------------------"+ this.sueldosAPagar());
    }
    
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuentaBancaria) {
        return this.getCuentas().add(p_cuentaBancaria);
    }
    
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuentaBancaria) {
        return this.getCuentas().remove(p_cuentaBancaria);
    }
    
    private void mostrarSaldoCero() {
        int cantSaldoCero = 0;
        System.out.println("Cuentas en Saldo Cero: "+ cantSaldoCero + "\n");
        System.out.println("-----------------------------------------------------------------\n");
        System.out.println("Titulares con Cuenta en Saldo Cero \n");
        System.out.println("-----------------------------------------------------------------\n");
        for(CuentaBancaria cuenta : cuentas) {
            if(cuenta.getSaldo() == 0) {
                cantSaldoCero += 1;
                System.out.println(cuenta.getTitular().getNroDni() + "            "+ cuenta.getTitular().apeYNom());
            }
        }
        System.out.println("-----------------------------------------------------------------\n");
    }
    
    private int cuentasSaldoActivo() {
        int cantActivas = 0;
        for(CuentaBancaria cuenta : cuentas) {
            if(cuenta.getSaldo() > 0) {
                cantActivas += 1;
            }
        }
        return cantActivas;
    }
    
    public void mostrarResumen() {
        System.out.println("Banco: "+ this.getNombre() + "    "+ " Sucursal: "+ this.getNroSucursal());
        System.out.println(this.getLocalidad().mostrar()    + "\n");
        System.out.println("*************************************************************************\n"); 
        System.out.println("RESUMEN DE CUENTAS BANCARIAS\n"); 
        System.out.println("*************************************************************************\n");
        System.out.println("Numero total de Cuentas Bancarias: "+ this.getCuentas().size());
        System.out.println("Cuentas activas: "+ this.cuentasSaldoActivo());
        this.mostrarSaldoCero();
    }
}
