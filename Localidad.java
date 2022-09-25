
/**
 * Clase Localidad que permite crear objetos de este tipo.
 * 
 * @author jose candia 
 * @version 
 */
public class Localidad
{
    //atributos
    private String nombre;
    private String provincia;
    
    //constructor
    public Localidad(String p_nombre, String p_provincia) {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }
    
    //Setters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }
    
    private void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }
    
    
    //getters
    public String getNombre() {
        return this.nombre;
    }
    
    public String getProvincia() {
        return this.provincia;
    }
    
    
    //metodos
    /**
     * Metodo que concatena y retorna los datos de la localidad.
     * @return datos de localidad 
     */
    public String mostrar() {
        return "Localidad: "+ this.getNombre() + "      "+ "Provincia: "+ this.getProvincia();
    }
}
