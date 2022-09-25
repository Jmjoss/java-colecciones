
/**
 * Write a description of class AplicacionBanco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AplicacionBanco
{
    public static void main(String[] args) {
        Localidad localidad = new Localidad("Empedrado","Corrientes");
        Empleado empleado = new Empleado(323232303, "candia", "jose", 200000, 2018);
        Banco banco = new Banco("Santander", localidad, 23, empleado);
        banco.agregarEmpleado(empleado);
        banco.agregarEmpleado(empleado);
        banco.agregarEmpleado(empleado);
        banco.agregarEmpleado(empleado);
        banco.agregarEmpleado(empleado);
        banco.mostrar();
    }
}
