
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
        Scanner teclado = new Scanner(System.in);
        Calendar fechaHoy = new GregorianCalendar();
        ArrayList <Producto> productos = new ArrayList <Producto> ();
        Laboratorio lab = new Laboratorio("laboratorio S.A", "Av maipu 1245", "343434334");
        Producto producto = new Producto(1212, "higiene", "colino", 120, lab);
        
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
        
        Cliente cliente1 = new Cliente(dniCliente, nombreCliente, apellidoCliente, importeCliente);
        
        System.out.println("Datos del laboratorio: ");
        System.out.println("Nombre: ");
        String nombreLab = teclado.nextLine();
        System.out.println("Direccion: ");
        String direccionLab = teclado.nextLine();
        System.out.println("Telefono: ");
        String telefonoLab = teclado.nextLine();
        
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
        
        
        int op = 0; 
        do {
            System.out.println("Menu");
            System.out.println("1.Agregar Producto   2.Salir ");
            op = teclado.nextInt();
            teclado.nextLine();
            switch(op) {
                case 1: System.out.println("Datos del Producto: ");
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
                        productos.add(new Producto(codigoProducto, rubroProducto, descripcionProducto, costoProducto, lab));
                    break;
            }
        }while(op != 2);
        
        
        
        Pedido pedido1 = new Pedido(fechaHoy, cliente1, producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        pedido1.agregarProducto(producto);
        System.out.println(producto);
        System.out.println(pedido1.getCliente());
        System.out.println(pedido1.getProductos());
        System.out.println(pedido1.quitarProducto(producto));
        System.out.println(pedido1.getProductos());
        pedido1.mostrarPedido();
    }
}
