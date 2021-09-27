package ejemplo1;

import java.util.Comparator;

public class CompararPrecio implements Comparator<AbsProducto>{

	@Override
	public int compare(AbsProducto arg0, AbsProducto arg1) {
		int var;
		var= arg0.getNombre().compareTo(arg1.getNombre()) ;
		return var;
	}
	
	

}
