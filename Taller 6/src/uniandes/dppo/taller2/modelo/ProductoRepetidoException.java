package uniandes.dppo.taller2.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoRepetidoException extends HamburguesaException{
	public ProductoRepetidoException(String mensaje) {
        super(mensaje);
    }
	private void verificarProductoRepetidoException(List<ProductoMenu> products) throws ProductoRepetidoException {
        Set<String> nombres = new HashSet<>();
        for (ProductoMenu product : products) {
            if (!nombres.add(product.getNombre())) {
                throw new ProductoRepetidoException("Error: Ingrediente repetido - " + product.getNombre());
            }
       }
	}
}
	


