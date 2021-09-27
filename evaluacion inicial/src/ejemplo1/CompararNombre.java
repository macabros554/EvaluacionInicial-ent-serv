package ejemplo1;

import java.util.Comparator;

public class CompararNombre implements Comparator<AbsProducto>{

	@Override
	public int compare(AbsProducto arg0, AbsProducto arg1) {
		int var = 0;
		if(arg0.getPrecio()>arg1.getPrecio()) {
			var=1;
		}else if(arg0.getPrecio()==arg1.getPrecio()) {
			var=0;
		}else if(arg0.getPrecio()<arg1.getPrecio()) {
			var=-1;
		}
		return var;
	}
}
