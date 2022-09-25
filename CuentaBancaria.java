
/**
 * Clase CuentaBancaria que permite crear objetos de este tipo.
 * 
 * @author jose candia
 * @version 
 */
public class CuentaBancaria
{
    //atributos
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    //constructores
    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(0);
    }
    
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setTitular(p_titular);
        this.setSaldo(p_saldo);
    }
    
    
    //setters
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }
    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }
    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }
    
    
    //getters 
    public int getNroCuenta() {
        return this.nroCuenta;
    }
    
    public Persona getTitular() {
        return this.titular;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    //metodos 
    /**
     * Metodo que deposita un importe a la cuenta y retorna el saldo
     * @param importe a depositar
     * @return saldo
     */
    public double depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    
    /**
     * Metodo que extrae un importe de la cuente
     * @param importe a extraer
     * @return saldo
     */
    public double extraer(double p_importe) {
        this.setSaldo(this.getSaldo() - p_importe);
        return this.getSaldo();
    }
    
    /**
     * Metodo que muestra por pantalla los datos de la cuenta bancaria
     */
    public void mostrar() {
        System.out.println("--Cuenta bancaria--");
        System.out.println("Titular: "+ this.getTitular().nomYApe() + "(" + this.getTitular().edad() + " Años" + ")");
        System.out.println("Saldo: "+ this.getSaldo());
        
    }
    
    /**
     * Metodo que concatena los datos de la cuenta bancaria
     * @return datos de la cuenta bancaria
     */
    public String toString() {
        return this.getNroCuenta() + "  " + this.getTitular().nomYApe() + "  " + this.getSaldo();
    }
}



