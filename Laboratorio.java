
/**
 * Clase laboratorio que permite crear objetos del tipo Laboratorio.
 * 
 * @author jose candia 
 * @version 1.0
 */
public class Laboratorio
{
    //atributos
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;
    
    //constructores sobrecargados
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMinima, int p_diaEntrega) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.ajusteCompraMin(p_compraMinima);
        this.ajusteDiaDeEntrega(p_diaEntrega);
    }
    
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.ajusteCompraMin(0);
        this.ajusteDiaDeEntrega(0);
    }
    
    //getters
    public String getNombre() {
        return this.nombre;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    public String getTelefono() {
        return this.telefono;
    }
    public int getCompraMinima() {
        return this.compraMinima;
    }
    public int getDiaEntrega() {
        return this.diaEntrega;
    }
    
    //setters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }
    private void setTelefono(String p_telefono) {
        this.telefono = p_telefono;
    }
    private void setCompraMinima(int p_compraMinima) {
       this.compraMinima = p_compraMinima;
    }
    private void setDiaEntrega(int p_diaEntrega) {
       this.diaEntrega = p_diaEntrega;
    }
    
    //metodos
    /**
     * Metodo que asigna un dia de entrega
     * 
     * @param  p_diaEntrega el dia de entrega
     */
    public void ajusteDiaDeEntrega(int p_diaEntrega){
        this.setDiaEntrega(p_diaEntrega);
    }
    /**
     * Metodo que asigna una compra minima
     * 
     * @param  p_compraMinima la cantidad de compra minima
     */
    public void ajusteCompraMin(int p_compraMinima){
        this.setCompraMinima(p_compraMinima);
    }
    /**
     * Metodo que retorna los atributos concatenados
     * @return    atributos del objeto concatenados
     */
    public String  mostrar() {
        return "Laboratorio: "+ this.getNombre() + "\n" + "Domicilio: "+ this.getDomicilio() + "\n" + "Telefono: "+ this.getTelefono() + "\n" +"Compra minima: " + this.getCompraMinima() + "\n" +"Dia entrega: "+ this.getDiaEntrega();
    }
}
