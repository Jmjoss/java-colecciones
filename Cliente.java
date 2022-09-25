
/**
 * Clase Cliente que permite crear objetos del tipo Cliente.
 * 
 * @author jose candia
 * @version 1.0
 */
public class Cliente
{
    //atributos
   private int nroDni;
   private String apellido;
   private String nombre;
   private double saldo;
   
   //constructor
    public Cliente(int p_nroDni,String p_apellido,String p_nombre, double p_importe) {
        this.setNroDni(p_nroDni);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSaldo(p_importe);
    }
    
    //getters
    public int getNroDni(){
        return this.nroDni;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getNombre(){
        return this.nombre;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    //setters
    private void setNroDni(int p_nroDni){
        this.nroDni = p_nroDni;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setSaldo(double p_saldo){
        this.saldo = p_saldo;
    }
    
    //metodos
    /**
     * Metodo que asigna un nuevo saldo y lo devuelve
     * 
     * @param  p_importe Nuevo saldo  
     * @return     (double) nuevo saldo 
     */
    public double nuevoSaldo(double p_importe){
        this.setSaldo(p_importe);
        return this.getSaldo();
    }
    
    /**
     * Metodo que agrega un monto al saldo y lo devuelve
     * 
     * @param  p_importe saldo a agregar  
     * @return     (double) nuevo saldo 
     */
    public double agregaSaldo(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
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
     * Metodo que proporciona una salida por pantalla de los datos del problema
     */
    public void mostrar() {
        System.out.println("-Cliente-");
        System.out.println("Nombre y apellido: " + this.nomYape() + "("+ this.getNroDni() +")");
        System.out.println("Saldo: $"+ this.getSaldo());
    }
}
