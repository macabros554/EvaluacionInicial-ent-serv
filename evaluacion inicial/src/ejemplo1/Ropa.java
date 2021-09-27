package ejemplo1;

public class Ropa extends AbsProducto{

	private TipoRopa laRopa;
	private String talla;
	public Ropa(String nombre, String producto, double precio, TipoRopa laRopa, String talla) throws Exception {
		super(nombre, producto, precio);
		this.laRopa = laRopa;
		this.talla = talla;
	}
	public TipoRopa getLaRopa() {
		return laRopa;
	}
	public void setLaRopa(TipoRopa laRopa) {
		this.laRopa = laRopa;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ "ropa [laRopa=" + laRopa + ", talla=" + talla + "]";
	}
	
	
	
}
