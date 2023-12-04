package uniandes.dppo.taller2.modelo;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProductoMenuTest {
	@Test
    public void testConstructor() {
        ProductoMenu producto = new ProductoMenu("Hamburguesa", 100);

        assertNotNull(producto);
        assertEquals("Hamburguesa", producto.getNombre());
        assertEquals(100, producto.getPrecio());
    }

    @Test
    public void testGenerarTextoFactura() {
        ProductoMenu producto = new ProductoMenu("Papas Fritas", 50);

        String textoFactura = producto.generarTextoFactura();

        assertEquals("", textoFactura);
    }


    @Test
    public void testGetNombre() {
        ProductoMenu producto = new ProductoMenu("Soda", 20);

        assertEquals("Soda", producto.getNombre());
    }

    @Test
    public void testGetPrecio() {
        ProductoMenu producto = new ProductoMenu("Ensalada", 30);

        assertEquals(30, producto.getPrecio());
    }
}
