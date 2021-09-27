package ejemplo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Tienda implements Contar{

	private HashSet<AbsProducto> listaProductos;
	
	public Tienda() {
		super();
		this.listaProductos = new HashSet <AbsProducto>();
	}
	
	public boolean anadirBebida(String nombre, String producto, double precio, double litros) throws Exception{
		return listaProductos.add(new Bebidas(nombre, producto, precio, litros));
	}
	public boolean anadirComida(String nombre, String producto, double precio, double gramos) throws Exception{
		return listaProductos.add(new Comidas(nombre, producto, precio, gramos));
	}
	public boolean anadirRopa(String nombre, String producto, double precio, TipoRopa tipoRopa, String talla) throws Exception{
		return listaProductos.add(new Ropa(nombre, producto, precio, tipoRopa, talla));
	}
	
	public boolean borrarProducto (int cod) throws Exception{
		
		AbsProducto aux = null;
		boolean aux2= false;
		
		Iterator<AbsProducto> iterator = listaProductos.iterator();
		
		while(iterator.hasNext()&& aux2==false) {
			aux = (AbsProducto) iterator.next();
			if(aux.getCodigo()==cod) {
				aux2=listaProductos.remove(aux);
			}
		}
		
		return true;
	}
	
	public void cambiarPrecio(int cod,double precio) throws Exception {
		
		AbsProducto aux = null;
		boolean aux2= false;
		
		Iterator<AbsProducto> iterator = listaProductos.iterator();
		
		while(iterator.hasNext()&& aux2==false) {
			aux = (AbsProducto) iterator.next();
			if(aux.getCodigo()==cod) {
				aux2=listaProductos.remove(aux);
				aux.setPrecio(precio);
				listaProductos.add(aux);
			}
		}
		
	}
	
	@Override
	public int contarProducto(String producto) {
		
		TipProducto conversor= TipProducto.valueOf(producto.toUpperCase());
		int cont=0;
		
		
		for (AbsProducto i : listaProductos) {
			if(conversor==i.getProducto()) {
				cont +=1 ;
			}
		}
		
		return cont;
	}
	
	public String listaProductosOrNombre() {
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<AbsProducto> gOrdenado = new ArrayList<AbsProducto>(listaProductos);
		Collections.sort(gOrdenado,new CompararNombre());
		
		for(AbsProducto i : gOrdenado) {
			sb.append(i+"\n");
		}
		return sb.toString();
		}
	
	public String listaProductosOrPrecio() {
		
		StringBuilder sb = new StringBuilder();
		
		ArrayList<AbsProducto> gOrdenado = new ArrayList<AbsProducto>(listaProductos);
		Collections.sort(gOrdenado,new CompararPrecio());
		
		for(AbsProducto i : gOrdenado) {
			sb.append(i+"\n");
		}
		return sb.toString();
		}
}
