package uniandes.dppo.taller2.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IngredienteRepetidoException extends HamburguesaException{
	public IngredienteRepetidoException(String mensaje) {
		super(mensaje);
	}
		private void verificarIngredientesRepetidos(List<Ingrediente> ingredientes) throws IngredienteRepetidoException {
	        Set<String> nombres = new HashSet<>();
	        for (Ingrediente ingrediente : ingredientes) {
	            if (!nombres.add(ingrediente.getNombre())) {
	                throw new IngredienteRepetidoException("Error: Ingrediente repetido - " + ingrediente.getNombre());
	            }
	        }
        
    }
	
}
