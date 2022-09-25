
/**
 * Clase Producto que permite crear objetos de este tipo.
 * 
 * @author jose candia 
 * @version 
 */

public class Producto
{
    //atributos
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio lab;
    
    //constructores sobrecargados
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setStock(0);
        this.setLab(p_lab);
    }
    
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setLab(p_lab);
    }
    
    //getters 
    public int getCodigo() {
        return this.codigo;
    }
    public String getRubro() {
        return this.rubro;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public double getCosto() {
        return this.costo;
    }
    public int getStock() {
        return this.stock;
    }
    public double getPorcPtoRepo() {
        return this.porcPtoRepo;
    }
    public int getExistMinima() {
        return this.existMinima;
    }
    public Laboratorio getLab() {
        return this.lab;
    }
  
    //setters 
    private void setCodigo(int p_codigo) {
        this.codigo = p_codigo;
    }
    private void setRubro(String p_rubro) {
        this.rubro = p_rubro;
    }
    private void setDescripcion(String p_desc) {
        this.descripcion = p_desc;
    }
    private void setCosto(double p_costo) {
        this.costo = p_costo;
    }
    private void setStock(int p_stock) {
        this.stock = p_stock;
    }
    private void setPorcPtoRepo(double p_porcPtoRepo) {
        this.porcPtoRepo = p_porcPtoRepo;
    }
    private void setExistMinima(int p_existMinima) {
        this.existMinima = p_existMinima;
    }
    private void setLab(Laboratorio p_lab) {
        this.lab = p_lab;
    }
    
    // metodos
    /**
     * Metodo que ajusta la cantidad de stock disponible
     * @param p_cantidad la cantidad de stock
     */
    public void ajuste(int p_cantidad) {
        this.setStock(this.getStock() + p_cantidad);
    }  
    
    /**
     * Metodo que retorna el precio de lista
     * @return el precio de lista
     */
    public double precioLista() {
        return this.getCosto() + (this.getCosto() * 0.12);
    }
    
    /**
     * Metodo que retorna el precio de contado
     * @return precio de contado
     */
    public double precioContado() {
        return this.precioLista() - (this.precioLista() * 0.05);
    }
    
    /**
     * Metodo multiplica el stock por el precio de costo, más una rentabilidad de 12%.
     * @return stock por el precio de costo, más una rentabilidad de 12%
     */
    public double stockValorizado() {
        return (this.getStock() * this.getCosto()) + (this.getStock() * this.getCosto() * 0.12);
    }
    
    /**
     * Metodo que ajusta el porcentaje de punto de reposición 
     * @param p_porce el porcentaje de punto de reposicion
     */
    public void ajustarPtoRepo(double p_porce) {
        this.setPorcPtoRepo(p_porce);
    }
    
    /**
     * Metodo que ajusta la existecia minima 
     * @param p_cantidad la existencia minima
     */
    public void ajustarExistMin(int p_cantidad) {
        this.setExistMinima(p_cantidad);
    }
    
    /**
     * Metodo que concatena los atributos del objeto descripcion, precio de lista y precio contado.
     * @return descripcion, precio de lista y precio contado.
     */
    public String mostrarLinea() {
        return this.getDescripcion() + " " + this.precioLista() + " " + this.precioContado();
    }
    
    /**
     * Metodo que muestra por pantalla los datos de laboratorio y producto
     *
     */
    public void mostrar() {
        System.out.println("Laboratorio: "+ this.getLab().getNombre() + "\n" + "Domicilio: "+ this.getLab().getDomicilio() + "  - Telefono: "+ this.getLab().getTelefono());
        System.out.println("\nRubro: "+ this.getRubro() + "\n" + "Descripcion: "+ this.getDescripcion() + "\n" + "Precio costo: "+ this.getCosto() + "\n" + "Stock: "+ this.getStock() + " -" + " Stock valorizado: "+ this.stockValorizado() + "\n");
    }
}
