
/**
 * Write a description of class TomaPedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class TomaPedido
{
    public static void main(String[] args) {
        char sigue = 'S';
        Scanner teclado = new Scanner(System.in);
        Calendar fechaHoy = new GregorianCalendar();
        ArrayList <Producto> productos = new ArrayList <Producto> ();
        int codigoProducto;
        String rubroProducto;
        String descripcionProducto;
        double costoProducto;
        
        
        System.out.println("Datos del Cliente: ");
        System.out.println("DNI: ");
        int dniCliente = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Nombre: ");
        String nombreCliente = teclado.nextLine();
        System.out.println("Apellido: ");
        String apellidoCliente = teclado.nextLine();
        System.out.println("Importe: ");
        double importeCliente = teclado.nextDouble();
        teclado.nextLine();
        
        Cliente cliente = new Cliente(dniCliente, nombreCliente, apellidoCliente, importeCliente);
        
        System.out.println("Datos del laboratorio: ");
        System.out.println("Nombre: ");
        String nombreLab = teclado.nextLine();
        System.out.println("Direccion: ");
        String direccionLab = teclado.nextLine();
        System.out.println("Telefono: ");
        String telefonoLab = teclado.nextLine();
        
        Laboratorio lab = new Laboratorio(nombreLab, direccionLab, "343434334");
        
        System.out.println("Datos del Producto: ");
        System.out.println("Codigo: ");
        int codigoProducto = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Rubro: ");
        String rubroProducto = teclado.nextLine();
        System.out.println("Descripcion: ");
        String descripcionProducto = teclado.nextLine();
        System.out.println("Costo por unidad: ");
        double costoProducto = teclado.nextDouble();
        teclado.nextLine();
        
        Pedido pedidos = new Pedido(fechaHoy, cliente, productos);
        
                while(sigue != 'N') {
                    System.out.println("Datos del Producto: ");
                    System.out.println("Codigo: ");
                    codigoProducto = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Rubro: ");
                    rubroProducto = teclado.nextLine();
                    System.out.println("Descripcion: ");
                    descripcionProducto = teclado.nextLine();
                    System.out.println("Costo por unidad: ");
                    costoProducto = teclado.nextDouble();
                    teclado.nextLine();
                    
                    Producto producto = new Producto(codigoProducto, rubroProducto, descripcionProducto, costoProducto, lab);
                    
                    pedidos.agregarProducto(producto);
                    
                    
                    System.out.println("Desea Inscribir otro empleado? S/N");
                    sigue = (teclado.next()).charAt(0);
            }           
      
        pedidos.mostrarPedido();
    }
}
