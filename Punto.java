
/**
 * Clase para crear un objeto de tipo Punto.
 * 
 * @author jose candia
 * @version 1.0
 */
import java.lang.Math;

public class Punto
{
    
    //atributos
    private double x;
    private double y;
    
    
    //constructores
    public Punto() {
        this.setX(0);
        this.setY(0);
    }

    public Punto(double p_x, double p_y) {
        this.setX(p_x);
        this.setY(p_y);
    }
    
    
    //getters 
    public double getX() {
         return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    
    //setters
    private void setX(double p_x) {
        this.x = p_x;
    }
    
    private void setY(double p_y) {
        this.y = p_y;
    }
    
    
    //metodos
    /**
     * Metodo que calcula distancia desde el mismo, hasta otro recibido como parametro
     * @param el otro punto para calcular la distancia
     * @return  la distancia
     */
    public double distanciaA(Punto p_ptoDistante) {
       return Math.sqrt(Math.pow(p_ptoDistante.getX() - this.getX(), 2) + Math.pow(p_ptoDistante.getY() - this.getY(), 2));
    }
    
    /**
     * Metodo que desplaza los valores x e y.
     * @param los valores de x e y
     */
    public void desplazar(double p_dx, double p_dy) {
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }
    
    /**
     * Metodo que muestra por pantalla los valores x e y
     */
    public void mostrar() {
        System.out.println("Punto. X:" + this.getX() + " Y:"+ this.getY());
    }
    
    /**
     * Metodo que retorna los valores de x e y.
     * @return valores de x e y
     */
    public String coordenadas() {
        return "(" +  this.getX() + ", " + this.getY() + ")";
    }
}
