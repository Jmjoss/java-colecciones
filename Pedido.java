
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
    public boolean agregarProducto(Producto p_producto) {
        return this.productos.add(p_producto);
    }
    
    public boolean quitarProducto(Producto p_producto) {
        if(this.getProductos().size() >= 1) {
            return this.productos.remove(p_producto);
        }else {
            return false;   
        }
    }
    
    public double totalAlContado() {
        double totalContado = 0;
        for(Producto producto : productos) {
            totalContado += producto.precioContado(); 
        }
        return totalContado;
    }
    
    public double totalFinanciado() {
        double financiado = 0;
        for(Producto producto : productos) {
            financiado += producto.precioLista(); 
        }
        return financiado;
    }
    
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
