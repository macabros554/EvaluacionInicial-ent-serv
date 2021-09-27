package ejemplo1;

public class Comidas extends AbsProducto{

	private double gramos;

	public Comidas(String nombre, String producto, double precio, double gramos) throws Exception {
		super(nombre, producto, precio);
		this.gramos = gramos;
	}

	public double getGramos() {
		return gramos;
	}

	public void setGramos(double gramos) {
		this.gramos = gramos;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "comidas [gramos=" + gramos + "]";
	}
	
	
	
}
