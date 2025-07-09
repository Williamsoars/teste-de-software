package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCliente {
    @Test
    void criarCliente_dadosValidos_deveCriar() {
        Cliente c = new Cliente("João", "12345678900");
        assertEquals("João", c.getNome());
        assertEquals("12345678900", c.getCpf());
    }
}
