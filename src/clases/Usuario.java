package clases;

public class Usuario {
    private String preferencia;
    private double dineroDisponible;
    private int tiempoDisponible;
    private String nombre;
    
    public Usuario(String preferencia, double dineroDisponible, int tiempoDisponible, String nombre) {
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
    
    public int getTiempoDisponible() {
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
    
    public void setTiempoDisponible(int tiempoDisponible) {
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

