package ejemplo1;

public abstract class AbsProducto {

	private String nombre;
	private TipProducto producto;
	private double precio;
	private static int codigo = 0;
	
	public double getCodigo() {
		return codigo;
	}

	public AbsProducto(String nombre, String producto, double precio) throws Exception {
		super();
		this.nombre= nombre;
		this.producto = TipProducto.valueOf(producto.toUpperCase()) ;
		this.precio=precio;
		AbsProducto.codigo+=1;
		
		if (precio<0) {
			throw new Exception("El precio no puede ser negativo");
		}
	}

	public TipProducto getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = TipProducto.valueOf(producto.toUpperCase());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) throws Exception {
		if (precio<0) {
			throw new Exception("El precio no puede ser negativo");
		}else {
			this.precio = precio;
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(codigo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbsProducto other = (AbsProducto) obj;
		if (Double.doubleToLongBits(codigo) != Double.doubleToLongBits(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbsProducto [nombre=" + nombre + ", producto=" + producto + ", precio=" + precio + ",codigo=" + codigo +"]";
	}


	
}
