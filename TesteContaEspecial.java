package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteContaEspecial {
    @Test
    void sacar_dentroDoLimite_sucesso() {
        ContaEspecial c = new ContaEspecial("1", 100, 50);
        c.sacar(130);
        assertEquals(-30, c.getSaldo());
    }

    @Test
    void sacar_acimaDoLimite_excecao() {
        ContaEspecial c = new ContaEspecial("1", 100, 50);
        assertThrows(IllegalArgumentException.class, () -> c.sacar(160));
    }
}
