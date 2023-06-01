package clases;

public class Usuario {
    private String preferencia;
    private double dineroDisponible;
    private float tiempoDisponible;
    private String nombre;
    
    public Usuario() {
    	super();
    }
    
    public Usuario(String nombre, String preferencia,  double dineroDisponible, float tiempoDisponible) {
        this.preferencia = preferencia;
        this.dineroDisponible = dineroDisponible;
        this.tiempoDisponible = tiempoDisponible;
        this.nombre = nombre;
    }
    
    // Métodos de acceso (getters) para los atributos
    public String getPreferencia() {
        return preferencia;
    }
    
    public double getDineroDisponible() {
        return dineroDisponible;
    }
    
    public float getTiempoDisponible() {
        return tiempoDisponible;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // Métodos de modificación (setters) para los atributos
    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
    
    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
    
    public void setTiempoDisponible(float tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Método de prueba
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Preferencia: " + preferencia);
        System.out.println("Dinero disponible: " + dineroDisponible);
        System.out.println("Tiempo disponible: " + tiempoDisponible);
    }
}

