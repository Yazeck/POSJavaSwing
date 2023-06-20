package x1;
public class Producto {
    private String nombre;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int existencias;

    public Producto( String nombre, String descripcion, double precioCompra, double precioVenta, int existencias) {
       
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.existencias = existencias;
    }

    // Getters y setters para cada atributo


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

	@Override
	public String toString() {
		return  nombre+"/" + descripcion+"/" 
				+ precioCompra+"/"  + precioVenta+"/"  + existencias;
	}

 
}