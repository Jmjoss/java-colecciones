
/**
 *Clase ejecutable TomaPedido .
 * 
 * @author jose candia
 * @version 
 */
import java.util.*;

public class TomaPedido
{
    public static void main(String[] args) {
        int index;
        char sigue = 'S';
        Scanner teclado = new Scanner(System.in);
        Calendar fechaHoy = new GregorianCalendar();
        ArrayList <Producto> productos = new ArrayList <Producto> ();
        int codigoProducto;
        String rubroProducto;
        String descripcionProducto;
        double costoProducto;
        int cantidad;
        int op = -1;
        
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
        
        Pedido pedidos = new Pedido(fechaHoy, cliente, productos);
        
        while(op != 0) {
            System.out.println("\n1.Agregar un producto  \n2.listar pedido  \n3.Eliminar Producto \n0.Salir");
            op = teclado.nextInt();
            if(op == 1) {
                    sigue = 'S';
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
                        System.out.println("Ingrese la cantidad: ");
                        cantidad = teclado.nextInt();
                    
                        Producto producto = new Producto(codigoProducto, rubroProducto, descripcionProducto, costoProducto, lab);
                        
                        for(int i = 0; i < cantidad; i++) {
                            pedidos.agregarProducto(producto);
                        }   
                        
                        System.out.println("Desea agregar otro producto? S/N");
                        sigue = (teclado.next()).charAt(0);
                    }
            }           
      
            if(op == 2) {
                if(pedidos.getProductos().isEmpty()) {
                    System.out.println("Todavia no existen productos en el pedido");
                }else { 
                    pedidos.mostrarPedido();
                }
            } 
        
            
            if(op == 3) {
                sigue = 'S';
                while(sigue != 'N') {
                    if(pedidos.getProductos().isEmpty()) {
                        System.out.println("Todavia no existen productos en el pedido");
                        break;
                    }else {
                        System.out.println("\nIngrese la posicion del elemento a eliminar");
                        index = teclado.nextInt();
                        teclado.nextLine();
                        
                        if(index > 0 && index <= pedidos.getProductos().size()) {
                            pedidos.quitarProducto(productos.get(index-1));
                            pedidos.mostrarPedido();
                        }else {
                            System.out.println("Posicion no valida");
                        }
                                           
                        System.out.println("\nDesea eliminar otro producto? S/N");
                        sigue = (teclado.next()).charAt(0);
                    }
                }
            } 
        }
    
    }
}  