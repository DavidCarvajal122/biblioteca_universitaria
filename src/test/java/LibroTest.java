import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LibroTest {

    @Test
    void deberiaCrearLibroDisponible() {
        Libro libro = new Libro("1984", "George Orwell");

        assertEquals("1984", libro.getTitulo());
        assertEquals("George Orwell", libro.getAutor());
        assertTrue(libro.estaDisponible());
    }

    @Test
    void deberiaPrestarLibroDisponible() {
        Libro libro = new Libro("1984", "George Orwell");

        libro.prestar();

        assertFalse(libro.estaDisponible());
    }

    @Test
    void deberiaLanzarErrorAlPrestarLibroNoDisponible() {
        Libro libro = new Libro("1984", "George Orwell");

        libro.prestar();

        assertThrows(
            IllegalStateException.class,
            libro::prestar
        );
    }
}