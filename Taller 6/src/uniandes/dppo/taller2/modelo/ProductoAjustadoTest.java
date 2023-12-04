package uniandes.dppo.taller2.modelo;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductoAjustadoTest {

    @Test
    public void testAgregarIngrediente() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 100);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        Ingrediente queso = new Ingrediente("Queso", 10);

        productoAjustado.agregarIngrediente(queso);

        assertEquals(base.getPrecio() + queso.getCostoAdicional(), productoAjustado.getPrecio());
    }

    @Test
    public void testEliminarIngrediente() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 100);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        Ingrediente tomate = new Ingrediente("Tomate", 5);
        productoAjustado.agregarIngrediente(tomate);

        productoAjustado.eliminarIngrediente(tomate);

        assertEquals(base.getPrecio(), productoAjustado.getPrecio());
    }

   
    @Test
    public void testGetPrecio() {
        ProductoMenu base = new ProductoMenu("Hamburguesa", 100);
        ProductoAjustado productoAjustado = new ProductoAjustado(base);
        Ingrediente queso = new Ingrediente("Queso", 10);
        productoAjustado.agregarIngrediente(queso);

        assertEquals(base.getPrecio() + queso.getCostoAdicional(), productoAjustado.getPrecio());
    }

}
