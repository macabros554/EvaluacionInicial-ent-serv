package ejemplo1;

public class Bebidas extends AbsProducto{
	
	
	private double litros;

	public Bebidas(String nombre, String producto, double precio, double litros) throws Exception{
		super(nombre, producto, precio);
		this.litros = litros;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "bebidas [litros=" + litros + "]";
	}
	
	
	
	
	
	

}
