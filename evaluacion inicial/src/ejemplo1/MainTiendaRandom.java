package ejemplo1;

import java.util.Scanner;

public class MainTiendaRandom {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		int opc;
		String beb="bebida";
		String com="comida";
		String rop="ropa";
		
		Tienda ti = new Tienda();
		
		do {
			menu();
			opc = leerEntero("Introduzca la opción deseada");
			switch (opc) {
			case 1:
				ti.anadirBebida(leerCadena("nombre: "), beb, leerReal("precio: "), leerReal("litros: "));
				break;
			case 2:
				ti.anadirComida(leerCadena("nombre: "), com, leerReal("precio: "), leerReal("gramos: "));
				break;
			case 3:
				System.out.println("Los tipos de ropa son: Camisa,Camiseta,Pantalones,Zapatos,Calcetines");
				ti.anadirRopa(leerCadena("nombre: "), rop, leerReal("precio: "), TipoRopa.valueOf(leerCadenaM("TipoRopa: ")), leerCadena("talla(letras): "));
				break;
			case 4:
				ti.borrarProducto(leerEntero("introduce el codigo del producto: "));
				break;
			case 5:
				ti.contarProducto(leerCadena("producto: "));
				break;
			case 6:
				System.out.println(ti.listaProductosOrNombre());
				break;
			case 7:
				System.err.println(ti.listaProductosOrPrecio());
				break;
			case 8:
				ti.cambiarPrecio(leerEntero("introduce el codigo del producto: "), leerReal("Introduce el nuevo precio: "));;
				break;
			case 9:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		}while (opc !=9);
		

	}
	
	public static void menu() {
		System.out.println("1.-Añadir bebida\n"+
							"2.-Añadir comida\n"+
							"3.-Añadir ropa\n"+
							"4.-Borrar producto\n"+
							"5.-Contar tipo de producto\n"+
							"6.-Listar por nombre\n"+
							"7.-Listar por precio\n"+
							"8.-Cambiar precio\n"+
							"9.-Salir\n"
				);
	}
	
	public static int leerEntero(String msg) {
		System.out.println(msg);
		return Integer.parseInt(teclado.nextLine());
	}
	
	public static String leerCadena(String msg) {
		System.out.println(msg);
		return teclado.nextLine();
	}
	
	public static String leerCadenaM(String msg) {
		System.out.println(msg);
		return teclado.nextLine().toUpperCase();
	}
	
	public static double leerReal(String msg) {
		System.out.println(msg);
		return Double.parseDouble(teclado.nextLine());
	}

}
