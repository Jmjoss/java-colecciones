
/**
 * Clase Pedido que permite crear objetos de este tipo.
 * 
 * @author jose candia
 * @version 
 */
import java.util.*;

public class Pedido
{
    //atributos
    Calendar fecha = new GregorianCalendar();
    private Cliente cliente;
    private ArrayList <Producto> productos;
    
    //constructores
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList <Producto> p_productos){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }
    
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList <Producto>());
        this.agregarProducto(p_producto);
    }
    
    //getters
    public Calendar getFecha() {
        return this.fecha;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public ArrayList <Producto> getProductos() {
        return this.productos;
    }
    
    //setters
    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }
    
    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }
    
    private void setProductos(ArrayList <Producto> p_productos) {
        this.productos = p_productos;
    }
    
    //metodos
    /**
     * metodo que permite ingresar un producto al arrayList
     * @param un objeto de tipo Producto
     * 
     * @return true si el objeto se agrego al arrayList o false si no se agrego
     *
     */
    public boolean agregarProducto(Producto p_producto) {
        return this.productos.add(p_producto);
    }
    
    
    /**
     * metodo que permite quitar un producto al arrayList
     * @param un objeto de tipo Producto
     * 
     * @return true si el objeto se quito del arrayList o false si no se elimino
     *
     */
    public boolean quitarProducto(Producto p_producto) {
        if(this.getProductos().size() >= 1) {
            return this.productos.remove(p_producto);
        }else {
            return false;   
        }
    }
    
    
    /**
     * metodo que suma todos los precios al contado de los productos 
     * 
     * @return total al contado
     */
    public double totalAlContado() {
        double totalContado = 0;
        for(Producto producto : productos) {
            totalContado += producto.precioContado(); 
        }
        return totalContado;
    }
    
    /**
     * metodo que suma todos los precios de lista de los productos 
     * 
     * @return total financiado
     */
    public double totalFinanciado() {
        double financiado = 0;
        for(Producto producto : productos) {
            financiado += producto.precioLista(); 
        }
        return financiado;
    }
    
    /**
     * metodo imprime por pantalla los datos del pedido completo fecha, precio contado, precio lista, total
     */
    public void mostrarPedido() {
        System.out.format("***** Detalle del pedido ****** Fecha: %te de %tB de %tY%n", this.getFecha(), this.getFecha(), this.getFecha());
        System.out.format("Producto    \tPrecio de Lista    \tPrecio de Contado \n");
        System.out.println("-------------------------------------------------------------------- ");
        for(Producto producto : productos) {
            System.out.format(producto.getDescripcion() + "       \t"+ producto.precioLista() + "             \t" + producto.precioContado() + "\n");
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.format("*** Total: -- \t"+  this.totalFinanciado() + "           \t"+ this.totalAlContado());
    }
    
}
